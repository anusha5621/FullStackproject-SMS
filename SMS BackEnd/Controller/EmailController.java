package FullStackProject.StudentManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import FullStackProject.StudentManagementSystem.ServiceImplementation.EmailService;
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/studentmanagement.com")
public class EmailController {
	@Autowired
	private EmailService emailService;
	@PostMapping("/sendMail")
	public ResponseEntity<String> checkEmail()
	{
	emailService.sendEmail("radharamanusha98@gmail.com", "HopeUniversity", "Thankyou for contact us. Your issue has been noted.We will try to resolve your issue as soon as possible  ");
	return new ResponseEntity<>("Message Send",HttpStatus.CREATED);
	}

}
