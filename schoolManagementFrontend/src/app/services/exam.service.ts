import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Exam} from '../models/exam';

@Injectable({
  providedIn: 'root'
})
export class ExamService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getExams(): Observable<Exam> {
    return this.http
      .get<Exam>(this.apiURL + "/exams")
      .pipe(retry(1), catchError(this.handleError));
  }

  getExam(id: number): Observable<Exam> {
    return this.http
      .get<Exam>(this.apiURL + "/exams/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createExam(exam: Exam): Observable<Exam> {
    return this.http
      .post<Exam>(this.apiURL + "/exams", JSON.stringify(exam), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateExam(id: number, exam: Exam): Observable<Exam> {
    return this.http
      .put<Exam>(this.apiURL + "/exams/" + id, JSON.stringify(exam), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteExam(id: number): Observable<Exam> {
    return this.http
      .delete<Exam>(this.apiURL + "/exams/" + id, this.httpOptions)
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
