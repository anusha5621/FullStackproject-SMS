package FullStackProject.StudentManagementSystem.Model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@DynamicUpdate
@Entity
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false, unique=true,length=10)
	private Integer schoolCode;
	@Column(nullable=false, unique=true,length=100,updatable=true)
	private String schoolName ;
	@Override
	public String toString() {
		return "School [schoolCode=" + schoolCode + ", schoolName=" + schoolName + ", schoolLocation=" + schoolLocation
				+ ", schoolFounder=" + schoolFounder + ", establishedYear=" + establishedYear + ", principalName="
				+ principalName + "]";
	}

	
	private String schoolLocation;
	@Column(nullable=false, unique=true,length=100,updatable=false)
	private String schoolFounder;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Column(nullable=false, unique=true,length=100,updatable=false)
	private Date establishedYear;
	@Column(nullable=false, unique=true,length=100,updatable=true)
	private String principalName;
	public Integer getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(Integer schoolCode) {
		this.schoolCode = schoolCode;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolLocation() {
		return schoolLocation;
	}
	public void setSchoolLocation(String schoolLocation) {
		this.schoolLocation = schoolLocation;
	}
	public String getSchoolFounder() {
		return schoolFounder;
	}
	public void setSchoolFounder(String schoolFounder) {
		this.schoolFounder = schoolFounder;
	}
	public Date getEstablishedYear() {
		return establishedYear;
	}
	public void setEstablishedYear(Date establishedYear) {
		this.establishedYear = establishedYear;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	@JsonManagedReference
	@OneToMany(mappedBy="school")

	private List<Student> student;
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	@OneToMany(mappedBy="school")
	@JsonIgnore
	private List<Feedback> feedback;

	public List<Feedback> getFeedback() {
		return feedback;
	}
}
