import { Component } from '@angular/core';
import { TeacherserviceService } from '../teacherservice.service';
import { Router } from '@angular/router';
import { Teacher } from '../Teacher';

@Component({
  selector: 'app-createteacher',
  templateUrl: './createteacher.component.html',
  styleUrls: ['./createteacher.component.css']
})
export class CreateteacherComponent {
 constructor(private teacherService:TeacherserviceService,
  private router: Router){}
 teacher : Teacher = new Teacher();
    saveTeacher(){
      this.teacherService.createTeacher(this.teacher).subscribe( data =>{
        console.log(data);
        this.goToTeacherList();
      },
      error => console.log(error));
    }
  
    goToTeacherList(){
      this.router.navigate(['/see-all-teachers']);
    }
    
    onSubmit(){
      console.log(this.teacher);
      this.saveTeacher();
    }
back(){
  this.router.navigate(['see-all-teachers'])
}


}