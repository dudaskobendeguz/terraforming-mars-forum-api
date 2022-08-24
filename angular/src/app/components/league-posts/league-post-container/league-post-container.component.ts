import { Component, OnInit } from '@angular/core';
import {LeaguePost} from "../../../interfaces/league-post";
import {LeaguePostService} from "../../../services/league-post/league-post.service";
import {MessageLoggerService} from "../../../services/message-logger/message-logger.service";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-league-post-container',
  templateUrl: './league-post-container.component.html',
  styleUrls: ['./league-post-container.component.css']
})
export class LeaguePostContainerComponent implements OnInit {
  leaguePosts: LeaguePost[] = [];
  leagueDetails = this.formBuilder.group( {id: 0});

  constructor(
    private studentService: LeaguePostService,
    private messageService: MessageLoggerService,
    private formBuilder: FormBuilder
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

  onSubmit():void {
    this.studentService.getLeaguePostById(<number>this.leagueDetails.value.id)
      .subscribe( (leaguePost) => {
        this.leaguePosts = [leaguePost];
        this.messageService.add(LeaguePostContainerComponent.name, `leaguePost fetched by the given id:${leaguePost.id}`);
        }

      );
  }
}
