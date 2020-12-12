import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Player247 } from '../model/player247';
import { catchError } from 'rxjs/operators';
import { SiteUser } from '../model/site-user';
import { Router } from '@angular/router';

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

  constructor(private httpClient: HttpClient, private router: Router) {
  }

  createUser(user: SiteUser): void {
    console.log('createUser url -> ' + this.baseUrl);
    this.httpClient.post<SiteUser>(this.baseUrl, user, this.httpOptions)
      .subscribe({
        next: response => {
          console.log('Site User Created: ' + response.fullname);
          this.router.navigate(['/signin']);
        },
        error: error => {
          console.error('There was an error!', error);
        }
      });
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
