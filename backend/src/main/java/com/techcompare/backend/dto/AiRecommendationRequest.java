package com.techcompare.backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.List;

public class AiRecommendationRequest {

    @Size(min = 2, max = 3, message = "You must provide 2 or 3 devices")
    private List<Long> deviceIds;

    @Valid
    private PreferenceWeights weights;

    public List<Long> getDeviceIds() {
        return deviceIds;
    }

    public void setDeviceIds(List<Long> deviceIds) {
        this.deviceIds = deviceIds;
    }

    public PreferenceWeights getWeights() {
        return weights;
    }

    public void setWeights(PreferenceWeights weights) {
        this.weights = weights;
    }
}