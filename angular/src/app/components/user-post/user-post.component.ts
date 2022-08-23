import {Component, Input, OnInit} from '@angular/core';
import {UserPost} from "../../interfaces/user-post";

@Component({
  selector: 'app-user-post',
  templateUrl: './user-post.component.html',
  styleUrls: ['./user-post.component.css']
})
export class UserPostComponent implements OnInit {

  @Input() userPost?: UserPost;

  constructor() { }

  ngOnInit(): void {
  }

}
