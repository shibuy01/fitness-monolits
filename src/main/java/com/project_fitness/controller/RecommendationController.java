package com.project_fitness.controller;

import com.project_fitness.dto.RecommendationRequest;
import com.project_fitness.model.Recommendation;
import com.project_fitness.service.RecommendationService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendation")
@AllArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<> generateRecommendation(
            @RequestBody RecommendationRequest request
            ){
        Recommendation recommendation = recommendationService.getRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }
}
