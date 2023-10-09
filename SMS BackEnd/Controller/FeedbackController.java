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
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import FullStackProject.StudentManagementSystem.Model.Feedback;
	import FullStackProject.StudentManagementSystem.Service.FeedbackService;
	import jakarta.validation.Valid;


	@RestController
	@CrossOrigin
	@RequestMapping("/feedback")
	public class FeedbackController {
		@Autowired
		private FeedbackService feedbackService;
		
		@PostMapping("/add/{schoolCode}/{userId}")
		public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback,
													@PathVariable("schoolCode") int schoolCode,@PathVariable("userId")Long userId) throws Exception{
			
			Feedback feedback2 = feedbackService.addFeedBack(feedback, schoolCode, userId);
			
			return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
			
		}

		@GetMapping("/getFeedbackById/{id}")
		public ResponseEntity<Feedback> viewFeedback(@PathVariable("id") Integer ID) throws Exception {
			
			Feedback feedback2 = feedbackService.viewFeedback(ID);
			
			return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
			
		}
		@GetMapping("/getAllFeedbacks")
		public ResponseEntity<List<Feedback>> viewFeedbackAll() throws Exception  {
			
			List<Feedback> feedback2 =  feedbackService.viewFeedbackAll();
			
			return new ResponseEntity<List<Feedback>>(feedback2,HttpStatus.ACCEPTED);
			
		}
		@DeleteMapping("deletefeedback/{id}")
		public void deleteFeedback(@PathVariable("id") Integer feedbackId) throws Exception{
			
			 feedbackService.deleteFeedBack(feedbackId);
			}
	
	
	@DeleteMapping("/deleteAllFeedbacks")
	public void deleteAllSchools()throws Exception{
		try {
			feedbackService.deleteAllFeedbacks();
		}
		catch(Exception exc) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	}
			
	
