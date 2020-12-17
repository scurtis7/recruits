import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SiteUser } from '../model/site-user';
import { Observable } from 'rxjs';
import { Session } from '../model/session';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private httpClient: HttpClient) {
  }

  createUser(user: SiteUser): Observable<SiteUser> {
    const url = 'api/user';
    console.log('createUser url -> ' + url);
    return this.httpClient.post<SiteUser>(url, user, this.httpOptions);
  }

  loginUser(username: string, password: string): Observable<Session> {
    const url = 'api/login';
    console.log('loginUser url -> ' + url);
    const token = 'Bearer ' + username + '|' + password;
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: token
      })
    };

    return this.httpClient.post<Session>(url, {}, httpOptions);
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  // private handleError<T>(operation = 'operation', result?: T): any {
  //   return (error: any): Observable<T> => {
  //
  //     console.error(error); // log to console instead
  //     // return throwError(
  //     //   'Failed to create User with error: ' + error.message);
  //
  //     // Let the app keep running by returning an empty result.
  //     return of(result as T);
  //   };
  // }

}
