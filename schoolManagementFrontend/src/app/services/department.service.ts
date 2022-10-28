import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Department} from '../models/department';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getDepartments(): Observable<Department> {
    return this.http
      .get<Department>(this.apiURL + "/departments")
      .pipe(retry(1), catchError(this.handleError));
  }

  getDepartment(id: number): Observable<Department> {
    return this.http
      .get<Department>(this.apiURL + "/departments/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createDepartment(department: Department): Observable<Department> {
    return this.http
      .post<Department>(this.apiURL + "/departments", JSON.stringify(department), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateDepartment(id: number, department: Department): Observable<Department> {
    return this.http
      .put<Department>(this.apiURL + "/departments/" + id, JSON.stringify(department), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteDepartment(id: number): Observable<Department> {
    return this.http
      .delete<Department>(this.apiURL + "/departments/" + id, this.httpOptions)
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
