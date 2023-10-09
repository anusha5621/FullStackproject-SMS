import { Component, OnInit } from '@angular/core';
import { Teacher } from '../Teacher';
import { TeacherserviceService } from '../teacherservice.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-updateteacher',
  templateUrl: './updateteacher.component.html',
  styleUrls: ['./updateteacher.component.css']
})
export class UpdateteacherComponent implements OnInit{
 id: number = 0;
    teacher: Teacher= new Teacher();
    constructor(private teacherService: TeacherserviceService,
      private route: ActivatedRoute,
      private router: Router){}
      ngOnInit(): void {
        this.id = this.route.snapshot.params['id'];  
        
      this.teacherService.getTeacherById(this.id).subscribe(data => {
        this.teacher = data;
      }, error => console.log(error));
    }
  
    onSubmit(){
      this.teacherService.updateTeacher(this.id, this.teacher).subscribe( data =>{
        this.getTeacherList();
      }
      , error => console.log(error));
    }
    getTeacherList(){
      this.router.navigate(['/see-all-teachers']);
    }
    back(){
      this.router.navigate(['see-all-teachers'])
    }
  }
