import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../../interfaces/user";
import {UserService} from "../../../services/user/user.service";

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {
  @Input() user?: User;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUserById('1')
      .subscribe((user) => {
        this.user = user;
      });
  }

}
