import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { School } from '../School';
import { FeedbackService } from '../feedback.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';
import { SchoolserviceService } from '../schoolservice.service';
import { Feedback } from '../Feedback';

@Component({
  selector: 'app-addfeedback',
  templateUrl: './addfeedback.component.html',
  styleUrls: ['./addfeedback.component.css']
})
export class AddfeedbackComponent implements OnInit{
id:number;
 user:number;
 schools:School[]=[];
 selectedSchoolIds:number[]=[];
 i:number;
 users:User[]=[];
 usersId:any;
 

  constructor(private feedbackService:FeedbackService,private router:Router,private schoolService:SchoolserviceService,private userService:UserService,private route:ActivatedRoute){}

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.schoolService.getSchoolList().subscribe(data=>{
      this.schools=data;
      console.log(this.schools);
    })
   /* this.userService.viewAllUsers().subscribe(data=>{
      this.users=data;
      console.log(this.users);
   
    }*/
      
    
     }
      feedback:Feedback = new Feedback();

  
  getFeedbackList(){
    this.router.navigate([`feed-back`]);
  }
  OnSubmit(schoolId:number){
    
    this.feedbackService.addFeedback(this.feedback,schoolId,this.id).subscribe(data=>{
      console.log(data);
      this.router.navigate(['feed-back']);
    }
      )

  }
 
  back(){
    this.router.navigate(['feed-back'])
  }

}
