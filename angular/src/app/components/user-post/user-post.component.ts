import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserPost} from "../../interfaces/user-post";

@Component({
  selector: 'app-user-post',
  templateUrl: './user-post.component.html',
  styleUrls: ['./user-post.component.css']
})
export class UserPostComponent implements OnInit {

  @Input() public userPost?: UserPost;
  @Output() onDeleteUserPost: EventEmitter<UserPost> = new EventEmitter<UserPost>();

  constructor() { }

  ngOnInit(): void {
  }

  deleteUserPost(): void {
    this.onDeleteUserPost.emit(this.userPost);
  }
}
