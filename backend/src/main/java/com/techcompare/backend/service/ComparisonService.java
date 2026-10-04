package com.techcompare.backend.service;

import com.techcompare.backend.dto.ComparisonRequest;
import com.techcompare.backend.dto.ComparisonResponse;
import com.techcompare.backend.dto.DeviceComparisonDTO;
import com.techcompare.backend.dto.PreferenceWeights;
import com.techcompare.backend.model.Device;
import com.techcompare.backend.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComparisonService {

    private final DeviceRepository deviceRepository;
    private final ScoringService scoringService;
    private final LaptopScoringService laptopScoringService;
    private final DeviceComparisonMapper deviceComparisonMapper;

    public ComparisonService(
            DeviceRepository deviceRepository,
            ScoringService scoringService,
            LaptopScoringService laptopScoringService,
            DeviceComparisonMapper deviceComparisonMapper) {
        this.deviceRepository = deviceRepository;
        this.scoringService = scoringService;
        this.laptopScoringService = laptopScoringService;
        this.deviceComparisonMapper = deviceComparisonMapper;
    }

    public ComparisonResponse compareDevices(ComparisonRequest request) {
        List<Long> deviceIds = request.getDeviceIds();
        if (deviceIds == null || deviceIds.size() < 2 || deviceIds.size() > 3) {
            throw new IllegalArgumentException("You must compare 2 or 3 devices");
        }
        if (deviceIds.stream().distinct().count() != deviceIds.size()) {
            throw new IllegalArgumentException("You cannot compare the same device more than once");
        }

        List<Device> devices = deviceRepository.findAllById(deviceIds);
        if (devices.size() != deviceIds.size()) {
            throw new IllegalArgumentException("One or more devices were not found");
        }

        String category = devices.get(0).getCategory();
        boolean sameCategory = devices.stream().allMatch(d -> category != null && category.equalsIgnoreCase(d.getCategory()));
        if (!sameCategory) {
            throw new IllegalArgumentException("Devices must belong to the same category");
        }

        boolean isLaptop = "laptop".equalsIgnoreCase(category);
        PreferenceWeights weights = request.getWeights();
        if (weights == null) {
            weights = new PreferenceWeights();
            weights.setGaming(isLaptop ? 40 : 33);
            if (isLaptop) {
                weights.setCreator(30);
                weights.setDailyProductivity(30);
            } else {
                weights.setPhotography(34);
                weights.setDailyUse(33);
            }
        }
        validateWeights(weights, isLaptop);

        Map<Long, Double> gamingScores = new HashMap<>();
        Map<Long, Double> photographyScores = isLaptop ? null : new HashMap<>();
        Map<Long, Double> dailyUseScores = isLaptop ? null : new HashMap<>();
        Map<Long, Double> creatorScores = isLaptop ? new HashMap<>() : null;
        Map<Long, Double> dailyProductivityScores = isLaptop ? new HashMap<>() : null;
        Map<Long, Double> overallScores = new HashMap<>();
        List<DeviceComparisonDTO> comparisonDevices = new ArrayList<>();

        for (Device device : devices) {
            double gamingScore = isLaptop
                    ? laptopScoringService.calculateGamingScore(device)
                    : scoringService.calculateGamingScore(device);
            double secondScore = isLaptop
                    ? laptopScoringService.calculateCreatorScore(device)
                    : scoringService.calculatePhotographyScore(device);
            double thirdScore = isLaptop
                    ? laptopScoringService.calculateDailyProductivityScore(device)
                    : scoringService.calculateDailyUseScore(device);

            double overallScore;
            if (isLaptop) {
                overallScore = gamingScore * weights.getGaming() / 100.0
                        + secondScore * weights.getCreator() / 100.0
                        + thirdScore * weights.getDailyProductivity() / 100.0;
                creatorScores.put(device.getId(), secondScore);
                dailyProductivityScores.put(device.getId(), thirdScore);
            } else {
                overallScore = gamingScore * weights.getGaming() / 100.0
                        + secondScore * weights.getPhotography() / 100.0
                        + thirdScore * weights.getDailyUse() / 100.0;
                photographyScores.put(device.getId(), secondScore);
                dailyUseScores.put(device.getId(), thirdScore);
            }
            overallScores.put(device.getId(), Math.round(overallScore * 10.0) / 10.0);
            gamingScores.put(device.getId(), gamingScore);
            comparisonDevices.add(deviceComparisonMapper.toDTO(device));
        }

        return new ComparisonResponse(
                comparisonDevices,
                gamingScores,
                photographyScores,
                dailyUseScores,
                creatorScores,
                dailyProductivityScores,
                overallScores,
                weights);
    }

    private void validateWeights(PreferenceWeights weights, boolean isLaptop) {
        Integer gaming = weights.getGaming();
        Integer second = isLaptop ? weights.getCreator() : weights.getPhotography();
        Integer third = isLaptop ? weights.getDailyProductivity() : weights.getDailyUse();
        String secondName = isLaptop ? "creator" : "photography";
        String thirdName = isLaptop ? "dailyProductivity" : "dailyUse";

        if (gaming == null || second == null || third == null) {
            throw new IllegalArgumentException("Weights must include gaming, " + secondName + ", and " + thirdName);
        }
        if (gaming < 0 || gaming > 100 || second < 0 || second > 100 || third < 0 || third > 100) {
            throw new IllegalArgumentException("Each preference weight must be between 0 and 100");
        }
        if (gaming + second + third != 100) {
            throw new IllegalArgumentException("Preference weights must add up to 100");
        }
    }
}
