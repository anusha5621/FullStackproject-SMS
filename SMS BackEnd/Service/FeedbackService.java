package FullStackProject.StudentManagementSystem.Service;

import java.util.List;

import FullStackProject.StudentManagementSystem.Model.Feedback;
import jakarta.validation.Valid;

public interface FeedbackService {
	
public Feedback addFeedBack(Feedback feedBack,Integer studentRollNo, Long userId) throws Exception;
	public void deleteFeedBack(Integer feedbackId) throws Exception;

	public Feedback viewFeedback(Integer studentRollNo) throws Exception;

	public List<Feedback> viewFeedbackAll() throws Exception ;
	public void deleteAllFeedbacks();
	

}
