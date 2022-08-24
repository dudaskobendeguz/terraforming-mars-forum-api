import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {UserService} from "../../services/user/user.service";
import {User} from "../../interfaces/user";
import {CommentService} from "../../services/comment/comment.service";
import {MessageLoggerService} from "../../services/message-logger/message-logger.service";
import {FormBuilder} from '@angular/forms';
import {PostComment} from "../../interfaces/post-comment";

@Component({
  selector: 'app-comment-form',
  templateUrl: './comment-form.component.html',
  styleUrls: ['./comment-form.component.css']
})
export class CommentFormComponent implements OnInit {

  user?: User;
  postForm = this.formBuilder.group({description: ''});
  @Output() onAddComment: EventEmitter<PostComment> = new EventEmitter<PostComment>();

  constructor(private userService: UserService,
              private commentService: CommentService,
              private logger: MessageLoggerService,
              private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getLoggedInUser();
  }

  getLoggedInUser(): void {
    this.user = this.userService.getLoggedInUser();
  }

  addComment(): void {
    const description = this.postForm.value.description;
    if (!description) {
      const errorMsg: string = `Cannot create comment`;
      alert(errorMsg);
      console.log(errorMsg);
    } else if (confirm("Post this comment!")) {
      if (this.user) {
        const comment: PostComment = {
          id: 0,
          user: this.user,
          description: description,
          timestamp: new Date()
        };
        this.onAddComment.emit(comment);
      }
      this.postForm.reset();
    }
  }
}
