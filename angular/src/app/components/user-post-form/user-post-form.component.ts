import {Component, OnInit, Output, EventEmitter} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {MessageLoggerService} from "../../services/message-logger/message-logger.service";
import {UserPostService} from "../../services/user-post/user-post.service";
import {UserPost} from "../../interfaces/user-post";
import {User} from "../../interfaces/user";
import {UserService} from "../../services/user/user.service";

@Component({
  selector: 'app-user-post-form',
  templateUrl: './user-post-form.component.html',
  styleUrls: ['./user-post-form.component.css']
})
export class UserPostFormComponent implements OnInit {

  private user?: User;
  @Output() onAddUserPost: EventEmitter<UserPost> = new EventEmitter<UserPost>();

  postForm = this.formBuilder.group(
    {
      description: ''
    }
  );

  constructor(
    private userPostService: UserPostService,
    private userService: UserService,
    private formBuilder: FormBuilder,
    private messageLogger: MessageLoggerService
  ) {
  }

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void {
    this.userService.getUsers().subscribe(users => {
      if (users.length) {
        this.user = users[0];
      }
    });
  }

  onSubmit(): void {
    const description = this.postForm.value.description;
    if (!description) {
      const errorMessage: string = "Cannot create post with empty description!";
      this.log(errorMessage);
      alert(errorMessage);
    } else if (confirm("Are you sure you want to create a post?")) {
      this.addPost(description);
      this.postForm.reset();
    }
  }

  addPost(description: string): void {
    // Generates id
    this.userPostService.getUserPosts().subscribe(posts => {
      if (this.user) {
        this.onAddUserPost.emit({
          id: posts.length + 1,
          timestamp: new Date(),
          user: this.user,
          description: description,
          comments: []
        });
      }
    });

  }

  log(message: string): void {
    this.messageLogger.add(UserPostFormComponent.name, message);
  }

}
