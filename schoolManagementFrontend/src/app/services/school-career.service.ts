import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {SchoolCareer} from '../models/school-career';

@Injectable({
  providedIn: 'root'
})
export class SchoolCareerService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getSchoolCareers(): Observable<SchoolCareer> {
    return this.http
      .get<SchoolCareer>(this.apiURL + "/schoolCareers")
      .pipe(retry(1), catchError(this.handleError));
  }

  getSchoolCareer(id: number): Observable<SchoolCareer> {
    return this.http
      .get<SchoolCareer>(this.apiURL + "/schoolCareers/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createSchoolCareer(schoolCareer: SchoolCareer): Observable<SchoolCareer> {
    return this.http
      .post<SchoolCareer>(this.apiURL + "/schoolCareers", JSON.stringify(schoolCareer), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateSchoolCareer(id: number, schoolCareer: SchoolCareer): Observable<SchoolCareer> {
    return this.http
      .put<SchoolCareer>(this.apiURL + "/schoolCareers/" + id, JSON.stringify(schoolCareer), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteSchoolCareer(id: number): Observable<SchoolCareer> {
    return this.http
      .delete<SchoolCareer>(this.apiURL + "/schoolCareers/" + id, this.httpOptions)
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
