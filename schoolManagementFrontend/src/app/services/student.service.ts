import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Student} from '../models/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  getStudents(): Observable<Student> {
    return this.http
      .get<Student>(this.apiURL + "/students")
      .pipe(retry(1), catchError(this.handleError));
  }

  getStudent(id: number): Observable<Student> {
    return this.http
      .get<Student>(this.apiURL + "/students/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createStudent(Student: any): Observable<Student> {
    return this.http
      .post<Student>(this.apiURL + "/students", JSON.stringify(Student), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateStudent(id: number, Student: any): Observable<Student> {
    return this.http
      .put<Student>(this.apiURL + "/students/" + id, JSON.stringify(Student), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteStudent(id: number): Observable<Student> {
    return this.http
      .delete<Student>(this.apiURL + "/students/" + id, this.httpOptions)
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
