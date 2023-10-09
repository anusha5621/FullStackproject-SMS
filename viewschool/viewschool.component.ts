import { Component, OnInit } from '@angular/core';
import { SchoolserviceService } from '../schoolservice.service';
import { School } from '../School';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from '../Student';
import { StudentServiceService } from '../student-service.service';
@Component({
  selector: 'app-viewschool',
  templateUrl: './viewschool.component.html',
  styleUrls: ['./viewschool.component.css']
})
export class ViewschoolComponent implements OnInit{
  id:number;
  student : Student = new Student();
particularSchool: any;
particularStudent:Student=new Student()
constructor(private route:ActivatedRoute,private router :Router ,private studentService: StudentServiceService,private schoolService:SchoolserviceService){ }

ngOnInit(): void {
  //'view-school-details/:4
  this.id = this.route.snapshot.params['id'];  //1
  this.schoolService.getSchoolById(this.id).subscribe( data => {
   this.particularSchool = data;
    console.log( this.particularSchool);
    console.log(this.particularStudent);
    
  });
}
  getStudentById(id:number){
    this.schoolService.getSchoolById(this.id).subscribe(data =>{
      console.log(this.particularStudent);
    })
  
}
viewStudent(id : number){
  console.log(School);
  this.router.navigate(['view-student-details',this.id]);
}
back(){
  this.router.navigate(['see-all-schools'])
}

  }



  
  
    
