import {Component, Input, OnInit} from '@angular/core';
import {PostComment} from "../../interfaces/post-comment";

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  @Input() comment?: PostComment

  constructor() { }

  ngOnInit(): void {
  }
}
