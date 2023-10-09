package FullStackProject.StudentManagementSystem.ServiceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FullStackProject.StudentManagementSystem.Model.ClassRoom;
import FullStackProject.StudentManagementSystem.Model.Teacher;
import FullStackProject.StudentManagementSystem.Repository.ClassRoomRepository;
import FullStackProject.StudentManagementSystem.Repository.TeacherRepository;
import FullStackProject.StudentManagementSystem.Service.ClassRoomService;
@Service
public class ClassRoomServiceImplementation implements ClassRoomService {
	@Autowired
private ClassRoomRepository classRoomRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Override
	public ClassRoom saveClassRoom(ClassRoom nameofClassRoom, int teacherId) {
		ClassRoom dummy = new ClassRoom();
		dummy.setClassName(nameofClassRoom.getClassName());
		dummy.setClassRoomNo(nameofClassRoom.getClassRoomNo());
		dummy.setDescription(nameofClassRoom.getDescription());
		dummy.setTeacher(teacherRepository.findById(teacherId).get());
		
		return classRoomRepository.save(dummy);
	}

	@Override
	public ClassRoom getClassById(int classRoomNo) {
		Optional<ClassRoom>classRoom = classRoomRepository.findById(classRoomNo);  
		if(classRoom.isPresent()) {
			return classRoom.get();
		}
		else {
			return null;
			}
	
	}

	@Override
	public ClassRoom updateClassRoomDetails(int classRoomNo, ClassRoom classRoom) {
		 Optional<ClassRoom> classRoom1 = classRoomRepository.findById(classRoomNo);
			if(classRoom1.isPresent()) {
				ClassRoom  existingClassRoom = classRoom1.get(); 
				existingClassRoom.setClassName(classRoom.getClassName());
				existingClassRoom.setDescription(classRoom.getDescription());
				classRoomRepository.save(existingClassRoom);
				return existingClassRoom;
			}
			else {
				return null;
			}
		
	}

	@Override
	public Optional<ClassRoom> deleteClassById(int classRoomNo) {

		Optional<ClassRoom>classRoom = classRoomRepository.findById(classRoomNo);  
		if(classRoom.isPresent()) {
			classRoomRepository.deleteById(classRoomNo);
		}
		return classRoom;
	}

	@Override
	public void deleteAllClasses() {
		classRoomRepository.deleteAll();
		System.out.println("All ClassRooms Deleted");
		
	}

	@Override
	public List<ClassRoom> getAllClasses() {
		List<ClassRoom> classRooms = new ArrayList<ClassRoom>();
		classRooms =classRoomRepository .findAll();
		return classRooms ;

	}

}
