import { Injectable } from '@angular/core';
import {MessageLoggerService} from "../message-logger/message-logger.service";
import {Observable, of} from "rxjs";
import {Router} from "@angular/router";
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlerService {
  public errorMessage: string = '';

  constructor(
    private router: Router,
    private messageLogger: MessageLoggerService
  ) { }

  handleError<T>(operation: string, result?: T): (error: HttpErrorResponse) => Observable<T> {
    return (error: any): Observable<T> => {

      // send the error to remote logging infrastructure
      console.error(error);

      // better job of transforming error for user consumption
      this.messageLogger.add(ErrorHandlerService.name, `${operation} failed: ${error.message}`);
      switch (error.status) {
        case 404: {
          this.handle404Error(error);
          break;
        }
        case 500: {
          this.handle500Error(error);
          break
        }
        default: {
          this.handleOtherError(error);
        }
      }

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  private handle404Error(error: HttpErrorResponse): void {
    this.createErrorMessage(error);
    this.router.navigate(['/page-not-found']);
  }

  private handle500Error(error: HttpErrorResponse): void {
    this.createErrorMessage(error);
    this.router.navigate(['/internal-server-error']);
  }

  private handleOtherError(error: HttpErrorResponse): void {
    this.createErrorMessage(error);
    //TODO
  }

  private createErrorMessage = (error: HttpErrorResponse) => {
    this.errorMessage = error.error ? error.error : error.statusText;
}
}
