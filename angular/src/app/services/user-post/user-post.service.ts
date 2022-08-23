import { Injectable } from '@angular/core';
import {MessageLoggerService} from "../message-logger/message-logger.service";
import {HttpClient} from "@angular/common/http";
import {ErrorHandlerService} from "../error-handler/error-handler.service";
import {catchError, Observable, tap} from "rxjs";
import {UserPost} from "../../interfaces/user-post";

@Injectable({
  providedIn: 'root'
})
export class UserPostService {
  private userPostsUrl: string = "api/userPosts";

  constructor(
    private messageLogger: MessageLoggerService,
    private http: HttpClient,
    private errorHandler: ErrorHandlerService
  ) { }

  getUserPosts(): Observable<UserPost[]> {
    return this.http.get<UserPost[]>(this.userPostsUrl)
      .pipe(
        tap((_) => this.log(`user posts fetched (TAP)`)),
        catchError(this.errorHandler.handleError<UserPost[]>('getUserPosts', []))
      )
  }

  private log(message: string): void {
    this.messageLogger.add(UserPostService.name, message);
  }
}
