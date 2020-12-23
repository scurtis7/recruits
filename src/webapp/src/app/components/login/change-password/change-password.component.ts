import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../service/user.service';
import { ChangePassword } from '../../../model/change-password';
import { SiteUser } from '../../../model/site-user';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  oldUsername = '';
  oldPassword = '';

  newPassword = '';
  newPasswordError = false;
  newPasswordErrorMsg = '';

  newPassword2 = '';
  newPassword2Error = false;
  newPassword2ErrorMsg = '';

  passwordChanged = false;

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
  }

  changePassword(): void {
    console.log('changePassword()  username:' + this.oldUsername + '   old password:' + this.oldPassword + '   new password' + this.newPassword);
    this.userService.changePassword(new ChangePassword(this.oldUsername, this.oldPassword, this.newPassword))
      .subscribe(
        user => {
          console.log('Password changed successfully');
          this.passwordChanged = true;
        },
        err => {
          console.log('An error ocurred -> ' + err.message);
          this.passwordChanged = false;
          this.newPassword2Error = true;
          this.newPassword2ErrorMsg = 'Unable to change password';
        },
        () => console.log('HTTP Request completed')
      );
  }

  validatePassword(): void {
    if (this.checkPassword()) {
      this.newPasswordError = true;
      this.newPasswordErrorMsg = 'Passwords must not be blank and contain a number and special character and be at least 8 characters long';
    } else {
      this.newPasswordError = false;
    }
  }

  private checkPassword(): boolean {
    return this.newPassword === '' || this.newPassword.length < 8 || !this.checkNumeric() || !this.checkSpecialCharacter();
  }

  private checkNumeric(): boolean {
    return this.newPassword.includes('1') || this.newPassword.includes('2') || this.newPassword.includes('3')
      || this.newPassword.includes('4') || this.newPassword.includes('5') || this.newPassword.includes('6')
      || this.newPassword.includes('7') || this.newPassword.includes('8') || this.newPassword.includes('9')
      || this.newPassword.includes('0');
  }

  private checkSpecialCharacter(): boolean {
    return this.newPassword.includes('!') || this.newPassword.includes('@') || this.newPassword.includes('#')
      || this.newPassword.includes('$') || this.newPassword.includes('%') || this.newPassword.includes('^')
      || this.newPassword.includes('&') || this.newPassword.includes('*') || this.newPassword.includes('(')
      || this.newPassword.includes(')') || this.newPassword.includes('{') || this.newPassword.includes('}')
      || this.newPassword.includes('[') || this.newPassword.includes(']') || this.newPassword.includes('=')
      || this.newPassword.includes('+') || this.newPassword.includes('?') && !this.newPassword.includes('|');
  }

  validatePassword2(): void {
    if (this.newPassword !== this.newPassword2) {
      this.newPassword2Error = true;
      this.newPassword2ErrorMsg = 'Passwords do not match';
    } else {
      this.newPassword2Error = false;
    }
  }

}
