package FullStackProject.StudentManagementSystem.Model;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Student class contains all the attributes used to create  the records

// @Entity defines that a class can be mapped to a table 
@Entity

//@Table specifies the name of database table to be used for mapping
@Table(name = "student_details")

/*@DynamicUpdate is class level annotation that can be applied to a JPA entity
 *It ensures that Hibernate uses only the modified columns in the SQL statement
 *that it generates for the update of an entity.
 */
@DynamicUpdate
public class Student {

	//@Id specifies the primary key of the table
	@Id
	
	//@GeneratedValue is used to generate unique values for primary key automatically in the database. 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentRollNo;
	private String studentName;
	
	//@Column used to add the column name or else by default attribute name is the column name
	@Column(name = "studentContact", nullable = false)
	private Long studentMobile;
	@Column(name = "studentLocation", nullable = true, updatable=true)
	private String location;
    private String qualification;
	private String schoolName ;
	private Integer studentMarks;
	@Column(name = "SecondaryStudent")
	private Boolean isSecondaryStudent;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@OnDelete(action=OnDeleteAction.CASCADE)
	private School school;
	
	@ManyToOne
	@JsonIgnore
private ClassRoom classRoom;

	public ClassRoom getClassRoom() {
		return classRoom;
	}


	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}


	public School getSchool() {
		return school;
	}


	public void setSchool(School school) {
		this.school = school;
	}


	//Getter methods and Setter methods 
	public Integer getStudentRollNo() {
		return studentRollNo;
	}


	public void setStudentRollNo(Integer studentRollNo) {
		this.studentRollNo = studentRollNo;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public Long getStudentMobile() {
		return studentMobile;
	}


	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getSchoolName() {
		return schoolName;
	}


	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}


	public Integer getStudentMarks() {
		return studentMarks;
	}


	public void setStudentMarks(Integer studentMarks) {
		this.studentMarks = studentMarks;
	}


	public Boolean getIsSecondaryStudent() {
		return isSecondaryStudent;
	}


	public void setIsSecondaryStudent(Boolean isSecondaryStudent) {
		this.isSecondaryStudent = isSecondaryStudent;
	}


	@Override
	public String toString() {
		return "Student [studentRollNo=" + studentRollNo + ", studentName=" + studentName + ", studentMobile="
				+ studentMobile + ", location=" + location + ", qualification=" + qualification + ", schoolName="
				+ schoolName + ", studentMarks=" + studentMarks + ", isSecondaryStudent=" + isSecondaryStudent
				+ ", school=" + school + ", classRoom=" + classRoom + "]";
	}


	
}
