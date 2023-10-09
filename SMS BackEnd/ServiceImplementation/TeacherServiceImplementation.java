package FullStackProject.StudentManagementSystem.ServiceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FullStackProject.StudentManagementSystem.Model.School;
import FullStackProject.StudentManagementSystem.Model.Teacher;
import FullStackProject.StudentManagementSystem.Repository.TeacherRepository;
import FullStackProject.StudentManagementSystem.Service.TeacherService;
@Service
public class TeacherServiceImplementation implements TeacherService{
	@Autowired
private TeacherRepository teacherRepository;
	
	@Override
	public Teacher saveTeacher(Teacher nameofTeacher) {
		return teacherRepository.save(nameofTeacher);
		
	}
	
		
	@Override
	public List<Teacher> getAllTeachers( ) {
		List<Teacher> teachers = new ArrayList<Teacher>();
		teachers = teacherRepository.findAll();
		return teachers;
	}

	@Override
	public Teacher getTeacherById(int teacherId) {
		Optional<Teacher>teacher = teacherRepository.findById(teacherId);  
		if(teacher.isPresent()) {
			return teacher.get();
		}
		else {
			return null;
			}
	}

	@Override
	public Teacher updateTeacherDetails(int teacherId, Teacher updatedTeacherDetail) {
		 Optional<Teacher> teacher1 = teacherRepository.findById(teacherId);
			if(teacher1.isPresent()) {
				Teacher  existingTeacher = teacher1.get(); 
				existingTeacher.setTeacherName(updatedTeacherDetail.getTeacherName());
				existingTeacher.setSalary(updatedTeacherDetail.getSalary());
				existingTeacher.setTeachingsubject(updatedTeacherDetail.getTeachingsubject());
				teacherRepository.save(existingTeacher);
				return existingTeacher;
			}
			else {
				return null;
			}
	}
	


	@Override
	public Optional<Teacher> deleteTeacherById(int teacherId) {
		
		Optional<Teacher>teacher = teacherRepository.findById(teacherId);  
		if(teacher.isPresent()) {
			teacherRepository.deleteById(teacherId);
		}
		return teacher;
	}

	@Override
	public void deleteAllTeachers() {
		teacherRepository.deleteAll();
		System.out.println("All Teachers Deleted");
	}
		
	}


