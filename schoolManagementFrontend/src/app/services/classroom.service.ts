import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Classroom} from '../models/classroom';

@Injectable({
  providedIn: 'root'
})
export class ClassroomService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getClassrooms(): Observable<Classroom> {
    return this.http
      .get<Classroom>(this.apiURL + "/classrooms")
      .pipe(retry(1), catchError(this.handleError));
  }

  getClassroom(id: number): Observable<Classroom> {
    return this.http
      .get<Classroom>(this.apiURL + "/classrooms/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createClassroom(classroom: Classroom): Observable<Classroom> {
    return this.http
      .post<Classroom>(this.apiURL + "/classrooms", JSON.stringify(classroom), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateClassroom(id: number, classroom: Classroom): Observable<Classroom> {
    return this.http
      .put<Classroom>(this.apiURL + "/classrooms/" + id, JSON.stringify(classroom), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteClassroom(id: number): Observable<Classroom> {
    return this.http
      .delete<Classroom>(this.apiURL + "/classrooms/" + id, this.httpOptions)
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
