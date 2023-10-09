import { Component } from '@angular/core';
import { School } from '../School';
import { SchoolserviceService } from '../schoolservice.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-createschool',
  templateUrl: './createschool.component.html',
  styleUrls: ['./createschool.component.css']
})
export class CreateschoolComponent {
constructor(private schoolService:SchoolserviceService,
  private router: Router){}
 school : School = new School();
    saveSchool(){
      this.schoolService.createSchool(this.school).subscribe( data =>{
        console.log(data);
        this.goToSchoolList();
      },
      error => console.log(error));
    }
  
    goToSchoolList(){
      this.router.navigate(['/see-all-schools']);
    }
    
    onSubmit(){
      console.log(this.school);
      this.saveSchool();
    }
back(){
  this.router.navigate(['see-all-schools'])
}


} 