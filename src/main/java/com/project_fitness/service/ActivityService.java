package com.project_fitness.service;

import com.project_fitness.dto.ActivityRequest;
import com.project_fitness.dto.ActivityResponse;
import com.project_fitness.model.Activity;
import com.project_fitness.model.User;
import com.project_fitness.repository.ActivityRepository;
import com.project_fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;


    public @Nullable ActivityResponse trackActivity(ActivityRequest activityRequest) {
        User user = userRepository.findById(activityRequest.getUserId()).orElseThrow(()-> new RuntimeException("User not found: " + activityRequest.getUserId()));
        Activity activity = Activity.builder()
                .user(user)
                .type(activityRequest.getType())
                .additionalMetrics(activityRequest.getAdditionalMetrics())
                .caloriesBurned(activityRequest.getCaloriesBurned())
                .startTime(activityRequest.getStartTime())
                .duration(activityRequest.getDuration())
                .build();
        Activity saveActivityResponse = activityRepository.save(activity);
        return mapToResponse(saveActivityResponse);
    }

    private @Nullable ActivityResponse mapToResponse(Activity saveActivityResponse) {
        ActivityResponse activityResponse = new ActivityResponse();
        activityResponse.setId(saveActivityResponse.getId());
        activityResponse.setUserId(saveActivityResponse.getUser().getId());
        activityResponse.setType(saveActivityResponse.getType());
        activityResponse.setAdditionalMetrics(saveActivityResponse.getAdditionalMetrics());
        activityResponse.setDuration(saveActivityResponse.getDuration());
        activityResponse.setStartTime(saveActivityResponse.getStartTime());
        activityResponse.setCreatedAt(activityResponse.getCreatedAt());
        activityResponse.setUpdatedAt(activityResponse.getUpdatedAt());

        return activityResponse;
    }

    public @Nullable List<ActivityResponse> getUserActivity(String userId) {
        List<Activity> activityList = activityRepository.findByUserId(userId);
        return activityList.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
}
