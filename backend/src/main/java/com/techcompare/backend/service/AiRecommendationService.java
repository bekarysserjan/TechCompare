package com.techcompare.backend.service;

import com.techcompare.backend.dto.AiRecommendationRequest;
import com.techcompare.backend.dto.AiRecommendationResponse;
import com.techcompare.backend.dto.ComparisonRequest;
import com.techcompare.backend.dto.ComparisonResponse;
import com.techcompare.backend.dto.DeviceComparisonDTO;
import com.techcompare.backend.dto.PreferenceWeights;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AiRecommendationService {
    private final ComparisonService comparisonService;
    private final GeminiService geminiService;

    public AiRecommendationService(ComparisonService comparisonService, GeminiService geminiService) {
        this.comparisonService = comparisonService;
        this.geminiService = geminiService;
    }

    public AiRecommendationResponse generateRecommendation(AiRecommendationRequest request) {
        ComparisonRequest comparisonRequest = new ComparisonRequest();
        comparisonRequest.setDeviceIds(request.getDeviceIds());
        comparisonRequest.setWeights(request.getWeights());
        ComparisonResponse comparison = comparisonService.compareDevices(comparisonRequest);
        return new AiRecommendationResponse(geminiService.askGemini(buildPrompt(comparison)));
    }

    private String buildPrompt(ComparisonResponse comparison) {
        StringBuilder prompt = new StringBuilder();
        boolean laptop = comparison.getDevices() != null && !comparison.getDevices().isEmpty()
                && "laptop".equalsIgnoreCase(comparison.getDevices().get(0).getCategory());
        PreferenceWeights weights = comparison.getWeights();
        Map<Long, Double> gamingScores = comparison.getGamingScores();
        Map<Long, Double> secondScores = laptop ? comparison.getCreatorScores() : comparison.getPhotographyScores();
        Map<Long, Double> thirdScores = laptop ? comparison.getDailyProductivityScores() : comparison.getDailyUseScores();
        Map<Long, Double> overallScores = comparison.getOverallScores();

        prompt.append("You are the AI assistant for TechCompare, a device comparison platform.\n")
                .append("Analyze only the data provided. Do not invent specifications or benchmarks.\n")
                .append("Use the calculated profile scores and overall scores. Keep the recommendation under 120 words.\n\n")
                .append("User preference weights:\n")
                .append("Gaming: ").append(weights.getGaming()).append("%\n")
                .append(laptop ? "Creator & CAD: " : "Photography: ")
                .append(laptop ? weights.getCreator() : weights.getPhotography()).append("%\n")
                .append(laptop ? "Daily Productivity: " : "Daily Use: ")
                .append(laptop ? weights.getDailyProductivity() : weights.getDailyUse()).append("%\n\n")
                .append("Devices:\n");

        List<DeviceComparisonDTO> devices = comparison.getDevices();
        for (DeviceComparisonDTO device : devices) {
            Long id = device.getId();
            prompt.append("\n--- Device ---\n")
                    .append("ID: ").append(id).append("\n")
                    .append("Brand: ").append(device.getBrand()).append("\n")
                    .append("Model: ").append(device.getModelName()).append("\n")
                    .append("Price: $").append(device.getPriceUsd()).append("\n")
                    .append("RAM: ").append(device.getRamGb()).append(" GB ").append(device.getRamType()).append("\n")
                    .append("Storage: ").append(device.getStorageGb()).append(" GB ").append(device.getStorageType()).append("\n")
                    .append("CPU: ").append(device.getCpuName()).append("\n")
                    .append("GPU: ").append(device.getGpuName()).append("\n")
                    .append("Display: ").append(device.getDisplayResolution()).append(", ").append(device.getDisplayRefreshRate()).append(" Hz\n");

            if (laptop) {
                prompt.append("GPU TGP / VRAM: ").append(device.getGpuTgpW()).append(" W / ").append(device.getVramGb()).append(" GB\n")
                        .append("CPU sustained power: ").append(device.getCpuSustainedPowerW()).append(" W\n")
                        .append("Independent Wi-Fi battery test: ").append(device.getIndependentWifiBatteryHours()).append(" hours\n")
                        .append("Display response / color gamut: ").append(device.getDisplayResponseTimeMs()).append(" ms / ")
                        .append(device.getDisplayDciP3Percent()).append("% DCI-P3\n")
                        .append("Maximum RAM / SSD slots: ").append(device.getMaxRamGb()).append(" GB / ").append(device.getSsdSlots()).append("\n")
                        .append("Weight / thickness: ").append(device.getWeightG()).append(" g / ").append(device.getThicknessMm()).append(" mm\n");
            } else {
                prompt.append("Battery: ").append(device.getBatteryMah()).append(" mAh\n")
                        .append("Main camera sensor: ").append(device.getMainSensorSize()).append("\n")
                        .append("Main camera aperture: ").append(device.getMainAperture()).append("\n")
                        .append("Optical zoom: ").append(device.getOpticalZoom()).append("\n")
                        .append("Video: ").append(device.getVideoCapabilities()).append("\n");
            }
            prompt.append("Gaming score: ").append(gamingScores.get(id)).append("\n")
                    .append(laptop ? "Creator & CAD score: " : "Photography score: ").append(secondScores.get(id)).append("\n")
                    .append(laptop ? "Daily Productivity score: " : "Daily Use score: ").append(thirdScores.get(id)).append("\n")
                    .append("Personalized overall score: ").append(overallScores.get(id)).append("\n");
        }
        prompt.append("\nGive a concise practical recommendation. Explain why a device matches the user's preferences, mention a useful alternative if relevant, and make no unsupported claims.");
        return prompt.toString();
    }
}
