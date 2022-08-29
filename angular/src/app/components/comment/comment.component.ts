import {Component, Input, OnInit} from '@angular/core';
import {PostComment} from "../../interfaces/post-comment";

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  @Input() comment?: PostComment
  date?: string

  constructor() { }

  ngOnInit(): void {
    if (this.comment) {
      const date = new Date(this.comment.timestamp);
      this.date = `${date.getFullYear()}-${date.getMonth()}-${date.getDate()} ${date.getHours()}:${date.getUTCMinutes()}`
    }
  }
}
