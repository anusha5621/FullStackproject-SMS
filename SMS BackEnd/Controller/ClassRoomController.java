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

import FullStackProject.StudentManagementSystem.Model.ClassRoom;
import FullStackProject.StudentManagementSystem.Model.Student;
import FullStackProject.StudentManagementSystem.Model.Teacher;
import FullStackProject.StudentManagementSystem.ServiceImplementation.ClassRoomServiceImplementation;
import FullStackProject.StudentManagementSystem.ServiceImplementation.TeacherServiceImplementation;
@CrossOrigin
@RestController
@RequestMapping("/studentmanagement.com")
public class ClassRoomController {
	@Autowired
	private ClassRoomServiceImplementation classRoomService;
	public ClassRoomController(ClassRoomServiceImplementation classRoomService)throws Exception {
		this.classRoomService = classRoomService;
}
	
	@PostMapping("/saveClassRoom/{teacherId}")

		
	public ResponseEntity<ClassRoom>saveClassRoom(@RequestBody ClassRoom classRoom,@PathVariable("teacherId")int teacherId){
		try {
			return new ResponseEntity<ClassRoom>(classRoomService.saveClassRoom(classRoom,teacherId),HttpStatus.CREATED);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/updateClassRoomDetails/{classRoomNo}")
	public ResponseEntity<ClassRoom> updateClassRoomDetails(@PathVariable("classRoomNo") int classRoomNo,
			@RequestBody ClassRoom classRoom )throws Exception{
		try {
			return new ResponseEntity<ClassRoom>(classRoomService.updateClassRoomDetails(classRoomNo,classRoom), HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/readClassRoom/{classRoomNo}")
	public ResponseEntity<ClassRoom>readById(@PathVariable("classRoomNo")Integer classRoomNo) throws Exception{
		try {
			return new ResponseEntity<ClassRoom>(classRoomService.getClassById(classRoomNo),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteClassRoom/{classRoomNo}")
	public void removeClassById(@PathVariable("classRoomNo") Integer classRoomNo) throws Exception{
		try {
			classRoomService.deleteClassById(classRoomNo);
		}
	   catch(Exception exc) {
		   System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	}
	@DeleteMapping("/deleteAllClassRooms")
	public void removeAllClasses()throws Exception{
		try {
			classRoomService.deleteAllClasses();
		}
		catch(Exception exc) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/fetchAllClassRooms")
	public ResponseEntity<List<ClassRoom>> fetchAllClassRooms(){
		try {
			return new ResponseEntity<List<ClassRoom>>(classRoomService.getAllClasses(),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
