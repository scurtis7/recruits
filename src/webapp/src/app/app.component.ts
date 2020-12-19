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
  isAdmin = false;

  constructor(private sessionService: SessionService, private router: Router) {
    this.isAdmin = sessionService.isAdmin();
  }

  ngOnInit(): void {
    if (!this.sessionService.checkSession()) {
      this.router.navigate(['/signin']);
    }
  }

}
