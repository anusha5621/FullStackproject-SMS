package FullStackProject.StudentManagementSystem.ServiceImplementation;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FullStackProject.StudentManagementSystem.Model.School;
import FullStackProject.StudentManagementSystem.Model.Student;
import FullStackProject.StudentManagementSystem.Repository.SchoolRepository;
import FullStackProject.StudentManagementSystem.Service.SchoolService;


@Service
public class SchoolServiceImplementation implements SchoolService {
	@Autowired
	private SchoolRepository schoolRepository;

	public School saveSchool(School nameofschool) {
		return schoolRepository.save(nameofschool);

	}

	public List<School> getAllSchools() {
		List<School> schools = new ArrayList<School>();
		schools = schoolRepository.findAll();
		return schools;
	}
	public School getSchoolByCode(int schoolCode) {
		Optional<School>school = schoolRepository.findById(schoolCode);  
		if(school.isPresent()) {
			return school.get();
		}
		else {
			return null;
			}
		}
	  public School  updateSchoolDetails(int schoolCode  ,School updatedSchoolName) {
		  Optional<School> school= schoolRepository.findById(schoolCode);
			if(school.isPresent()) {
				School  existingSchool = school.get(); 
			existingSchool.setSchoolName(updatedSchoolName.getSchoolName());
			existingSchool.setPrincipalName(updatedSchoolName.getPrincipalName());
			existingSchool.setSchoolLocation(updatedSchoolName.getSchoolLocation());
			existingSchool.setSchoolFounder(updatedSchoolName.getSchoolFounder());
				schoolRepository.save(existingSchool);
				return existingSchool;
			}
			else {
				return null;
			}
	  }
	

public Optional<School> deleteSchoolByCode(int schoolCode) {
	Optional<School>school = schoolRepository.findById(schoolCode);  
	if(school.isPresent()) {
		schoolRepository.deleteById(schoolCode);
	}
	return school;
}
public void deleteAllSchools() {
	schoolRepository.deleteAll();
	System.out.println("All Schools Deleted");
}



}
