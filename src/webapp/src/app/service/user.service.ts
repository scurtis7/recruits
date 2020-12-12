import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SiteUser } from '../model/site-user';

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

  createUser(user: SiteUser): any {
    console.log('createUser url -> ' + this.baseUrl);
    this.httpClient.post<SiteUser>(this.baseUrl, user, this.httpOptions)
      .subscribe({
        next: retUser => {
          console.log('Site User Created: ' + retUser.fullname);
          return retUser;
        },
        error: error => {
          console.error('There was an error!', error);
          return null;
        }
      });
  }

  // /**
  //  * Handle Http operation that failed.
  //  * Let the app continue.
  //  * @param operation - name of the operation that failed
  //  * @param result - optional value to return as the observable result
  //  */
  // private handleError<T>(operation = 'operation', result?: T) {
  //   return (error: any): Observable<T> => {
  //
  //     // TODO: send the error to remote logging infrastructure
  //     console.error(error); // log to console instead
  //
  //     // Let the app keep running by returning an empty result.
  //     return of(result as T);
  //   };
  // }

}
