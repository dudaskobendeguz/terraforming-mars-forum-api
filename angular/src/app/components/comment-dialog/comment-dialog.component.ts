import {Component, Inject, OnInit} from '@angular/core';
import {PostComment} from "../../interfaces/post-comment";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-comment-dialog',
  templateUrl: './comment-dialog.component.html',
  styleUrls: ['./comment-dialog.component.css']
})
export class CommentDialog implements OnInit {

  constructor(
    private dialogRef: MatDialogRef<CommentDialog>,
    @Inject(MAT_DIALOG_DATA) data: PostComment
  ) {
  }

  ngOnInit(): void {
  }

  closeDialog(): void {
    this.dialogRef.close();
  }
}
