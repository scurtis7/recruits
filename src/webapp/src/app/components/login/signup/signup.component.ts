import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  name = '';
  username = '';
  password = '';
  password2 = '';
  passwordsDontMatch = false;

  constructor() { }

  ngOnInit(): void {
  }

  createAccount(): void {
    console.log('name:' + this.name + '   username:' + this.username + '   password:' + this.password + '   password2:' + this.password2);
  }

  validatePassword(): void {
    this.passwordsDontMatch = this.password !== this.password2;
  }
}
