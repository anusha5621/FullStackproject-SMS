package FullStackProject.StudentManagementSystem.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import FullStackProject.StudentManagementSystem.Model.User;
public interface UserRepository extends JpaRepository<User,Long>{
		@Query(value = "SELECT * FROM USER su WHERE su.user_email = ?1",nativeQuery = true  )
		public Optional<User> findByuserEmail(String email);
		@Query(value = "SELECT * FROM USER su  WHERE su.user_email = ?1 AND u.user_password = ?2 ",nativeQuery = true  )
		public Optional<User> findByuserEmailAndPassword(String email, String password);
		

	}
