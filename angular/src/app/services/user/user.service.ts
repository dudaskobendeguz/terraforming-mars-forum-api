import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, tap} from "rxjs";
import {User} from "../../interfaces/user";
import {ErrorHandlerService} from "../error-handler/error-handler.service";
import {MessageLoggerService} from "../message-logger/message-logger.service";
import {InMemoryDataService} from "../in-memory-data.service";

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
    private errorHandler: ErrorHandlerService,
    private memory: InMemoryDataService
  ) { }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl)
      .pipe(
        tap((_) => this.log(`users fetched(TAP)`)),
        catchError(this.errorHandler.handleError<User[]>('getUsers', []))
      );
  }

  getUserById(id: string): Observable<User> {
    const url = `${this.usersUrl}/${id}`
    return this.http.get<User>(url)
      .pipe(
        tap((_) => this.log('getUserById(TAP)')),
        catchError(this.errorHandler.handleError<User>('getUserById'))
      )
  }

  private log(message: string): void {
    this.messageLogger.add(UserService.name, message);
  }


  getLoggedInUser(): User {
    return this.memory.createDb().users[0];
  }

}
