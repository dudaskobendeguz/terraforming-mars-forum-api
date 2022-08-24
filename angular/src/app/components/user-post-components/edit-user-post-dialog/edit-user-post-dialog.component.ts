import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-edit-user-post-dialog',
  templateUrl: './edit-user-post-dialog.component.html',
  styleUrls: ['./edit-user-post-dialog.component.css']
})
export class EditUserPostDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<EditUserPostDialogComponent>
  ) {
  }

  ngOnInit(): void {
  }

  closeDialog() {
    this.dialogRef.close();
  }
}
