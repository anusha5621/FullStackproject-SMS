import { Component } from '@angular/core';
import { StudentServiceService } from '../student-service.service';
import { Router ,ActivatedRoute} from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {
  showSignInForm = true;

  password: any ;
  email: any ;
    loginStatus:any=sessionStorage.getItem("loginStatus");
    constructor(private service:StudentServiceService, private router:Router,private act:ActivatedRoute)

    {
    }
    toggleForm() {
      this.showSignInForm = !this.showSignInForm;
    }
    
    signin(email: any, password: any)
    {
  
      this.service.signin(email,password).subscribe(
  
        response => {
  
          console.log(response);
          alert('login successful');
          sessionStorage.setItem("loginStatus","active");
          sessionStorage.setItem("email",email);
          sessionStorage.setItem("userId",response.userId);
          sessionStorage.setItem("userRole",response.userRole);
          sessionStorage.setItem("userName",response.userName);
          this.router.navigate(['library']);
      },
  
      () => { alert('Wrong email Id or password!!');  }
  
      );
  
  
  
    }


    signup()
    {
      this.router.navigate(["/sign-up"]);
    }
    back(){
      this.router.navigate(['sign-in'])
    }
  }
  

