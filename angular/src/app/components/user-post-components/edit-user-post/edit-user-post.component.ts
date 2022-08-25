import {Component, Input, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {EditUserPostDialogComponent} from "../edit-user-post-dialog/edit-user-post-dialog.component";
import {UserPost} from "../../../interfaces/user-post";

@Component({
  selector: 'app-edit-user-post',
  templateUrl: './edit-user-post.component.html',
  styleUrls: ['./edit-user-post.component.css']
})
export class EditUserPostComponent implements OnInit {

  @Input() userPost?: UserPost;

  constructor(
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(EditUserPostDialogComponent);
  }

}
