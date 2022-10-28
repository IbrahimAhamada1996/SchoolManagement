import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {OfficeRoom} from '../models/office-room';

@Injectable({
  providedIn: 'root'
})
export class OfficeRoomService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getOfficeRooms(): Observable<OfficeRoom> {
    return this.http
      .get<OfficeRoom>(this.apiURL + "/offreRooms")
      .pipe(retry(1), catchError(this.handleError));
  }

  getOfficeRoom(id: number): Observable<OfficeRoom> {
    return this.http
      .get<OfficeRoom>(this.apiURL + "/offreRooms/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createOfficeRoom(offreRoom: OfficeRoom): Observable<OfficeRoom> {
    return this.http
      .post<OfficeRoom>(this.apiURL + "/offreRooms", JSON.stringify(offreRoom), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateOfficeRoom(id: number, offreRoom: OfficeRoom): Observable<OfficeRoom> {
    return this.http
      .put<OfficeRoom>(this.apiURL + "/offreRooms/" + id, JSON.stringify(offreRoom), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteOfficeRoom(id: number): Observable<OfficeRoom> {
    return this.http
      .delete<OfficeRoom>(this.apiURL + "/offreRooms/" + id, this.httpOptions)
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
