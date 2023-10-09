import { Component, OnInit } from '@angular/core';
import { ClassRoom } from '../ClassRoom';
import { ActivatedRoute, Router } from '@angular/router';
import { ClassroomService } from '../classroom.service';
import { Teacher } from '../Teacher';

@Component({
  selector: 'app-viewclassroom',
  templateUrl: './viewclassroom.component.html',
  styleUrls: ['./viewclassroom.component.css']
})
export class ViewclassroomComponent implements OnInit{
  
id: number = 0;
teacher : Teacher=new Teacher();
  particularClassRoom: ClassRoom= new ClassRoom();
  particularTeacher:Teacher=new Teacher();
  constructor(private router: Router,private route:ActivatedRoute,private classRoomService: ClassroomService){ }
ngOnInit(): void {
  //'view-teacher-details/:4
  this.id = this.route.snapshot.params['id'];  //1
  this.classRoomService.getClassRoomById(this.id).subscribe( data => {
    this.particularClassRoom = data;
    console.log( this.particularClassRoom);
    console.log(this.particularTeacher);
  });
}

getTeacherById(id:number){
  this.classRoomService.getClassRoomById(this.id).subscribe(data =>{
    console.log(this.particularTeacher);
  })
}
viewTeacher(id : number){
  console.log(ClassRoom);
  this.router.navigate(['view-teacher-details',this.id]);
}
back(){
  this.router.navigate(['see-all-classRooms'])
}
  }   