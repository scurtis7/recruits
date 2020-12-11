import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Player247 } from '../model/player247';
import { catchError } from 'rxjs/operators';
import { SiteUser } from '../model/site-user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'api/user';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private httpClient: HttpClient) {
  }

  createUser(user: SiteUser): Observable<any> {
    const url = `${this.baseUrl}`;
    console.log('createUser url -> ' + url);
    return this.httpClient.post(url, user, this.httpOptions).pipe(
      catchError(this.handleError('createUser', user))
    );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
