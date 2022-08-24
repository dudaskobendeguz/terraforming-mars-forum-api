import {Component, Input, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {EditUserPostDialogComponent} from "../edit-user-post-dialog/edit-user-post-dialog.component";
import {UserPost} from "../../../interfaces/user-post";
import {UserPostService} from "../../../services/user-post/user-post.service";

@Component({
  selector: 'app-edit-user-post',
  templateUrl: './edit-user-post.component.html',
  styleUrls: ['./edit-user-post.component.css']
})
export class EditUserPostComponent implements OnInit {

  @Input() userPost?: UserPost;

  constructor(
    public dialog: MatDialog,
    private userPostService: UserPostService
  ) { }

  ngOnInit(): void {
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(EditUserPostDialogComponent, {
      data: {
        description: this.userPost?.description
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (this.userPost && result) {
        this.userPost.description = result;
        this.userPostService.updateUserPost(this.userPost).subscribe();
      }
    })
  }

}
