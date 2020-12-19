import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../service/user.service';
import { SessionService } from '../../../service/session.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  username = '';
  password = '';
  userLoginFailed = false;
  userLoginErrorMsg = '';

  constructor(private userService: UserService, private sessionService: SessionService, private router: Router) {
  }

  ngOnInit(): void {
  }

  loginUser(): void {
    this.userService.loginUser(this.username, this.password)
      .subscribe(
        session => {
          console.log('User successfully logged in');
          this.sessionService.session = session;
          this.userLoginFailed = false;
          this.router.navigate(['/']);
        },
        err => {
          console.log('An error occurred logging in -> ' + err.message);
          this.userLoginFailed = true;
          this.userLoginErrorMsg = 'Your username or password were not recognized';
        },
        () => console.log('User login completed')
      );
  }


}
