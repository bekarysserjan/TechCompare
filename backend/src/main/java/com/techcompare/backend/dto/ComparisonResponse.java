package com.techcompare.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComparisonResponse {

    private List<DeviceComparisonDTO> devices;
    private Map<Long, Double> gamingScores;
    private Map<Long, Double> photographyScores;
    private Map<Long, Double> dailyUseScores;
    private Map<Long, Double> creatorScores;
    private Map<Long, Double> dailyProductivityScores;
    private Map<Long, Double> overallScores;
    private PreferenceWeights weights;

    public ComparisonResponse(
            List<DeviceComparisonDTO> devices,
            Map<Long, Double> gamingScores,
            Map<Long, Double> photographyScores,
            Map<Long, Double> dailyUseScores,
            Map<Long, Double> creatorScores,
            Map<Long, Double> dailyProductivityScores,
            Map<Long, Double> overallScores,
            PreferenceWeights weights) {
        this.devices = devices;
        this.gamingScores = gamingScores;
        this.photographyScores = photographyScores;
        this.dailyUseScores = dailyUseScores;
        this.creatorScores = creatorScores;
        this.dailyProductivityScores = dailyProductivityScores;
        this.overallScores = overallScores;
        this.weights = weights;
    }

    public List<DeviceComparisonDTO> getDevices() { return devices; }
    public Map<Long, Double> getGamingScores() { return gamingScores; }
    public Map<Long, Double> getPhotographyScores() { return photographyScores; }
    public Map<Long, Double> getDailyUseScores() { return dailyUseScores; }
    public Map<Long, Double> getCreatorScores() { return creatorScores; }
    public Map<Long, Double> getDailyProductivityScores() { return dailyProductivityScores; }
    public Map<Long, Double> getOverallScores() { return overallScores; }
    public PreferenceWeights getWeights() { return weights; }
}
