import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Unity} from '../models/unity';

@Injectable({
  providedIn: 'root'
})
export class UnityService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getUnitys(): Observable<Unity> {
    return this.http
      .get<Unity>(this.apiURL + "/unities")
      .pipe(retry(1), catchError(this.handleError));
  }

  getUnity(id: number): Observable<Unity> {
    return this.http
      .get<Unity>(this.apiURL + "/unities/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createUnity(unitie: Unity): Observable<Unity> {
    return this.http
      .post<Unity>(this.apiURL + "/unities", JSON.stringify(unitie), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateUnity(id: number, unitie: Unity): Observable<Unity> {
    return this.http
      .put<Unity>(this.apiURL + "/unities/" + id, JSON.stringify(unitie), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteUnity(id: number): Observable<Unity> {
    return this.http
      .delete<Unity>(this.apiURL + "/unities/" + id, this.httpOptions)
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
