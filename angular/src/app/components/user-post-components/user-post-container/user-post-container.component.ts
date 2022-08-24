import {Component, OnInit} from '@angular/core';
import {UserPost} from "../../../interfaces/user-post";
import {UserPostService} from "../../../services/user-post/user-post.service";
import {MessageLoggerService} from "../../../services/message-logger/message-logger.service";

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
  ) {
  }

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
    this.userPostService.addUserPost(userPost).subscribe(post => {
        this.userPosts.push(post);
        this.log(`addUserPost: add user post=${post.id}`);
      }
    );

  }

  log(message: string): void {
    this.messageLogger.add(UserPostContainerComponent.name, message);
  }

  deleteUserPost(userPost: UserPost) {
    this.userPosts = this.userPosts.filter(post => post !== userPost);
    this.userPostService.deleteUserPost(userPost).subscribe();
    this.log(`deleteUserPost: delete user post=${userPost.id}`);

  }

  updateUserPost(userPost: UserPost) {
    this.userPostService.updateUserPost(userPost).subscribe();
    this.log(`updateUserPost: update user post=${userPost.id}`);
  }
}
