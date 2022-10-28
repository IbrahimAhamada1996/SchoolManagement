import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Inscription} from '../models/inscription';

@Injectable({
  providedIn: 'root'
})
export class InscriptionService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getInscriptions(): Observable<Inscription> {
    return this.http
      .get<Inscription>(this.apiURL + "/inscriptions")
      .pipe(retry(1), catchError(this.handleError));
  }

  getInscription(id: number): Observable<Inscription> {
    return this.http
      .get<Inscription>(this.apiURL + "/inscriptions/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createInscription(inscription: Inscription): Observable<Inscription> {
    return this.http
      .post<Inscription>(this.apiURL + "/inscriptions", JSON.stringify(inscription), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateInscription(id: number, inscription: Inscription): Observable<Inscription> {
    return this.http
      .put<Inscription>(this.apiURL + "/inscriptions/" + id, JSON.stringify(inscription), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteInscription(id: number): Observable<Inscription> {
    return this.http
      .delete<Inscription>(this.apiURL + "/inscriptions/" + id, this.httpOptions)
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
