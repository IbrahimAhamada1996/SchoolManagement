import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Schedule} from '../models/schedule';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getSchedules(): Observable<Schedule> {
    return this.http
      .get<Schedule>(this.apiURL + "/schedules")
      .pipe(retry(1), catchError(this.handleError));
  }

  getSchedule(id: number): Observable<Schedule> {
    return this.http
      .get<Schedule>(this.apiURL + "/schedules/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createSchedule(schedule: Schedule): Observable<Schedule> {
    return this.http
      .post<Schedule>(this.apiURL + "/schedules", JSON.stringify(schedule), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateSchedule(id: number, schedule: Schedule): Observable<Schedule> {
    return this.http
      .put<Schedule>(this.apiURL + "/schedules/" + id, JSON.stringify(schedule), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteSchedule(id: number): Observable<Schedule> {
    return this.http
      .delete<Schedule>(this.apiURL + "/schedules/" + id, this.httpOptions)
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
