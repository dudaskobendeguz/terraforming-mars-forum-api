import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../../interfaces/user";

@Component({
  selector: 'app-post-header',
  templateUrl: './post-header.component.html',
  styleUrls: ['./post-header.component.css']
})
export class PostHeaderComponent implements OnInit {
  @Input() title?: string;
  @Input() subtitle?: string;
  @Input() date?: Date;
  @Input() avatarImageSource?: string;
  @Input() user?: User;
  @Input() titleLink?: string;

  constructor() { }

  ngOnInit(): void {
  }

}
