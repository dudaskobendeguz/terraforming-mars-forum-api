import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {User} from "../../../interfaces/user";
import {FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.css']
})
export class LoginDialogComponent implements OnInit {
  hide: boolean = true;
  email: any = new FormControl('', [Validators.required, Validators.email]);

  constructor(
    public dialogRef: MatDialogRef<LoginDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: User,
  ) { }

  ngOnInit(): void {
  }

  getErrorMessage(): string {
    if (this.email.hasError('required')){
      return 'You must enter your email'
    }

    return this.email.hasError('email') ? 'Not valid email' : '';
  }

  closeDialogPanel() {
    this.dialogRef.close();
  }

}
