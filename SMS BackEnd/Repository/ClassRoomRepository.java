package FullStackProject.StudentManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import FullStackProject.StudentManagementSystem.Model.ClassRoom;
import FullStackProject.StudentManagementSystem.Model.Teacher;

public interface ClassRoomRepository extends JpaRepository< ClassRoom,Integer> {

}
