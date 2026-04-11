package com.project_fitness.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ForeignKey;

@Entity
public class Recommendation {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false, foreignKey =@ForeignKey(name="fk_recommendation_user"))
	@JsonIgnore
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activity_id", nullable=false, foreignKey =@ForeignKey(name="fk_recommendation_activity"))
	private Activity activity;
	
	private String type;
	
	@Column(length=2000)
	private String recommendation;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "json")
	private List<String> improvements;
	

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "json")
	private List<String> suggestions;
	

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(columnDefinition = "json")
	private List<String> safety;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public Recommendation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recommendation(String id, User user, Activity activity, String type, String recommendation,
			List<String> improvements, List<String> suggestions, List<String> safety, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.user = user;
		this.activity = activity;
		this.type = type;
		this.recommendation = recommendation;
		this.improvements = improvements;
		this.suggestions = suggestions;
		this.safety = safety;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public List<String> getImprovements() {
		return improvements;
	}

	public void setImprovements(List<String> improvements) {
		this.improvements = improvements;
	}

	public List<String> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<String> suggestions) {
		this.suggestions = suggestions;
	}

	public List<String> getSafety() {
		return safety;
	}

	public void setSafety(List<String> safety) {
		this.safety = safety;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Recommendation [id=" + id + ", user=" + user + ", activity=" + activity + ", type=" + type
				+ ", recommendation=" + recommendation + ", improvements=" + improvements + ", suggestions="
				+ suggestions + ", safety=" + safety + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
