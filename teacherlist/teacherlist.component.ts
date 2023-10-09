import { Component, OnInit } from '@angular/core';
import { Teacher } from '../Teacher';
import { Router } from '@angular/router';
import { TeacherserviceService } from '../teacherservice.service';
@Component({
  selector: 'app-teacherlist',
  templateUrl: './teacherlist.component.html',
  styleUrls: ['./teacherlist.component.css']
})
export class TeacherlistComponent  implements OnInit{
teachers: Teacher[] = [];
count : number = 4;
p : number = 1;
  
  
    constructor(private teacherService: TeacherserviceService,
      private router: Router) { }
      ngOnInit(): void {
        
      
        this.getTeacherDetails();
    }
  
      viewTeacher(id : number){   
  
        this.router.navigate(['view-teacher-details', id]);  
       
      }
     
  
      deleteTeacher(id : number){
        var status = confirm("Are you sure to delete this record?");
        if (status == true) {
        this.teacherService.deleteTeacher(id).subscribe( (data: any) => {
          this.getTeacherDetails();
        })
      }
        else{
          this.getTeacherDetails();
        }
      
      }
  
      updateTeacher(id : number){
        this.router.navigate(['update-teacher', id]);
      }
      
    removeAllTeachers(){
      var status = confirm("Are you sure to delete all the records?");
      if (status == true) {
        this.teacherService.deleteAll().subscribe((details: any) => {
          console.log(details);  //null
          this.getTeacherDetails();
        },
          (          error: any) => {
            console.log(error);
          })
      }
      else{
      this.getTeacherDetails();
    }
    }
    private getTeacherDetails() : any{
      this.teacherService.getTeacherList().subscribe(data => {
        this.teachers= data;
        console.log(data);
      })
    
    }
  }