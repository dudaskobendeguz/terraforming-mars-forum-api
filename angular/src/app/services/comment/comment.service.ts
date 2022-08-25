import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {MessageLoggerService} from "../message-logger/message-logger.service";
import {ErrorHandlerService} from "../error-handler/error-handler.service";
import {catchError, Observable, tap} from "rxjs";
import {PostComment} from "../../interfaces/post-comment";
import {UserPost} from "../../interfaces/user-post";
import {User} from "../../interfaces/user";

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private commentsUrl: string = "api/comments";
  private httpOptions: {} = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  private generateId: number = 100;

  constructor(
    private messageLogger: MessageLoggerService,
    private http: HttpClient,
    private errorHandler: ErrorHandlerService
  ) {
  }

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

  createComment(user: User, description: string): PostComment {
    return {
      id: ++this.generateId,
      user: user,
      description: description,
      timestamp: new Date()
    };
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

