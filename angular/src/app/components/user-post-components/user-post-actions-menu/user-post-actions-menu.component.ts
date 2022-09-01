import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {UserPost} from "../../../interfaces/user-post";

@Component({
  selector: 'app-user-post-actions-menu',
  templateUrl: './user-post-actions-menu.component.html',
  styleUrls: ['./user-post-actions-menu.component.css']
})
export class UserPostActionsMenuComponent implements OnInit {

  @Output() onEdit: EventEmitter<void> = new EventEmitter();
  @Output() onDelete: EventEmitter<void> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

}
