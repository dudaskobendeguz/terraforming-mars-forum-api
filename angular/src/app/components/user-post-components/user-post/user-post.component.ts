import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserPost} from "../../../interfaces/user-post";
import {MatDialog} from "@angular/material/dialog";
import {DeleteUserPostDialogComponent} from "../delete-user-post-dialog/delete-user-post-dialog.component";
import {TextareaDialogComponent} from "../../dialog-components/textarea-dialog/textarea-dialog.component";

@Component({
  selector: 'app-user-post',
  templateUrl: './user-post.component.html',
  styleUrls: ['./user-post.component.css']
})
export class UserPostComponent implements OnInit {

  @Input() public userPost?: UserPost;
  @Input() public isPreview?: boolean;
  @Output() onDeleteUserPost: EventEmitter<UserPost> = new EventEmitter<UserPost>();
  @Output() onUpdateUserPost: EventEmitter<UserPost> = new EventEmitter<UserPost>();

  constructor(
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
  }

  openEditDialog(): void {
    const editDialog = this.dialog.open(TextareaDialogComponent, {
      width: "50em",
      data: {
        title: "Edit Post",
        text: this.userPost?.description
      }
    });

    editDialog.afterClosed().subscribe(result => {
      if (this.userPost && result) {
        this.userPost.description = result;
        this.onUpdateUserPost.emit(this.userPost);
      }
    })
  }

  openDeleteDialog(): void {
    const deleteDialog = this.dialog.open(DeleteUserPostDialogComponent);

    deleteDialog.afterClosed().subscribe(result => {
      if (result) {
        this.onDeleteUserPost.emit(this.userPost);
      }
    })
  }
}
