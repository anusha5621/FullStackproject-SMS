package FullStackProject.StudentManagementSystem.ServiceImplementation;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import FullStackProject.StudentManagementSystem.Model.Feedback;
import FullStackProject.StudentManagementSystem.Model.School;
import FullStackProject.StudentManagementSystem.Model.Student;
import FullStackProject.StudentManagementSystem.Model.User;
import FullStackProject.StudentManagementSystem.Repository.FeedbackRepository;
import FullStackProject.StudentManagementSystem.Repository.SchoolRepository;
import FullStackProject.StudentManagementSystem.Repository.StudentRepository;
import FullStackProject.StudentManagementSystem.Repository.UserRepository;
import FullStackProject.StudentManagementSystem.Service.FeedbackService;
import jakarta.validation.Valid;
@Service
public  class FeedbackServiceImpl implements FeedbackService {
	@Autowired	
	private FeedbackRepository feedBackRepository;
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private UserRepository userRepository;


	public Feedback addFeedBack(Feedback feedBack, Integer schoolCode, Long userId) throws Exception {
		
			
			Optional<School> schoolObj = schoolRepository.findById(schoolCode);
			if (schoolObj.isEmpty()) {
				throw new Exception("School is not present with Id: "+ schoolCode);
			}
			Optional<User> user = userRepository.findById(userId);//.orElseThrow(()-> new UserException("User not found!"));
			if (user.isEmpty()) {
				throw new Exception("School is not present with Id: "+ schoolCode);
			}
			
			feedBack.setSchool(schoolObj.get());
			feedBack.setUser(user.get());
			Feedback savedFeedback = feedBackRepository.save(feedBack);

			return savedFeedback;
			}


	@Override
	public void deleteFeedBack(Integer feedbackId) {
		feedBackRepository.deleteById(feedbackId);
		
	}


	@Override
	public Feedback viewFeedback(Integer id) throws Exception {
		Optional<Feedback> fedOptional = feedBackRepository.findById(id);
		if (fedOptional.isPresent()) {
			return fedOptional.get();
		}
		throw new Exception("No feedback found!");
	
	}
	@Override
	public List<Feedback> viewFeedbackAll() throws Exception {
		Optional<List<Feedback>> fedOptional = Optional.of(feedBackRepository.findAll());
			if (fedOptional.isPresent()) {
			return fedOptional.get();
		}
		throw new Exception("No feedbacks found!");
	
	}


	@Override
	public void deleteAllFeedbacks() {
		feedBackRepository.deleteAll();
		System.out.println("All Feedbacks Deleted");
		
	}

}