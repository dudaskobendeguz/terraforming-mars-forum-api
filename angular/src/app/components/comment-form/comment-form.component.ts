import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user/user.service";
import {User} from "../../interfaces/user";
import {CommentService} from "../../services/comment/comment.service";
import {MessageLoggerService} from "../../services/message-logger/message-logger.service";
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-comment-form',
  templateUrl: './comment-form.component.html',
  styleUrls: ['./comment-form.component.css']
})
export class CommentFormComponent implements OnInit {

  user?: User

  checkoutForm = this.formBuilder.group({
    description: ''
  });

  constructor(
    private userService: UserService,
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
    if (this.user){
      this.commentService.addComment((<string>this.checkoutForm.value.description), this.user)
    }
  }

}
