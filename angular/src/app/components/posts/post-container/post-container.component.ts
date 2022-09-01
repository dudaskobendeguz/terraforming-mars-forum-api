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
  public isLoading: boolean = true;
  public readonly sortOptions = {
    'newest': () => {this.filterByDate(true)},
    'oldest': () => {this.filterByDate(false)},
    'shuffle': () => {this.shuffle()},
  };

  filter: () => void = this.sortOptions.newest;

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
      this.isLoading = false;
    });
  }

  private getAllLeaguePost() {
    this.leaguePostService.getLeaguePosts().subscribe((leaguePosts) => {
      leaguePosts.forEach((leaguePost) => this.posts.push({leaguePost: leaguePost}));
      this.log('getAllLeaguePost: all league post added to "posts" array');
      this.filterByDate(true);
      this.isLoading = false;
    })
  }

  private shuffle() {
    this.posts = arrayShuffle(this.posts);
  }

  public filterByDate(isAscending: boolean): void {
    this.posts.sort((post1, post2) => {
      const post1Date: Date = PostContainerComponent.getPostDate(post1);
      const post2Date: Date = PostContainerComponent.getPostDate(post2);
      return isAscending ? (post1Date < post2Date ? 1 : -1) : (post2Date < post1Date ? 1 : -1);
    });
  }

  private static getPostDate(post: Post): Date {
    if (post.userPost) {
      return  post.userPost.timestamp;
    } else if (post.leaguePost) {
      return  post.leaguePost.timestamp;
    } else {
      throw ReferenceError("Post interface doesn't have any type of post");
    }
  }

  private log(message: string): void {
    this.logger.add(PostContainerComponent.name, message);
  }
}
