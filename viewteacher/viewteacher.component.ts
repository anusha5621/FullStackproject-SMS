import { Component, OnInit } from '@angular/core';
import { Teacher } from '../Teacher';
import { ActivatedRoute, Router } from '@angular/router';
import { TeacherserviceService } from '../teacherservice.service';
import { ClassRoom } from '../ClassRoom';
import { ClassroomService } from '../classroom.service';

@Component({
  selector: 'app-viewteacher',
  templateUrl: './viewteacher.component.html',
  styleUrls: ['./viewteacher.component.css']
})
export class ViewteacherComponent implements OnInit{
  id: number = 0;
  classRoom:ClassRoom=new ClassRoom();
  particularTeacher:  any;
  particularClassRoom:any;
  constructor(private route:ActivatedRoute,private router:Router,private classRoomService:ClassroomService ,private teacherService: TeacherserviceService){ }
  ngOnInit(): void {
    //'view-teachers-details/:4
    this.id = this.route.snapshot.params['id'];  //1
    this.teacherService.getTeacherById(this.id).subscribe( data => {
     this.particularTeacher = data;
      console.log( this.particularTeacher);
      console.log(this.particularClassRoom);
      
    });
  }
    getClassRoomById(id:number){
      this.teacherService.getTeacherById(this.id).subscribe(data =>{
        console.log(this.particularClassRoom);
      })
    
  }
  viewClassRoom(id : number){
    console.log(Teacher);
    this.router.navigate(['view-classroom-details',this.id]);
  }
  back(){
    this.router.navigate(['see-all-teachers'])
  }
}