import { Component, OnInit } from '@angular/core';
import { StudentServiceService } from '../student-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from '../Student';
import { School } from '../School';
import { SchoolserviceService } from '../schoolservice.service';
@Component({
  selector: 'app-view-student',
  templateUrl: './view-student.component.html',
  styleUrls: ['./view-student.component.css']
})
export class ViewStudentComponent implements OnInit {

id: number=0;
particularSchool:School=new School();
  particularStudent: Student = new Student();
  school :  School=new School();
  constructor(private router: Router, private route:ActivatedRoute,private studentService: StudentServiceService,private schoolService:SchoolserviceService ){ }
ngOnInit(): void {
    //'view-student-details/:4
    this.id = this.route.snapshot.params['id'];  //1

  
    this.studentService.getStudentById(this.id).subscribe( data => {
      this.particularStudent = data;
      //this.particularSchool=data;
      console.log(this.particularSchool); 
      console.log( this.particularStudent);
    });
  }
  getSchoolById(id:number){
    this.studentService.getStudentById(this.id).subscribe(data =>{
      console.log(this.particularSchool);
    })
  }
  viewSchool(id : number){
    console.log(Student);
    this.router.navigate(['view-school-details',this.id]);
  }
  back(){
    this.router.navigate(['see-all-students'])
  }

} 