package com.project_fitness.service;

import com.project_fitness.dto.RecommendationRequest;
import com.project_fitness.model.Activity;
import com.project_fitness.model.Recommendation;
import com.project_fitness.model.User;
import com.project_fitness.repository.ActivityRepository;
import com.project_fitness.repository.RecommendationRepository;
import com.project_fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RecommendationService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;

    public Recommendation getRecommendation(RecommendationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found" + request.getUserId()));

        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(() -> new RuntimeException("Activity not found" + request.getActivityId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .type(request.getType())
                .recommendation(request.getRecommendation())
                .build();
        Recommendation saveRecommendation = recommendationRepository.save(recommendation);
        return saveRecommendation;
    }

    public List<Recommendation> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public List<Recommendation> getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId);
    }
}
