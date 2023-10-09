package FullStackProject.StudentManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedBackId;
	
private String comments;

@ManyToOne
@JsonIgnore
	private User user;
	
@ManyToOne
@JsonIgnore
private School school;
	
	
	
	public School getSchool() {
	return school;
}

public void setSchool(School school) {
	this.school = school;
}

	public Integer getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(Integer feedBackId) {
		this.feedBackId = feedBackId;
	}

	public Integer getSchoolRating() {
		return schoolRating;
	}

	public void setSchoolRating(Integer schoolRating) {
		this.schoolRating = schoolRating;
	}

	public Integer getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(Integer overallRating) {
		this.overallRating = overallRating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	@Min(value=1, message="Rating must be in range of 1-5")
	@Max(value=5, message="Rating must be in range of 1-5")
	private Integer schoolRating;
	
	@Min(value=1, message="Rating must be in range of 1-5")
	@Max(value=5, message="Rating must be in range of 1-5")
	private Integer overallRating;



	@Override
	public String toString() {
		return "Feedback [feedBackId=" + feedBackId + ", comments=" + comments + ", user=" + user + ", school=" + school
				+ ", schoolRating=" + schoolRating + ", overallRating=" + overallRating + "]";
	}



	
}