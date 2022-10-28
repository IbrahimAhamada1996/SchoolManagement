import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Deadline} from '../models/deadline';

@Injectable({
  providedIn: 'root'
})
export class DeadlineService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getDeadlines(): Observable<Deadline> {
    return this.http
      .get<Deadline>(this.apiURL + "/deadlines")
      .pipe(retry(1), catchError(this.handleError));
  }

  getDeadline(id: number): Observable<Deadline> {
    return this.http
      .get<Deadline>(this.apiURL + "/deadlines/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createDeadline(deadline: Deadline): Observable<Deadline> {
    return this.http
      .post<Deadline>(this.apiURL + "/deadlines", JSON.stringify(deadline), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateDeadline(id: number, deadline: Deadline): Observable<Deadline> {
    return this.http
      .put<Deadline>(this.apiURL + "/deadlines/" + id, JSON.stringify(deadline), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteDeadline(id: number): Observable<Deadline> {
    return this.http
      .delete<Deadline>(this.apiURL + "/deadlines/" + id, this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }


  // Error handling
  handleError(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    // window.alert(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }
}
