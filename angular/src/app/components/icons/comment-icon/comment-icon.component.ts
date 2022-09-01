import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-comment-icon',
  templateUrl: './comment-icon.component.html',
  styleUrls: ['./comment-icon.component.css']
})
export class CommentIconComponent implements OnInit {
  @Input() numberOfComments?: number;

  constructor() { }

  ngOnInit(): void {
  }

}
