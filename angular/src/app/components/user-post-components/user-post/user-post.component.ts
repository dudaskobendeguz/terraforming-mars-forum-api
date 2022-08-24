import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserPost} from "../../../interfaces/user-post";
import {MatDialog} from "@angular/material/dialog";
import {EditUserPostDialogComponent} from "../edit-user-post-dialog/edit-user-post-dialog.component";

@Component({
  selector: 'app-user-post',
  templateUrl: './user-post.component.html',
  styleUrls: ['./user-post.component.css']
})
export class UserPostComponent implements OnInit {

  @Input() public userPost?: UserPost;
  @Output() onDeleteUserPost: EventEmitter<UserPost> = new EventEmitter<UserPost>();
  @Output() onUpdateUserPost: EventEmitter<UserPost> = new EventEmitter<UserPost>();

  constructor(
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
  }

  deleteUserPost(): void {
    this.onDeleteUserPost.emit(this.userPost);
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(EditUserPostDialogComponent, {
      data: {
        description: this.userPost?.description
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (this.userPost && result) {
        this.userPost.description = result;
        this.onUpdateUserPost.emit(this.userPost);
      }
    })
  }
}
