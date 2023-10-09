import { Component, OnInit } from '@angular/core';
import { StudentServiceService } from '../student-service.service';
import { Feedback } from '../Feedback';
import { School } from '../School';
import { FeedbackService } from '../feedback.service';
import { Router } from '@angular/router';
import { SchoolserviceService } from '../schoolservice.service';
import { UserService } from '../user.service';
@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit{
  
feedback:Feedback = new Feedback();
  feedbacks:Feedback[]=[];
  count:number=4;
  p:number=1;
  id:number;
  school : School=new School();
  // user:User=new User(userName,userPassword,email,dob,about,role);
  selectedSchoolIds:number[]=[];
  selectedUserIds:number[]=[];

  i:number;
  j:number;
  constructor(private feedbackService:FeedbackService,private router:Router,private schoolService:SchoolserviceService,private userService:UserService){}

  ngOnInit(): void {
    this.getAllFeedbacks();
    this.schoolService.getSchoolList().subscribe(data=>{
      this.school[this.i]=data;
      console.log(data);

    })
    // this.userService.viewAllUsers().subscribe(data=>{
    //   this.user[this.j]=data;
    //   console.log(this.user);
    // })
  }
  getAllFeedbacks(){
    this.feedbackService.viewAllFeedbacks().subscribe(data=>{
      this.feedbacks=data;
      console.log(this.feedbacks);
    })
 }
 removeAllFeedbacks(){
  var status=confirm("Are you sure you want to remove all feedbacks");
  if(status==true){
    this.feedbackService.deleteAllFeedbacks().subscribe(data=>{
      console.log(data);
      this.getAllFeedbacks;
    },error=>console.log(error))
  }
 }
 Showfeedback(id:number){
 this.router.navigate(['feedback',id])
 }
 deleteFeedback(id:number){
  var status=confirm("Are you sure you want to delete this record");
  if(status==true){
    this.feedbackService.deleteFeedback(id).subscribe(details=>{
      this.getAllFeedbacks();
    })
  }
  else{
    this.getAllFeedbacks();
  }
 }

}

