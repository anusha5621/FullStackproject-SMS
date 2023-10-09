package FullStackProject.StudentManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FullStackProject.StudentManagementSystem.Model.School;
import FullStackProject.StudentManagementSystem.Model.Teacher;
import FullStackProject.StudentManagementSystem.ServiceImplementation.SchoolServiceImplementation;
import FullStackProject.StudentManagementSystem.ServiceImplementation.TeacherServiceImplementation;
@CrossOrigin
@RestController
@RequestMapping("/studentmanagement.com")
public class TeacherController {
	@Autowired
private TeacherServiceImplementation teacherService;
	public TeacherController(TeacherServiceImplementation teacherService)throws Exception {
		this.teacherService = teacherService;

	}
	@PostMapping("/saveTeacher")
	public ResponseEntity<Teacher>saveTeacher(@RequestBody Teacher teacher){
		try {
			return new ResponseEntity<Teacher>(teacherService.saveTeacher(teacher),HttpStatus.CREATED);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/updateTeacherDetails/{teacherId}")
	public ResponseEntity<Teacher> updateSchoolDetailsById(@PathVariable("teacherId") int teacherId,
			@RequestBody Teacher teacher )throws Exception{
		try {
			return new ResponseEntity<Teacher>(teacherService.updateTeacherDetails(teacherId,teacher), HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/readTeacher/{teacherId}")
	public ResponseEntity<Teacher>readById(@PathVariable("teacherId")Integer teacherId) throws Exception{
		try {
			return new ResponseEntity<Teacher>(teacherService.getTeacherById(teacherId),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteTeacher/{teacherId}")
	public void removeTeacherById(@PathVariable("teacherId") Integer teacherId) throws Exception{
		try {
			teacherService.deleteTeacherById(teacherId);
		}
	   catch(Exception exc) {
		   System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	}
	@DeleteMapping("/deleteAllTeachers")
	public void removeAllTeachers()throws Exception{
		try {
			teacherService.deleteAllTeachers();
		}
		catch(Exception exc) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/fetchAllTeachers")
	public ResponseEntity<List<Teacher>> fetchAllTeachers(){
		try {
			return new ResponseEntity<List<Teacher>>(teacherService.getAllTeachers(),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
