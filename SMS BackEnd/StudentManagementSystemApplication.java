package FullStackProject.StudentManagementSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
@SpringBootApplication used to mark a configuration class that declares bean creations,component-scan etc..
It Automatically enable configurations and Annotations.
*/
@SpringBootApplication
public class StudentManagementSystemApplication{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

}
