import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Employee} from '../models/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  getEmployees(): Observable<Employee> {
    return this.http
      .get<Employee>(this.apiURL + "/employees")
      .pipe(retry(1), catchError(this.handleError));
  }

  getEmployee(id: number): Observable<Employee> {
    return this.http
      .get<Employee>(this.apiURL + "/employees/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createEmployee(employee: Employee): Observable<Employee> {
    return this.http
      .post<Employee>(this.apiURL + "/employees", JSON.stringify(employee), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateEmployee(id: number, employee: Employee): Observable<Employee> {
    return this.http
      .put<Employee>(this.apiURL + "/employees/" + id, JSON.stringify(employee), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteEmployee(id: number): Observable<Employee> {
    return this.http
      .delete<Employee>(this.apiURL + "/employees/" + id, this.httpOptions)
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
