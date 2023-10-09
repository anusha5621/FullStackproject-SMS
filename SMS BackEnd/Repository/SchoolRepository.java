package FullStackProject.StudentManagementSystem.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import FullStackProject.StudentManagementSystem.Model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School ,Integer>{
List<School> findBySchoolNameContainingIgnoreCase(String name);








	
}
