import { Component, OnInit } from '@angular/core';
import {Student}from '../Student';
import { StudentServiceService } from '../student-service.service';
import { Router } from '@angular/router';
import { School } from '../School';
import { SchoolserviceService } from '../schoolservice.service';
@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit{
 constructor(private studentService: StudentServiceService,private schoolService: SchoolserviceService,
    private router: Router) { }

    student : Student = new Student();
    selectedSchoolsIds: number[]=[];
    j:number;
    schools:any;
    
    ngOnInit(): void {
        this.schoolService.getSchoolList().subscribe(data => {
          this.schools = data,
          console.log(this.schools)
        })
    }
    
    saveStudent(indexId:number,schoolCode:number){
      this.studentService.createStudent(this.student,schoolCode).subscribe( data =>{
        console.log(data);
        this.goToStudentList();
      },
      error => console.log(error));
    }
  
    goToStudentList(){
      this.router.navigate(['/see-all-students']);
    }
    
    back(){
      this.router.navigate(['see-all-students'])
    }
    


}
  