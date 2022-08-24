import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {UserPost} from "../../../interfaces/user-post";

@Component({
  selector: 'app-edit-user-post-dialog',
  templateUrl: './edit-user-post-dialog.component.html',
  styleUrls: ['./edit-user-post-dialog.component.css']
})
export class EditUserPostDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<EditUserPostDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: UserPost
  ) {
  }

  ngOnInit(): void {
  }

  closeDialog() {
    this.dialogRef.close();
  }
}
