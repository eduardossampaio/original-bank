import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import {  throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private SERVER_URL = "http://localhost:8080";

  constructor(private httpClient: HttpClient) { }

  handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error!';
    if (error.error instanceof ErrorEvent) {
      // Client-side errors
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Server-side errors
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }

  public get(){
		return this.httpClient.get(this.SERVER_URL+'/location').pipe(catchError(this.handleError));
  }

  public post(apelido:string, cep:string){
		return this.httpClient.post(this.SERVER_URL+'/location', {
      identifier : apelido,
      cep : cep
    }).pipe(catchError(this.handleError));
  }

  public delete(id: number){
    return this.httpClient.delete(this.SERVER_URL+'/location/'+id).pipe(catchError(this.handleError));
	}

}
