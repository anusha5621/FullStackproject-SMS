
package FullStackProject.StudentManagementSystem.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FullStackProject.StudentManagementSystem.Model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{
	



}
