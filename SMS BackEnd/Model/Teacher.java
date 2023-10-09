package FullStackProject.StudentManagementSystem.Model;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
@DynamicUpdate
@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false, unique=true,length=10)
	private Integer teacherId;
	@Column(nullable=false, unique=false,length=100,updatable=true)
	private String teacherName;
	@Column(nullable=false, unique=true,length=100,updatable=true)
	private String teachingsubject;
	@Column(nullable=false, unique=false,length=100,updatable=true)
	private Double salary;

	@OneToMany(mappedBy = "teacher" ,cascade=CascadeType.ALL)
@JsonIgnore
	private List<ClassRoom> classRoom;
	
	public List<ClassRoom> getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(List<ClassRoom> classRoom) {
		this.classRoom = classRoom;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeachingsubject() {
		return teachingsubject;
	}
	public void setTeachingsubject(String teachingsubject) {
		this.teachingsubject = teachingsubject;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teachingsubject="
				+ teachingsubject + ", salary=" + salary + ", classRoom=" + classRoom + "]";
	}
	


}
