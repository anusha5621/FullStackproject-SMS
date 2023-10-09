import { Component } from '@angular/core';
import { ClassroomService } from '../classroom.service';
import { Router } from '@angular/router';
import { ClassRoom } from '../ClassRoom';
import { Teacher } from '../Teacher';
import { SchoolserviceService } from '../schoolservice.service';
import { TeacherserviceService } from '../teacherservice.service';

@Component({
  selector: 'app-createclassroom',
  templateUrl: './createclassroom.component.html',
  styleUrls: ['./createclassroom.component.css']
})
export class CreateclassroomComponent {


 constructor(private classRoomService:ClassroomService,private teacherService:TeacherserviceService,
  private router: Router){}
 classRoom : ClassRoom = new ClassRoom();
 selectedTeacherIds: number[]=[];
 j:number;
 teachers: Teacher[]=[];
 
 
 ngOnInit(): void {
  this.teacherService.getTeacherList().subscribe(data => {
    this.teachers = data,
    console.log(this.teachers)
  })
}

   
 saveClassRoom(indexId:number,teacherId:number){
  this.classRoomService.createClassRoom(this.classRoom,teacherId).subscribe( data =>{
        console.log(data);
        this.goToClassRoomList();
      },
      error => console.log(error));
    }
  
    goToClassRoomList(){
      this.router.navigate(['/see-all-classRooms']);
    }
    
    /*onSubmit(){
      console.log(this.classRoom);
      this.saveClassRoom();
    }*/

back(){
  this.router.navigate(['see-all-classRooms']);
}

}