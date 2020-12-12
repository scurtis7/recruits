import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../service/user.service';
import { SiteUser } from '../../../model/site-user';

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
  userAdded = false;

  constructor(private userService: UserService) {}

  ngOnInit(): void {
  }

  createSiteUser(): void {
    console.log('name:' + this.name + '   username:' + this.username + '   password:' + this.password + '   password2:' + this.password2);
    const newUser = this.userService.createUser(new SiteUser(this.name, this.username, this.password));
    if (newUser != null) {
      console.log('User ' + newUser + ' created successfully');
      this.userAdded = true;
    }
  }

  validatePassword(): void {
    this.passwordsDontMatch = this.password !== this.password2;
  }
}
