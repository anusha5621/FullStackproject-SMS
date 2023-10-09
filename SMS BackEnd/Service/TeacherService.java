package FullStackProject.StudentManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import FullStackProject.StudentManagementSystem.Model.Teacher;



public interface TeacherService {
	Teacher saveTeacher(Teacher nameofTeacher); 
	Teacher getTeacherById(int teacherId);
	Teacher  updateTeacherDetails(int teacherId  ,Teacher teacher );
	Optional<Teacher> deleteTeacherById(int teacherId  );
	void deleteAllTeachers();
	List<Teacher> getAllTeachers();

}
