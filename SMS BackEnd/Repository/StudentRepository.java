package FullStackProject.StudentManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FullStackProject.StudentManagementSystem.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    List<Student> findByIsSecondaryStudent(Boolean studentObject);
    Iterable<Student> findByLocationContainingIgnoreCase(String location);
	Iterable<Student> findByStudentNameContainingIgnoreCase(String studentName);
	List<Student> findByQualificationContainingIgnoreCase(String qualification);
}
