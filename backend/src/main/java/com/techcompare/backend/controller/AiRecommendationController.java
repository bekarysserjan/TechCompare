package com.techcompare.backend.controller;

import com.techcompare.backend.dto.AiRecommendationRequest;
import com.techcompare.backend.dto.AiRecommendationResponse;
import com.techcompare.backend.service.AiRecommendationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "http://localhost:5173")
public class AiRecommendationController {

    private final AiRecommendationService aiRecommendationService;

    public AiRecommendationController(
            AiRecommendationService aiRecommendationService) {

        this.aiRecommendationService = aiRecommendationService;
    }

    @PostMapping("/recommend")
    public AiRecommendationResponse recommend(
            @Valid @RequestBody AiRecommendationRequest request) {

        return aiRecommendationService.generateRecommendation(request);
    }
}