package FullStackProject.StudentManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import FullStackProject.StudentManagementSystem.Model.ClassRoom;
public interface ClassRoomService {
	ClassRoom saveClassRoom(ClassRoom nameofTeacher, int id); 
	ClassRoom getClassById(int classRoomNo);
	ClassRoom  updateClassRoomDetails(int  classRoomNo ,ClassRoom classRoom );
	Optional<ClassRoom> deleteClassById(int classRoomNo  );
	void deleteAllClasses();
	List<ClassRoom> getAllClasses();
}
