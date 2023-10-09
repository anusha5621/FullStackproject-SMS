package FullStackProject.StudentManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import FullStackProject.StudentManagementSystem.Model.School;
public interface SchoolService {
	School saveSchool(School nameofschool); 
	   List<School> getAllSchools();
	   School getSchoolByCode(int schoolCode);
	   School  updateSchoolDetails(int schoolCode  ,School school);
	  Optional<School> deleteSchoolByCode(int schoolCode);
   void deleteAllSchools();

}
