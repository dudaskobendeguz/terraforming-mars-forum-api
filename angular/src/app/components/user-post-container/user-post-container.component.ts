import { Component, OnInit } from '@angular/core';
import {UserPost} from "../../interfaces/user-post";
import {UserPostService} from "../../services/user-post/user-post.service";
import {MessageLoggerService} from "../../services/message-logger/message-logger.service";

@Component({
  selector: 'app-user-post-container',
  templateUrl: './user-post-container.component.html',
  styleUrls: ['./user-post-container.component.css']
})
export class UserPostContainerComponent implements OnInit {

  userPosts: UserPost[] = [];

  constructor(
    private userPostService: UserPostService,
    private messageLogger: MessageLoggerService
  ) { }

  ngOnInit(): void {
    this.getUserPosts();
  }

  getUserPosts(): void {
    this.userPostService.getUserPosts()
      .subscribe(userPosts => {
        this.userPosts = userPosts;
        this.messageLogger.add(UserPostContainerComponent.name, "getUserPosts: user posts fetched")
      });
  }

  addUserPost(userPost: UserPost) {
    this.userPostService.addUserPost(userPost).subscribe(userPost => {
      this.userPosts.push(userPost);
      this.log(`addUserPost: add user post=${userPost.id}`);
    }
    );

  }

  log(message: string): void {
    this.messageLogger.add(UserPostContainerComponent.name, message);
  }
}
