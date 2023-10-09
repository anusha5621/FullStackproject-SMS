package FullStackProject.StudentManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import FullStackProject.StudentManagementSystem.Model.School;
import FullStackProject.StudentManagementSystem.Model.Teacher;

public interface TeacherRepository  extends JpaRepository<Teacher ,Integer>{

}
