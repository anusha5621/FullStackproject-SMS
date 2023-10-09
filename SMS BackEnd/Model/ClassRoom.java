package FullStackProject.StudentManagementSystem.Model;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@DynamicUpdate
@Entity
public class ClassRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false, unique=true,length=10)
	private Integer classRoomNo;
	@Column(nullable=false, unique=false,length=100,updatable=true)
	private String className;
	@Column(nullable=false, unique=false,length=200,updatable=true)
	private String description;
	public Integer getClassRoomNo() {
		return classRoomNo;
	}
	public void setClassRoomNo(Integer classRoomNo) {
		this.classRoomNo = classRoomNo;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
@OneToMany(mappedBy="classRoom",cascade = jakarta.persistence.CascadeType.ALL)
	@JsonIgnore
	private List <Student> student ;
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@ManyToOne(fetch=FetchType.EAGER)

	private Teacher teacher;
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
