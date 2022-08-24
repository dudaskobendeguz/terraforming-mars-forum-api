import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {MessageLoggerService} from "../message-logger/message-logger.service";
import {ErrorHandlerService} from "../error-handler/error-handler.service";
import {catchError, Observable, tap} from "rxjs";
import {User} from "../../interfaces/user";
import {PostComment} from "../../interfaces/post-comment";
import {UserPost} from "../../interfaces/user-post";

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private commentsUrl: string = "api/comments";
  private httpOptions: {} = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(
    private messageLogger: MessageLoggerService,
    private http: HttpClient,
    private errorHandler: ErrorHandlerService
  ) { }

  getComments(): Observable<Comment[]> {
    return this.http.get<Comment[]>(this.commentsUrl)
      .pipe(
        tap((_) => this.log(`comments fetched(TAP)`)),
        catchError(this.errorHandler.handleError<Comment[]>('getComments', []))
      );
  }

  private log(message: string): void {
    this.messageLogger.add(CommentService.name, message);
  }

  addComment(comment: PostComment): Observable<PostComment> {
    // TODO: call this method from the page detail view if created

    return this.http.post<PostComment>(this.commentsUrl, comment, this.httpOptions)
      .pipe(
        tap((a) => this.log(`created comment | id=${comment.id}`)),
        catchError(this.errorHandler.handleError<UserPost>('addUserPost'))
      )
  }
}

