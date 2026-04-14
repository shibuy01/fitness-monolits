package com.project_fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_fitness.model.Activity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {
    List<Activity> findByUserId(String userId);
}
