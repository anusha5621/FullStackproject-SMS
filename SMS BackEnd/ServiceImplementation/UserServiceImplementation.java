package FullStackProject.StudentManagementSystem.ServiceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FullStackProject.StudentManagementSystem.Model.User;
import FullStackProject.StudentManagementSystem.Repository.UserRepository;

@Service
public class UserServiceImplementation {
@Autowired
private UserRepository userRepository;

 public void addUser(User user) {
	 this.userRepository.save(user);
 }
 public Optional<User> getUserByEmail(String email){
	 return this.userRepository.findByuserEmail(email);
 }
}

	
	



