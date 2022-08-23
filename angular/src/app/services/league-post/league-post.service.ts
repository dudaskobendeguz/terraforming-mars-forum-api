import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {MessageLoggerService} from "../message-logger/message-logger.service";
import {ErrorHandlerService} from "../error-handler/error-handler.service";
import {catchError, Observable, tap} from "rxjs";
import {LeaguePost} from "../../interfaces/league-post";

@Injectable({
  providedIn: 'root'
})
export class LeaguePostService {
  private leaguePostsUrl: string = 'api/league-posts';
  private httpOptions: {} = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(
    private messageService: MessageLoggerService,
    private errorHandler: ErrorHandlerService,
    private http: HttpClient
  ) { }

  getLeaguePosts(): Observable<LeaguePost[]> {
    return this.http.get<LeaguePost[]>(this.leaguePostsUrl)
      .pipe(
        tap((_) => this.log('getLeaguePosts(TAP)')),
        catchError(this.errorHandler.handleError<LeaguePost[]>('getLeaguePosts', []))
      );
  }

  private log(message: string): void {
    this.messageService.add(LeaguePostService.name, message);
  }
}
