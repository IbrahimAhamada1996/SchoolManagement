import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Course} from '../models/course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getCourses(): Observable<Course> {
    return this.http
      .get<Course>(this.apiURL + "/courses")
      .pipe(retry(1), catchError(this.handleError));
  }

  getCourse(id: number): Observable<Course> {
    return this.http
      .get<Course>(this.apiURL + "/courses/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createCourse(course: Course): Observable<Course> {
    return this.http
      .post<Course>(this.apiURL + "/courses", JSON.stringify(course), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateCourse(id: number, course: Course): Observable<Course> {
    return this.http
      .put<Course>(this.apiURL + "/courses/" + id, JSON.stringify(course), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteCourse(id: number): Observable<Course> {
    return this.http
      .delete<Course>(this.apiURL + "/courses/" + id, this.httpOptions)
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
