import { Component } from '@angular/core';
import { UserService } from './user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Hope University';
  constructor(public userService:UserService,
    private router:Router){

  }
  isFlipped: boolean = false; // Define isFlipped property

  isLoginClicked: boolean = false; 
  
  logOut(){
    var status = confirm("Are you sure to log out?");
    if (status == true) {
      sessionStorage.removeItem('loginStatus')
      sessionStorage.removeItem('email')
      sessionStorage.removeItem('userId')
      sessionStorage.removeItem('userRole')
      sessionStorage.removeItem('userName')
      this.router.navigate(['sign-in'])
    }
    else{
      this.router.navigate(['see-all-students']);
    }
  }
  feedback(){
    this.router.navigate(['add-feedback',sessionStorage.getItem('userId')])
  }
  handleLoginClick() {
    this.isLoginClicked = true;
  }
}
