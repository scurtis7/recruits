import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../service/user.service';
import { SiteUser } from '../../../model/site-user';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  username = '';
  password = '';

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
  }

  loginUser(): void {
    this.userService.loginUser(this.username, this.password)
      .subscribe(
        session => {
          console.log('User successfully logged in');
        },
        err => {
          console.log('An error occurred logging in -> ' + err.message);
          // this.userAdded = false;
          // this.usernameError = true;
          // this.usernameErrorMsg = 'This username is already taken, please select another';
        },
        () => console.log('HTTP Request completed')
      );
  }



}
