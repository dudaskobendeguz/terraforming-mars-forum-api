import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserPost} from "../../../interfaces/user-post";
import {MatDialog} from "@angular/material/dialog";
import {EditUserPostDialogComponent} from "../edit-user-post-dialog/edit-user-post-dialog.component";
import {DeleteUserPostDialogComponent} from "../delete-user-post-dialog/delete-user-post-dialog.component";

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
    const editDialog = this.dialog.open(EditUserPostDialogComponent, {
      width: "60vw",
      data: {
        description: this.userPost?.description
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
