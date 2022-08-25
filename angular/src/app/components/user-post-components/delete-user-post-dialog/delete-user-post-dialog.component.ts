import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-delete-user-post-dialog',
  templateUrl: './delete-user-post-dialog.component.html',
  styleUrls: ['./delete-user-post-dialog.component.css']
})
export class DeleteUserPostDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<DeleteUserPostDialogComponent>
  ) { }

  ngOnInit(): void {
  }

  closeDialog() {
    this.dialogRef.close();
  }

}
