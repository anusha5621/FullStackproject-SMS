import { Component, OnInit } from '@angular/core';
import { ClassRoom } from '../ClassRoom';
import { ClassroomService } from '../classroom.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-classroomlist',
  templateUrl: './classroomlist.component.html',
  styleUrls: ['./classroomlist.component.css']
})
export class ClassroomlistComponent implements OnInit{
classRooms: ClassRoom[] = [];
count : number = 4;
p : number = 1;
    constructor(private classRoomService: ClassroomService,
      private router: Router) { }
      ngOnInit(): void {
        this.getClassRoomDetails();
    }
  
      viewClassRoom(id : number){   
  
        this.router.navigate(['view-classRoom-details', id]);  
       
      }
     
  
      deleteClassRoom(id : number){
        var status = confirm("Are you sure to delete this record?");
        if (status == true) {
        this.classRoomService.deleteClassRoom(id).subscribe( (data: any) => {
          this.getClassRoomDetails();
        })
      }
        else{
          this.getClassRoomDetails();
        }
      
      }
  
      updateClassRoom(id : number){
        this.router.navigate(['update-classRoom', id]);
      }
      
    removeAllClassRooms(){
      var status = confirm("Are you sure to delete all the records?");
      if (status == true) {
        this.classRoomService.deleteAll().subscribe((details: any) => {
          console.log(details);  //null
          this.getClassRoomDetails();
        },
          (          error: any) => {
            console.log(error);
          })
      }
      else{
      this.getClassRoomDetails();
    }
    }
    private getClassRoomDetails() : any{
      this.classRoomService.getClassRoomList().subscribe(data => {
        this.classRooms= data;
        console.log(data);
      })
    
    }
  }