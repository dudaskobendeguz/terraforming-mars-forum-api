import {Injectable} from '@angular/core';
import {MessageLoggerService} from "../message-logger/message-logger.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ErrorHandlerService} from "../error-handler/error-handler.service";
import {catchError, Observable, of, tap} from "rxjs";
import {UserPost} from "../../interfaces/user-post";

@Injectable({
  providedIn: 'root'
})
export class UserPostService {
  private userPostsUrl: string = "api/userPosts";
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

  getUserPosts(): Observable<UserPost[]> {
    return this.http.get<UserPost[]>(this.userPostsUrl)
      .pipe(
        tap((_) => this.log(`user posts fetched (TAP)`)),
        catchError(this.errorHandler.handleError<UserPost[]>('getUserPosts', []))
      );
  }

  addUserPost(userPost: UserPost): Observable<UserPost> {
    // Generate ID
    userPost.id = ++this.generateId;
    return this.http.post<UserPost>(this.userPostsUrl, userPost, this.httpOptions)
      .pipe(
        tap((_) => this.log(`create user post with id=${userPost.id} (TAP)`)),
        catchError(this.errorHandler.handleError<UserPost>('addUserPost'))
      );
  }

  updateUserPost(userPost: UserPost): Observable<UserPost> {
    return this.http.put<UserPost>(this.userPostsUrl, userPost, this.httpOptions)
      .pipe(
        tap((_) => this.log(`update hero with id=${userPost.id} (TAP)`)),
        catchError(this.errorHandler.handleError<UserPost>('updateUserPost'))
      );
  }

  deleteUserPost(userPost: UserPost): Observable<UserPost> {
    const url = `${this.userPostsUrl}/${userPost.id}`;
    return this.http.delete<UserPost>(url, this.httpOptions)
      .pipe(
        tap((_) => this.log(`delete user post with id=${userPost.id} (TAP)`)),
        catchError(this.errorHandler.handleError<UserPost>("deleteUserPost"))
      );
  }

  private log(message: string): void {
    this.messageLogger.add(UserPostService.name, message);
  }
}
