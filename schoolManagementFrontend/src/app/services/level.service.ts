import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Level} from '../models/level';

@Injectable({
  providedIn: 'root'
})
export class LevelService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getLevels(): Observable<Level> {
    return this.http
      .get<Level>(this.apiURL + "/levels")
      .pipe(retry(1), catchError(this.handleError));
  }

  getLevel(id: number): Observable<Level> {
    return this.http
      .get<Level>(this.apiURL + "/levels/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createLevel(level: Level): Observable<Level> {
    return this.http
      .post<Level>(this.apiURL + "/levels", JSON.stringify(level), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateLevel(id: number, level: Level): Observable<Level> {
    return this.http
      .put<Level>(this.apiURL + "/levels/" + id, JSON.stringify(level), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteLevel(id: number): Observable<Level> {
    return this.http
      .delete<Level>(this.apiURL + "/levels/" + id, this.httpOptions)
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
