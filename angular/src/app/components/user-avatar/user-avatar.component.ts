import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../interfaces/user";

@Component({
  selector: 'app-user-avatar',
  templateUrl: './user-avatar.component.html',
  styleUrls: ['./user-avatar.component.css']
})
export class UserAvatarComponent implements OnInit {
  @Input() user?: User;

  constructor() { }

  ngOnInit(): void {
  }

}
