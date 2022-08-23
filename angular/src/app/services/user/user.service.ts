import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, tap} from "rxjs";
import {User} from "../../interfaces/user";
import {ErrorHandlerService} from "../error-handler/error-handler.service";
import {MessageLoggerService} from "../message-logger/message-logger.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private usersUrl: string = "api/users";
  private httpOptions: {} = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(
    private messageLogger: MessageLoggerService,
    private http: HttpClient,
    private errorHandler: ErrorHandlerService
  ) { }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl)
      .pipe(
        tap((_) => this.log(`users fetched(TAP)`)),
        catchError(this.errorHandler.handleError<User[]>('getUsers', []))
      );
  }

  private log(message: string): void {
    this.messageLogger.add(UserService.name, message);
  }
}
