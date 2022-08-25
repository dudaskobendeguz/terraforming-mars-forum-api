import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {User} from "../../../interfaces/user";

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<UserRegisterComponent>,
    @Inject(MAT_DIALOG_DATA) public user: User,
  ) { }

  ngOnInit(): void {
  }

  closeDialogPanel() {
    this.dialogRef.close();
  }

}
