package com.techcompare.backend.dto;

public class AiRecommendationResponse {

    private String recommendation;

    public AiRecommendationResponse() {
    }

    public AiRecommendationResponse(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}