import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Faculty} from '../models/faculty';

@Injectable({
  providedIn: 'root'
})
export class FacultyService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getFacultys(): Observable<Faculty> {
    return this.http
      .get<Faculty>(this.apiURL + "/faculties")
      .pipe(retry(1), catchError(this.handleError));
  }

  getFaculty(id: number): Observable<Faculty> {
    return this.http
      .get<Faculty>(this.apiURL + "/faculties/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createFaculty(facultie: Faculty): Observable<Faculty> {
    return this.http
      .post<Faculty>(this.apiURL + "/faculties", JSON.stringify(facultie), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateFaculty(id: number, facultie: Faculty): Observable<Faculty> {
    return this.http
      .put<Faculty>(this.apiURL + "/faculties/" + id, JSON.stringify(facultie), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteFaculty(id: number): Observable<Faculty> {
    return this.http
      .delete<Faculty>(this.apiURL + "/faculties/" + id, this.httpOptions)
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
