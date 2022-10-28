import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Session} from '../models/session';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getSessions(): Observable<Session> {
    return this.http
      .get<Session>(this.apiURL + "/sessions")
      .pipe(retry(1), catchError(this.handleError));
  }

  getSession(id: number): Observable<Session> {
    return this.http
      .get<Session>(this.apiURL + "/sessions/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createSession(session: Session): Observable<Session> {
    return this.http
      .post<Session>(this.apiURL + "/sessions", JSON.stringify(session), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateSession(id: number, session: Session): Observable<Session> {
    return this.http
      .put<Session>(this.apiURL + "/sessions/" + id, JSON.stringify(session), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteSession(id: number): Observable<Session> {
    return this.http
      .delete<Session>(this.apiURL + "/sessions/" + id, this.httpOptions)
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
