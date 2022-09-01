import { Component, OnInit } from '@angular/core';
import {UserPostService} from "../../../services/user-post/user-post.service";
import {LeaguePostService} from "../../../services/league-post/league-post.service";
import {MessageLoggerService} from "../../../services/message-logger/message-logger.service";
import {Post} from "../../../interfaces/post";
import arrayShuffle from "array-shuffle";

@Component({
  selector: 'app-post-container',
  templateUrl: './post-container.component.html',
  styleUrls: ['./post-container.component.css']
})
export class PostContainerComponent implements OnInit {
  public posts:Post[] = [];

  constructor(
    private userPostService: UserPostService,
    private leaguePostService: LeaguePostService,
    private logger: MessageLoggerService
  ) { }

  ngOnInit(): void {
    this.getAllUserPost();
    this.getAllLeaguePost();
  }

  private getAllUserPost(): void {
    this.userPostService.getUserPosts().subscribe((userPosts) => {
      userPosts.forEach((userPost) => this.posts.push({userPost: userPost}));
      this.log('getAllUserPost: all user post added to "posts" array');
      this.filterByDate(true);
      // this.posts = arrayShuffle(this.posts);
    });
  }

  private getAllLeaguePost() {
    this.leaguePostService.getLeaguePosts().subscribe((leaguePosts) => {
      leaguePosts.forEach((leaguePost) => this.posts.push({leaguePost: leaguePost}));
      this.log('getAllLeaguePost: all league post added to "posts" array');
      this.filterByDate(true);
      // this.posts = arrayShuffle(this.posts);
    })
  }

  private log(message: string): void {
    this.logger.add(PostContainerComponent.name, message);
  }

  private filterByDate(isAscending: boolean): void {
    this.posts.sort((post1, post2) => {
      const date1: Date = (post1.userPost?.timestamp) ? post1.userPost.timestamp : (post1.leaguePost?.timestamp) ? post1.leaguePost.timestamp : new Date();
      const date2: Date = (post2.userPost?.timestamp) ? post2.userPost.timestamp : (post2.leaguePost?.timestamp) ? post2.leaguePost.timestamp : new Date();
      return isAscending ? (date1 < date2 ? 1 : -1) : (date2 < date1 ? 1 : -1);
    });
  }
}
