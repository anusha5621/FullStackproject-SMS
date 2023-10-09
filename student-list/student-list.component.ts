
import { Component, OnInit  } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../Student';
import { StudentServiceService } from '../student-service.service';
@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
  
})
export class StudentListComponent implements OnInit{
  selectedSearchMethod: string = 'schoolName'
students: Student[] = [];
grade:string ="";
location:string="";
count : number = 4;
p : number = 1;
  constructor(private studentService: StudentServiceService,
    private router: Router) {  this.getAllStudentDetails();}
    ngOnInit(): void {
     
  }

    viewStudent(id : number){   

      this.router.navigate(['view-student-details', id]);  
     
    }
    
   

    deleteStudent(id : number){
      var status = confirm("Are you sure to delete this record?");
      if (status == true) {
      this.studentService.deleteStudent(id).subscribe( data => {
        this.getAllStudentDetails();
      })
    }
      else{
        this.getAllStudentDetails();
      }
    
    }

    updateStudent(id : number){
      this.router.navigate(['update-student', id]);
    }
    
  removeAllStudents(){
    var status = confirm("Are you sure to delete all the records?");
    if (status == true) {
      this.studentService.deleteAll().subscribe(details => {
        console.log(details);  //null
        this.getAllStudentDetails();
      },
        error => {
          console.log(error);
        })
    }
    else{
    this.getAllStudentDetails();
  }
  }

  getNonSecondaryStudents(){
    this.studentService.findByNotSecondary().subscribe({
      next: (res) => {
      console.log(res);
      this.students = res;
    },
    error: (e) => console.error(e)
  });
  }
  
  searchByGrade() : any{
  this.studentService.findByGrade(this.grade).subscribe(details => {
      this.students= details;
      console.log("HTTP"+ details);
    },
      error => {
        console.log(error);
      });
    }
searchBylocation():any{
        this.studentService.findByLocation(this.location).subscribe(details => {
            this.students= details;
            console.log("HTTP"+ details);
          },
            error => {
              console.log(error);
            });
          }



  getSecondaryStudents(){
    this.studentService.findBySecondary().subscribe({
      next: (res) => {
      console.log(res);
      this.students = res;
    },
    error: (e) => console.error(e)
  });
  }
 
  private getAllStudentDetails() : any{
    this.studentService.getStudentList().subscribe(data => {
      this.students= data;
      console.log(data);
    });
  }
  
  sortBymarks(option:string){
  
    switch(option){
      case "LowGrade":
        this.studentService.sortByMarks("asc","studentMarks").subscribe(data=>{
          this.students=data;
          console.log("Low Data : "+data);
        },error=>{console.log(error)}
        )
        break;
        case "HighGrade":
        this.studentService.sortByMarks("desc","studentMarks").subscribe(data=>{
          this.students=data;
          console.log("High Data : "+data)
        },error=>{console.log(error)}
        )
       
  
    }
  }
  
  sortByStudentName(option:string){
   
    switch(option){
      case "AtoZ":
        this.studentService.sortByStudentName("asc","studentName").subscribe(data=>{
          this.students=data;
          console.log("Low Data : "+data);
        },error=>{console.log(error)}
        )
        break;
        case "ZtoA":
        this.studentService.sortByStudentName("desc","studentName").subscribe(data=>{
          this.students=data;
          console.log("High Data : "+data)
        },error=>{console.log(error)}
        )
       
  
    }
  }
}