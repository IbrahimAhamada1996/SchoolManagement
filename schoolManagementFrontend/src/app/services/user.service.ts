import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {User} from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getUsers(): Observable<User> {
    return this.http
      .get<User>(this.apiURL + "/users")
      .pipe(retry(1), catchError(this.handleError));
  }

  getUser(id: number): Observable<User> {
    return this.http
      .get<User>(this.apiURL + "/users/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createUser(user: User): Observable<User> {
    return this.http
      .post<User>(this.apiURL + "/users", JSON.stringify(user), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateUser(id: number, user: User): Observable<User> {
    return this.http
      .put<User>(this.apiURL + "/users/" + id, JSON.stringify(user), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteUser(id: number): Observable<User> {
    return this.http
      .delete<User>(this.apiURL + "/users/" + id, this.httpOptions)
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
