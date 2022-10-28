import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import { Payment } from '../models/payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getPayments(): Observable<Payment> {
    return this.http
      .get<Payment>(this.apiURL + "/payments")
      .pipe(retry(1), catchError(this.handleError));
  }

  getPayment(id: number): Observable<Payment> {
    return this.http
      .get<Payment>(this.apiURL + "/payments/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createPayment(payment: Payment): Observable<Payment> {
    return this.http
      .post<Payment>(this.apiURL + "/payments", JSON.stringify(payment), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updatePayment(id: number, payment: Payment): Observable<Payment> {
    return this.http
      .put<Payment>(this.apiURL + "/payments/" + id, JSON.stringify(payment), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deletePayment(id: number): Observable<Payment> {
    return this.http
      .delete<Payment>(this.apiURL + "/payments/" + id, this.httpOptions)
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
