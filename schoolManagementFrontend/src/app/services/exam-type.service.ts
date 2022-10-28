import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {ExamType} from '../models/exam-type';

@Injectable({
  providedIn: 'root'
})
export class ExamTypeService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getExamTypes(): Observable<ExamType> {
    return this.http
      .get<ExamType>(this.apiURL + "/examTypes")
      .pipe(retry(1), catchError(this.handleError));
  }

  getExamType(id: number): Observable<ExamType> {
    return this.http
      .get<ExamType>(this.apiURL + "/examTypes/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createExamType(examType: ExamType): Observable<ExamType> {
    return this.http
      .post<ExamType>(this.apiURL + "/examTypes", JSON.stringify(examType), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateExamType(id: number, examType: ExamType): Observable<ExamType> {
    return this.http
      .put<ExamType>(this.apiURL + "/examTypes/" + id, JSON.stringify(examType), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteExamType(id: number): Observable<ExamType> {
    return this.http
      .delete<ExamType>(this.apiURL + "/examTypes/" + id, this.httpOptions)
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
