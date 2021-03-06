import { Component, OnInit } from '@angular/core';
import { SessionService } from './service/session.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'Recruits';

  constructor(private sessionService: SessionService, private router: Router) {
  }

  ngOnInit(): void {
    if (!this.sessionService.checkSession()) {
      this.router.navigate(['/signin']);
    }
  }

  isAdmin(): boolean {
    return this.sessionService.isAdmin();
  }

  loggedIn(): boolean {
    return this.sessionService.checkSession();
  }

  signOut(): void {
    this.sessionService.signOut();
    this.router.navigate(['/signin']);
  }

}
