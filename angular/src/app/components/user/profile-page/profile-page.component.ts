import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../../interfaces/user";
import {UserService} from "../../../services/user/user.service";
import {MessageLoggerService} from "../../../services/message-logger/message-logger.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {
  @Input() user?: User;

  constructor(
    private userService: UserService,
    private messageLogger: MessageLoggerService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.getUserById();
  }

  private getUserById(){
    const id = Number(this.route.snapshot.paramMap.get("id"));
    this.userService.getUserById(id)
      .subscribe((user) => {
        this.user = user;
        this.messageLogger.add(ProfilePageComponent.name, 'getUserById: user fetched')
      });
  }

}
