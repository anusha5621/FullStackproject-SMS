import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-contactus',
  templateUrl: './contactus.component.html',
  styleUrls: ['./contactus.component.css']
})
export class ContactusComponent {
  name: '' = "";
  email: '' = "";
  message: '' = "";

  constructor(private router: Router) {}

  submitForm() {
    if (this.name === '' || this.email === '' || this.message === '') {
      alert('Please fill all mandatory fields');
    } else {
      alert('Thank you for contacting us,we will get back to you as soon as possible.');
      this.router.navigate(['add-feedback/:id']);
    }
    
  }
}