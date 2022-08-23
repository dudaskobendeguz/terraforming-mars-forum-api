import { Component, OnInit } from '@angular/core';
import {LeaguePost} from "../../../interfaces/league-post";
import {LeaguePostService} from "../../../services/league-post/league-post.service";
import {MessageLoggerService} from "../../../services/message-logger/message-logger.service";

@Component({
  selector: 'app-league-post-container',
  templateUrl: './league-post-container.component.html',
  styleUrls: ['./league-post-container.component.css']
})
export class LeaguePostContainerComponent implements OnInit {
  leaguePosts: LeaguePost[] = [];

  constructor(
    private studentService: LeaguePostService,
    private messageService: MessageLoggerService
  ) { }

  ngOnInit(): void {
    this.getAllLeaguePosts();
  }

  private getAllLeaguePosts(): void {
    this.studentService.getLeaguePosts()
      .subscribe( (leaguePosts) => {
        this.leaguePosts = leaguePosts;
        this.messageService.add(LeaguePostContainerComponent.name, 'getAllLeaguePosts: league posts fetched');
        }
      );
  }
}
