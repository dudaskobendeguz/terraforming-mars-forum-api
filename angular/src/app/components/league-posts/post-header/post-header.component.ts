import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../../interfaces/user";


/**
 * Generate post header component
 * @param {string} title - the title of the header(will be in titlecase)
 * @param {string} titleLink - OPTIONAL The title can be a link. In this case, titleLink needs ie.: "/user/12"
 * @param {string} subtitle - OPTIONAL the subtitle of the header
 * @param {date} date - will show in subtitle
 * @param {User} user - the owner of the post. the avatar will be a link to the user profile
 *
 */
@Component({
  selector: 'app-post-header',
  templateUrl: './post-header.component.html',
  styleUrls: ['./post-header.component.css']
})
export class PostHeaderComponent implements OnInit {
  @Input() title?: string;
  @Input() titleLink?: string;
  @Input() subtitle?: string;
  @Input() date?: Date;
  @Input() user?: User;

  constructor() { }

  ngOnInit(): void {
  }

}
