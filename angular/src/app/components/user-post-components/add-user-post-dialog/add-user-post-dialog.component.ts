import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {UserPost} from "../../../interfaces/user-post";

@Component({
  selector: 'app-add-user-post-dialog',
  templateUrl: './add-user-post-dialog.component.html',
  styleUrls: ['./add-user-post-dialog.component.css']
})
export class AddUserPostDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<AddUserPostDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: UserPost
  ) {
  }

  ngOnInit(): void {
  }

  closeDialog() {
    this.dialogRef.close();
  }

}
