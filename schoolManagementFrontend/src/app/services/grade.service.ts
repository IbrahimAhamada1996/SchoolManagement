import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Grade} from '../models/grade';

@Injectable({
  providedIn: 'root'
})
export class GradeService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getGrades(): Observable<Grade> {
    return this.http
      .get<Grade>(this.apiURL + "/grades")
      .pipe(retry(1), catchError(this.handleError));
  }

  getGrade(id: number): Observable<Grade> {
    return this.http
      .get<Grade>(this.apiURL + "/grades/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createGrade(grade: Grade): Observable<Grade> {
    return this.http
      .post<Grade>(this.apiURL + "/grades", JSON.stringify(grade), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateGrade(id: number, grade: Grade): Observable<Grade> {
    return this.http
      .put<Grade>(this.apiURL + "/grades/" + id, JSON.stringify(grade), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteGrade(id: number): Observable<Grade> {
    return this.http
      .delete<Grade>(this.apiURL + "/grades/" + id, this.httpOptions)
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
