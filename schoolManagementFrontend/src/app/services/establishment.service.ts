import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Establishment} from '../models/establishment';

@Injectable({
  providedIn: 'root'
})
export class EstablishmentService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getEstablishments(): Observable<Establishment> {
    return this.http
      .get<Establishment>(this.apiURL + "/establishments")
      .pipe(retry(1), catchError(this.handleError));
  }

  getEstablishment(id: number): Observable<Establishment> {
    return this.http
      .get<Establishment>(this.apiURL + "/establishments/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createEstablishment(establishment: Establishment): Observable<Establishment> {
    return this.http
      .post<Establishment>(this.apiURL + "/establishments", JSON.stringify(establishment), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateEstablishment(id: number, establishment: Establishment): Observable<Establishment> {
    return this.http
      .put<Establishment>(this.apiURL + "/establishments/" + id, JSON.stringify(establishment), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteEstablishment(id: number): Observable<Establishment> {
    return this.http
      .delete<Establishment>(this.apiURL + "/establishments/" + id, this.httpOptions)
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
