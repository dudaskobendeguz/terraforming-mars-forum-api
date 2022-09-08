import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, tap} from "rxjs";
import {User} from "../../interfaces/user";
import {ErrorHandlerService} from "../error-handler/error-handler.service";
import {MessageLoggerService} from "../message-logger/message-logger.service";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private usersUrl: string = `${environment.baseUrl}/api/users`;
  private httpOptions: {} = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(
    private messageLogger: MessageLoggerService,
    private http: HttpClient,
    private errorHandler: ErrorHandlerService,
  ) { }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl)
      .pipe(
        tap((_) => this.log(`users fetched(TAP)`)),
        catchError(this.errorHandler.handleError<User[]>('getUsers', []))
      );
  }

  getUserById(id: number): Observable<User> {
    const url = `${this.usersUrl}/${id}`
    return this.http.get<User>(url)
      .pipe(
        tap((_) => this.log('getUserById(TAP)')),
        catchError(this.errorHandler.handleError<User>('getUserById'))
      )
  }

  addUser(user: User): Observable<User> {
    console.log(user)
    return this.http.post<User>(this.usersUrl, user, this.httpOptions).pipe(
      tap(() => this.log(`User saved id=${user.id}`),
        catchError(this.errorHandler.handleError<User>('registerUser')))
    );
  }

  private log(message: string): void {
    this.messageLogger.add(UserService.name, message);
  }

}
