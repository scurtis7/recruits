import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from "rxjs";
import {Player247} from "../model/player247";
import {catchError} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private httpClient: HttpClient) {
  }

  getPlayersByCollege(college: string): Observable<Player247[]> {
    const url = `/api/players/college/${college}/`;
    return this.httpClient.get<Player247[]>(url).pipe(
      catchError(this.handleError<Player247[]>(`getPlayersByCollege`))
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
