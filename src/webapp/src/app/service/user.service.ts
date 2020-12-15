import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SiteUser } from '../model/site-user';
import { Observable, of, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'api/user';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private httpClient: HttpClient) {
  }

  createUser(user: SiteUser): Observable<SiteUser> {
    console.log('createUser url -> ' + this.baseUrl);
    return this.httpClient.post<SiteUser>(this.baseUrl, user, this.httpOptions);
      // .pipe();

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
