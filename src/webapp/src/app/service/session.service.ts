import { Injectable } from '@angular/core';
import { Session } from '../model/session';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  private theSession!: Session;

  get session(): Session {
    return this.theSession;
  }

  set session(newSession: Session) {
    this.theSession = newSession;
  }

  checkSession(): boolean {
    return this.session !== undefined && this.session.id !== '';
  }

  isAdmin(): boolean {
    return this.checkSession() && this.session.role === 'ADMINISTRATOR';
  }

  signOut(): void {
    this.session = new Session('', '', 0, '', '', '');
  }

}
