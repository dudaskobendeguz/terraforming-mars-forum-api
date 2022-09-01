import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-comment-icon',
  templateUrl: './comment-icon.component.html',
  styleUrls: ['./comment-icon.component.css']
})
export class CommentIconComponent implements OnInit {
  @Input() numberOfComments?: number;
  iconType: string = "question_answer";
  tooltip: string = "Comments";


  constructor() { }

  ngOnInit(): void {
  }

}
