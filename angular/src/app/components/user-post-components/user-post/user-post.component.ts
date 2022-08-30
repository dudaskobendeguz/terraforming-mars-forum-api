import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserPost} from "../../../interfaces/user-post";
import {MatDialog} from "@angular/material/dialog";
import {DeleteDialogComponent} from "../../dialog-components/delete-dialog/delete-dialog.component";
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
    const deleteDialog = this.dialog.open(DeleteDialogComponent, {
      data: {
        title: "Delete Post",
        text: "Are you sure you want to delete this post?"
      }
    });

    deleteDialog.afterClosed().subscribe(result => {
      if (result) {
        this.onDeleteUserPost.emit(this.userPost);
      }
    })
  }
}
