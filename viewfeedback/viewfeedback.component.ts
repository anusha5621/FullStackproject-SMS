import { Component, OnInit } from '@angular/core';
import { Feedback } from '../Feedback';
import { ActivatedRoute, Router } from '@angular/router';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-viewfeedback',
  templateUrl: './viewfeedback.component.html',
  styleUrls: ['./viewfeedback.component.css']
})
export class ViewfeedbackComponent implements OnInit {
id: number ;
particularFeedback: Feedback= new Feedback();
constructor(private route:ActivatedRoute,private router:Router,private feedbackService: FeedbackService){ }
ngOnInit(): void {
  console.log("hi")
  //'view-feedback-details/:4
  this.id = this.route.snapshot.params['id'];  //1
  
  this.feedbackService.viewfeedback(this.id).subscribe( data => {
    this.particularFeedback = data;
    console.log( this.particularFeedback);
  });
}
back(){
  this.router.navigate(['feed-back'])
}
  }
   