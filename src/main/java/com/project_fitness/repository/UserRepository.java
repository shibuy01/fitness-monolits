package com.project_fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project_fitness.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
