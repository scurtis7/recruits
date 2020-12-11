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

  constructor(private userService: UserService) {}

  ngOnInit(): void {
  }

  createSiteUser(): void {
    console.log('name:' + this.name + '   username:' + this.username + '   password:' + this.password + '   password2:' + this.password2);
    this.userService.createUser(new SiteUser(this.name, this.username, this.password));
  }

  validatePassword(): void {
    this.passwordsDontMatch = this.password !== this.password2;
  }
}
