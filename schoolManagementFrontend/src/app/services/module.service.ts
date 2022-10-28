import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, Observable, retry, throwError} from 'rxjs';
import { environment } from 'src/environments/environment';
import {Module} from '../models/module';

@Injectable({
  providedIn: 'root'
})
export class ModuleService {

  apiURL = environment.apiURL;

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };


  getModules(): Observable<Module> {
    return this.http
      .get<Module>(this.apiURL + "/modules")
      .pipe(retry(1), catchError(this.handleError));
  }

  getModule(id: number): Observable<Module> {
    return this.http
      .get<Module>(this.apiURL + "/modules/" + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  createModule(module: Module): Observable<Module> {
    return this.http
      .post<Module>(this.apiURL + "/modules", JSON.stringify(module), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  updateModule(id: number, module: Module): Observable<Module> {
    return this.http
      .put<Module>(this.apiURL + "/modules/" + id, JSON.stringify(module), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteModule(id: number): Observable<Module> {
    return this.http
      .delete<Module>(this.apiURL + "/modules/" + id, this.httpOptions)
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
