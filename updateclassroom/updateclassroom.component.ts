import { Component, OnInit } from '@angular/core';
import { ClassRoom } from '../ClassRoom';
import { ClassroomService } from '../classroom.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-updateclassroom',
  templateUrl: './updateclassroom.component.html',
  styleUrls: ['./updateclassroom.component.css']
})
export class UpdateclassroomComponent implements OnInit{ 

 id: number = 0;
    classRoom: ClassRoom= new ClassRoom();
    constructor(private classRoomService: ClassroomService,
      private route: ActivatedRoute,
      private router: Router){}
      ngOnInit(): void {
        this.id = this.route.snapshot.params['id'];  
        
      this.classRoomService.getClassRoomById(this.id).subscribe(data => {
        this.classRoom = data;
      }, error => console.log(error));
    }
  
    onSubmit(){
      this.classRoomService.updateClassRoom(this.id, this.classRoom).subscribe( data =>{
        this.getClassRoomList();
      }
      , error => console.log(error));
    }
    getClassRoomList(){
      this.router.navigate(['/see-all-classRooms']);
    }
    back(){
      this.router.navigate(['see-all-classRooms']);
    }
  }
