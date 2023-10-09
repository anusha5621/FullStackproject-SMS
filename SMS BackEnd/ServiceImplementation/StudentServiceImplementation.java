package FullStackProject.StudentManagementSystem.ServiceImplementation;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import FullStackProject.StudentManagementSystem.Model.Student;
import FullStackProject.StudentManagementSystem.Repository.StudentRepository;
import FullStackProject.StudentManagementSystem.Service.StudentService;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
/*It is a implementation class for all the abstract methods present in StudentService interface.
@Service Annotation is used for organizing and separating business logic
     and data manipulation tasks in SpringBoot Application
*/
@Service
public class StudentServiceImplementation implements StudentService {
	
	//used to inject dependencies automatically
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private EmailService emailService;


	
//Going to database to create the record 
    @Override
	public Student saveStudent(Student student) {
    	System.out.println(student);
		return studentRepository.save(student);

	}
    
  //Going to database to fetch all the records 
	@Override
	public List<Student> getAllStudentFromDb(String name ) {
		if(name == null)
		return studentRepository.findAll();
		else
			  return (List<Student>) studentRepository.findByStudentNameContainingIgnoreCase(name);

	}

	//Going to database to fetch the student of particular StudentRollNo
	@Override
	public Student getStudentById(int studentRollNo) {
		System.out.println(studentRollNo);
		Optional<Student>student = studentRepository.findById(studentRollNo);  
		if(student.isPresent()) {
			/*System.out.println( student.get());
			Student studnDet =  student.get();
			System.out.println(studnDet.getSchool());*/
			return student.get();
		}
		else {
			return null;
			}
		}
	
	
	//method going to database to check for secondary student 
	public List<Student> checkIfStudentIsSecondary (Boolean booleanobj){
			List<Student> student=studentRepository.findByIsSecondaryStudent(true);
			return student;
			
		}
	
	//method going to database to check for Notsecondary student

	public List<Student> checkIfStudentIsNotSecondary (Boolean booleanobj){
			List<Student> student=studentRepository.findByIsSecondaryStudent(false);
			return student;
			
		}
	
		//method going to database to update the student record
	@Override
	public Student updateStudentDetails(int studentRollNo, Student updatedStudentName) {
Optional<Student> student = studentRepository.findById(studentRollNo);
		if(student.isPresent()) {
			Student  existingStudent = student.get(); 
			existingStudent.setStudentRollNo(updatedStudentName.getStudentRollNo());
			existingStudent.setLocation(updatedStudentName.getLocation());
			existingStudent.setStudentName(updatedStudentName.getStudentName());
			existingStudent.setStudentMobile(updatedStudentName.getStudentMobile());
			existingStudent.setQualification(updatedStudentName.getQualification());
			existingStudent.setStudentMarks(updatedStudentName.getStudentMarks());
			studentRepository.save(existingStudent);
			emailService.sendEmail("radharamanusha98@gmail.com", "Hope University", "Given details are updated");
			
			return existingStudent;
		}
		else {
			return null;
		}
	}
	
	//method going to database to delete the student record of particular StudentRollNo
	@Override
	public Optional<Student> deleteStudentById(int studentRollNo) {
		Optional<Student>student = studentRepository.findById(studentRollNo);  
		if(student.isPresent()) {
			studentRepository.deleteById(studentRollNo);
		}
		return student;
	}

	//method going to database to delete all the student records
	@Override
	public void deleteAllStudents() {
		studentRepository.deleteAll();
		System.out.println("All Students Deleted");
	}

	//method going to database to fetch filtered studentrecords
	@Override
	public Iterable<Student> fetchFilteredStudents(String studentName) {
		  Iterable<Student> student=studentRepository.findByStudentNameContainingIgnoreCase(studentName);
		return student;
	}

	public List<Student> getAllStudentsByGrade(String qualification) {
		 
		List<Student> studentsList = new ArrayList<Student>();
				studentRepository.findByQualificationContainingIgnoreCase(qualification).forEach(studentsList::add);
		return studentsList;
	}
	
	public List<Student> getAllStudentByLocation(String location) {
		List<Student> studentlist = new ArrayList<Student>();
				studentRepository.findByLocationContainingIgnoreCase(location).forEach(studentlist::add);
		return studentlist;
	}

	
	
	public  List<Student>sortByMarks(String direction,String fieldName){
		List<Student>student=new ArrayList<Student>();
		student=studentRepository.findAll(Sort.by(getSortDirection(direction), fieldName));
		return student;
	}
	
	
	public  List<Student>sortByStudentName(String direction,String fieldName){
		List<Student>student=new ArrayList<Student>();
		student=studentRepository.findAll(Sort.by(getSortDirection(direction), fieldName));
		return student;
	}
	
	private Sort.Direction getSortDirection(String direction) {
	    if (direction.equals("asc")) {
	      return Sort.Direction.ASC;
	    } else if (direction.equals("desc")) {
	      return Sort.Direction.DESC;
	    }

	    return Sort.Direction.ASC;
	  }

}






