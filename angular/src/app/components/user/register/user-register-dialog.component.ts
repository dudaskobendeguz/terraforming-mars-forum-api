import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {User} from "../../../interfaces/user";

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register-dialog.component.html',
  styleUrls: ['./user-register-dialog.component.css']
})
export class UserRegisterDialogComponent implements OnInit {

  emailForMach: string = "";
  passwordForMach: string = "";
  hide: boolean = true;
  constructor(
    public dialogRef: MatDialogRef<UserRegisterDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: User,
  ) { }

  ngOnInit(): void {
  }

  closeDialogPanel() {
    this.dialogRef.close();
  }

}
