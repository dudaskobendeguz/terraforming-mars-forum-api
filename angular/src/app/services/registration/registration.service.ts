import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {MessageLoggerService} from "../message-logger/message-logger.service";
import {ErrorHandlerService} from "../error-handler/error-handler.service";
import {catchError, Observable, tap} from "rxjs";
import {User} from "../../interfaces/user";

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  private commentsUrl: string = "api/users";
  private httpOptions: {} = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(
    private messageLogger: MessageLoggerService,
    private http: HttpClient,
    private errorHandler: ErrorHandlerService
  ) { }



  private log(message: string): void {
    this.messageLogger.add(RegistrationService.name, message);
  }
}
