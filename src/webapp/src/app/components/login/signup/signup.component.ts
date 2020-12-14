import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../service/user.service';
import { SiteUser } from '../../../model/site-user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  fullname = '';
  fullnameError = false;
  fullnameErrorMsg = '';

  username = '';
  usernameError = false;
  usernameErrorMsg = '';

  password = '';
  passwordError = false;
  passwordErrorMsg = '';

  password2 = '';
  password2Error = false;
  password2ErrorMsg = '';


  userAdded = false;
  // displayErrorMsg = false;

  // errorMsg = '';

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
  }

  createSiteUser(): void {
    console.log('name:' + this.fullname + '   username:' + this.username + '   password:' + this.password + '   password2:' + this.password2);
    this.userService.createUser(new SiteUser(this.fullname, this.username, this.password))
      .subscribe(
        user => {
          console.log('User ' + user.fullname + ' was added');
          this.userAdded = true;
        },
        err => {
          console.log('An error ocurred -> ' + err.message);
          this.userAdded = false;
          this.usernameError = true;
          this.usernameErrorMsg = 'This username is already taken, please select another';
        },
        () => console.log('HTTP Request completed')
      );
  }

  validateFullname(): void {
    if (this.fullname === '') {
      this.fullnameError = true;
      this.fullnameErrorMsg = 'Please enter a name';
    } else {
      this.fullnameError = false;
    }
  }

  validateUsername(): void {
    if (this.username === '') {
      this.usernameError = true;
      this.usernameErrorMsg = 'Please enter a username';
    } else {
      this.usernameError = false;
    }
  }

  validatePassword(): void {
    if (this.checkPassword()) {
      this.passwordError = true;
      this.passwordErrorMsg = 'Passwords must not be blank and contain a number and special character and be at least 8 characters long';
    } else {
      this.passwordError = false;
    }
  }

  private checkPassword(): boolean {
    return this.password === '' || this.password.length < 8 || !this.checkNumeric() || !this.checkSpecialCharacter();
  }

  private checkNumeric(): boolean {
    return this.password.includes('1') || this.password.includes('2') || this.password.includes('3')
      || this.password.includes('4') || this.password.includes('5') || this.password.includes('6')
      || this.password.includes('7') || this.password.includes('8') || this.password.includes('9')
      || this.password.includes('0');
  }

  private checkSpecialCharacter(): boolean {
    return this.password.includes('!') || this.password.includes('@') || this.password.includes('#')
      || this.password.includes('!$') || this.password.includes('%') || this.password.includes('^')
      || this.password.includes('&') || this.password.includes('*') || this.password.includes('(')
      || this.password.includes(')') || this.password.includes('{') || this.password.includes('}')
      || this.password.includes('[') || this.password.includes(']') || this.password.includes('=')
      || this.password.includes('+') || this.password.includes('|') || this.password.includes('?');
  }

  validatePassword2(): void {
    if (this.password !== this.password2) {
      this.password2Error = true;
      this.password2ErrorMsg = 'Passwords do not match';
    } else {
      this.password2Error = false;
    }
  }
}
