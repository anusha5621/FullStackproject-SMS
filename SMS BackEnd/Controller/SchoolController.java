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

import FullStackProject.StudentManagementSystem.ServiceImplementation.SchoolServiceImplementation;
@CrossOrigin
@RestController
@RequestMapping("/studentmanagement.com")
public class SchoolController {
	@Autowired
private SchoolServiceImplementation schoolService;
	
	public SchoolController(SchoolServiceImplementation schoolService)throws Exception {
		this.schoolService = schoolService;
	}
	@PostMapping("/saveSchool")
	public ResponseEntity<School> saveSchool(@RequestBody School school){
		try {
			return new ResponseEntity<School>(schoolService.saveSchool(school),HttpStatus.CREATED);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/updateSchoolDetails/{schoolCode}")
	public ResponseEntity<School> updateSchoolDetailsById(@PathVariable("schoolCode") int schoolCode,
			@RequestBody School school)throws Exception{
		try {
			return new ResponseEntity<School>(schoolService.updateSchoolDetails(schoolCode,school), HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
@GetMapping("/readSchool/{schoolCode}")
public ResponseEntity<School>readById(@PathVariable("schoolCode")Integer schoolCode) throws Exception{
	try {
		return new ResponseEntity<School>(schoolService.getSchoolByCode(schoolCode),HttpStatus.OK);
	}
	catch(Exception exc) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@DeleteMapping("/deleteSchoolById/{schoolCode}")
public void deleteSchoolByCode(@PathVariable("schoolCode") Integer schoolCode) throws Exception{
	try {
		schoolService.deleteSchoolByCode(schoolCode);
	}
   catch(Exception exc) {
	   System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
@DeleteMapping("/deleteAllSchools")
public void deleteAllSchools()throws Exception{
	try {
		schoolService.deleteAllSchools();
	}
	catch(Exception exc) {
		System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping("/readAllSchools")
public ResponseEntity<List<School>> getAllSchools(){
	try {
		return new ResponseEntity<List<School>>(schoolService.getAllSchools(),HttpStatus.OK);
	}
	catch(Exception exc) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


	
	
	}






