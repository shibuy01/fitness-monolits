package com.project_fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_fitness.model.Activity;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {
}
