package FullStackProject.StudentManagementSystem.Service;
import java.util.List;
import java.util.Optional;
import FullStackProject.StudentManagementSystem.Model.Student;

/*StudentService is an interface having following abstract methods  and 
implementation is provided in the StudentServiceImplementation classs
 */
public interface StudentService {
	   Student saveStudent(Student student); 
	   List<Student> getAllStudentFromDb(String name);
	  Student getStudentById(int studentRollNo);
	  Student  updateStudentDetails(int  studentRollNo,Student student);
	  Optional<Student> deleteStudentById(int studentRollNo);
      void deleteAllStudents();
      Iterable<Student> fetchFilteredStudents(String studentName);
}







