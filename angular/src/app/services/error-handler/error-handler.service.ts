import { Injectable } from '@angular/core';
import {MessageLoggerService} from "../message-logger/message-logger.service";
import {Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlerService {

  constructor(
    private messageLogger: MessageLoggerService
  ) { }

  handleError<T>(operation: string, result?: T): (error: any) => Observable<T> {
    return (error: any): Observable<T> => {

      // send the error to remote logging infrastructure
      console.error(error);

      // better job of transforming error for user consumption
      this.messageLogger.add(ErrorHandlerService.name, `${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
