package com.project_fitness.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private LocalDateTime createdAt;
	private LocalDateTime updateAt;
	
	@OneToMany(mappedBy = "user" ,cascade= CascadeType.ALL, orphanRemoval=true)
	@JsonIgnore
	private List<Activity> activity = new ArrayList<>();
	
	@OneToMany(mappedBy = "user" ,cascade= CascadeType.ALL, orphanRemoval=true)
	@JsonIgnore
	private List<Recommendation> recommendation = new ArrayList<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String id, String email, String password, String firstName, String lastName, LocalDateTime createdAt,
			LocalDateTime updateAt, List<Activity> activity, List<Recommendation> recommendation) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.activity = activity;
		this.recommendation = recommendation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public List<Activity> getActivity() {
		return activity;
	}

	public void setActivity(List<Activity> activity) {
		this.activity = activity;
	}

	public List<Recommendation> getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(List<Recommendation> recommendation) {
		this.recommendation = recommendation;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", createdAt=" + createdAt + ", updateAt=" + updateAt + ", activity="
				+ activity + ", recommendation=" + recommendation + "]";
	}
	
	
}
