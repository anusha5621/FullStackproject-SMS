package FullStackProject.StudentManagementSystem.Controller;
import java.util.*;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import FullStackProject.StudentManagementSystem.Model.Student;
import FullStackProject.StudentManagementSystem.Repository.SchoolRepository;
import FullStackProject.StudentManagementSystem.ServiceImplementation.StudentServiceImplementation;
@CrossOrigin
//@RestController is used to create web services that return JSON or XML data.
@RestController

//@RequestMapping used to map HTTP requests to handler methods of MVC and REST controllers.
@RequestMapping("/studentmanagement.com")


/*
 StudentController class is key to handle the request from the user and send response if present. 
 or else send the request to the service class which helps in resolving the request.
 */
public class StudentController {

	//used to inject dependencies automatically
	@Autowired
	private  StudentServiceImplementation studentService;
@Autowired
private SchoolRepository schoolRepository;
	//API to create a record in database
	@PostMapping("/saveStudent/{schoolCode}")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student, @PathVariable("schoolCode")int schoolCode){
		
		try {
			schoolRepository.findById(schoolCode).map(school -> {
				student.setSchool(school);
			
			return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
			}).orElseThrow(() -> new Exception("Internal_Server_Error") );
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

	//API to update record in Database
	@PutMapping("/updateStudentDetails/{studentRollNo}")
	public ResponseEntity<Student> updateStudentDetailsById(@PathVariable("studentRollNo") int StudentRollNo,
			@RequestBody Student student){
		try {
			return new ResponseEntity<Student>(studentService.updateStudentDetails(StudentRollNo,student), HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//API to read all the values from the Database
	@GetMapping("/fetchAllStudents")
	public ResponseEntity<List<Student>> getAllStudentsFromDb(@RequestParam(required = false) String studentName) {
		try {
			List<Student> students = new ArrayList<Student>();

			if (studentName == null)
				studentService.getAllStudentFromDb(studentName).forEach(students::add);
			else
				studentService.fetchFilteredStudents(studentName).forEach(students::add);

			if (students.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}


	}

	//API to read a student with particular StudentRollNo 
	@GetMapping("/fetchStudentByStudentId/{studentRollNo}")
	public ResponseEntity<Student>getStudentById(@PathVariable("studentRollNo")int studentRollNo){
		try {
			return new ResponseEntity<Student>(studentService.getStudentById(studentRollNo),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//API to delete a student from the database with particular StudentRollNo
	@DeleteMapping("/deleteStudentById/{studentRollNo}")
	public ResponseEntity<Student>deleteStudentById(@PathVariable("studentRollNo")int studentRollNo) {

		Optional<Student> studentData =studentService.deleteStudentById(studentRollNo);
		try {
			if (studentData.isPresent()) {
				studentService.deleteStudentById(studentRollNo);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//API to delete all the students from DataBdse
	@DeleteMapping("/deleteAllStudents")
	public ResponseEntity<Student> deleteAllStudents() {
		try {
			studentService.deleteAllStudents();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception exc) {

			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//API to read the isSecondaryStudent record
	@GetMapping("/isSecondary")

	public ResponseEntity<List<Student>>getSecondaryStudents(){
		try {
			return new ResponseEntity<List<Student>>(studentService.checkIfStudentIsSecondary(true),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//API to read the isNotSecondaryStudent record
	@GetMapping("/isNotSecondary")
	public ResponseEntity<List<Student>> getNotSecondaryStudents(){
		try {
			return new ResponseEntity<List<Student>>(studentService.checkIfStudentIsNotSecondary(false),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

       @GetMapping("/readAllStudentsByGrade" )
	public ResponseEntity<List<Student>> fetchAllStudentByGrade(@RequestParam("qualification") String qualification) {

    	   try {
    			List<Student> students = new ArrayList<Student>();
    			
    			if(qualification==null)
    				studentService.getAllStudentFromDb(qualification).forEach(students::add);
    			
    			else
    				studentService. getAllStudentsByGrade(qualification).forEach(students::add);
    			
    			if(students.isEmpty())
    				return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
    			
    		    return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
    		    
    		}
    			catch(Exception exc) {
    				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    			}
    		}
       @GetMapping("/readAllStudentsBylocation" )
   	public ResponseEntity<List<Student>> getAllStudentByLocation(@RequestParam("location") String location) {

       	   try {
       			List<Student> students = new ArrayList<Student>();
       			
       			if(location==null)
       				studentService.getAllStudentFromDb(location).forEach(students::add);
       			
       			else
       				studentService. getAllStudentByLocation(location).forEach(students::add);
       			
       			if(students.isEmpty())
       				return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
       			
       		    return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
       		    
       		}
       			catch(Exception exc) {
       				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
       			}
       		}
      


	@GetMapping("/sortByMarks/{direction}")
	public ResponseEntity<List<Student>> getAllStudentsByMarksSort(@PathVariable("direction") String direction, @RequestParam("fieldName")String fieldName){
		try {
		List<Student> studentMarks = new ArrayList<Student>();
		studentMarks = studentService.sortByMarks(direction, fieldName);
		if(studentMarks.isEmpty())
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
	
	    return new ResponseEntity<List<Student>>(studentMarks,HttpStatus.OK);
		
	}
		catch(Exception exc) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/sortByStudentName/{direction}")
	public ResponseEntity<List<Student>> sortByStudentName(@PathVariable("direction") String direction, @RequestParam(required = true)String fieldName){
		try {
		List<Student> studentNames = new ArrayList<Student>();
		studentNames = studentService.sortByStudentName(direction, fieldName);
		if(studentNames.isEmpty())
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
	
	    return new ResponseEntity<List<Student>>(studentNames,HttpStatus.OK);
		
	}
		catch(Exception exc) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}


