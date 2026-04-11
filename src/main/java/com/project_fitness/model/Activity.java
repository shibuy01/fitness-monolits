package com.project_fitness.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ForeignKey;

@Entity
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", nullable = false,  foreignKey=@ForeignKey(name = "fk_activity_user"))
	@JsonIgnore
	private User user;
	
	@Enumerated(EnumType.STRING)
	private ActivityType type;
	
	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "json")
	private Map<String, Object> additionalMetrics;
	private Integer duration;
	private Integer caloriesBurned;
	private LocalDateTime startTime;
	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
	
	@OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, orphanRemoval=true)
	@JsonIgnore
	private List<Recommendation> recommendation = new ArrayList<>();

	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Activity(String id, User user, ActivityType type, Map<String, Object> additionalMetrics, Integer duration,
			Integer caloriesBurned, LocalDateTime startTime, LocalDateTime createdTime, LocalDateTime updatedTime,
			List<Recommendation> recommendation) {
		super();
		this.id = id;
		this.user = user;
		this.type = type;
		this.additionalMetrics = additionalMetrics;
		this.duration = duration;
		this.caloriesBurned = caloriesBurned;
		this.startTime = startTime;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.recommendation = recommendation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ActivityType getType() {
		return type;
	}

	public void setType(ActivityType type) {
		this.type = type;
	}

	public Map<String, Object> getAdditionalMetrics() {
		return additionalMetrics;
	}

	public void setAdditionalMetrics(Map<String, Object> additionalMetrics) {
		this.additionalMetrics = additionalMetrics;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getCaloriesBurned() {
		return caloriesBurned;
	}

	public void setCaloriesBurned(Integer caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public List<Recommendation> getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(List<Recommendation> recommendation) {
		this.recommendation = recommendation;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", user=" + user + ", type=" + type + ", additionalMetrics=" + additionalMetrics
				+ ", duration=" + duration + ", caloriesBurned=" + caloriesBurned + ", startTime=" + startTime
				+ ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", recommendation=" + recommendation
				+ "]";
	}
	
	
}
