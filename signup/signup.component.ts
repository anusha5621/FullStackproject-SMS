
import { Component } from '@angular/core';
  import { UserService } from '../user.service';
  import { Router } from '@angular/router';
  import { User } from '../User';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  showSignInForm = false;
  constructor(private service:UserService, private router:Router)
    {
  
    }
    toggleForm() {
      this.showSignInForm = !this.showSignInForm;
    }
    
    user:any;
    saveUser( userName:any, dob:any, email:any, password:any, repassword:any, about:any)
    {
      if(password==repassword)
      {
        this.user=new User(User,userName,password,email,dob,about,"USER");
        console.log(this.user)
        this.service.signup(this.user).subscribe(
        response => {
          console.log(response);
          alert('Signup successful!!');
          this.router.navigate(['/signin']);
      },
      (error) => { alert(error.message);  }
  
  
     );
  
    }
    else
    {
      alert('password does not match!!');
      window.location.reload();
    }
    }
    back(){
      this.router.navigate(['sign-in'])
    }
  }
  

