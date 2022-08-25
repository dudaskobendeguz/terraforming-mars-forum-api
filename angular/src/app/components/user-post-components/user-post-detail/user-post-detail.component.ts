import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";
import {UserPostService} from "../../../services/user-post/user-post.service";
import {UserPost} from "../../../interfaces/user-post";
import {MatDialog} from "@angular/material/dialog";
import {CommentDialog} from "../../comment-dialog/comment-dialog.component";
import {CommentService} from "../../../services/comment/comment.service";
import {PostComment} from "../../../interfaces/post-comment";

@Component({
  selector: 'app-user-post-detail',
  templateUrl: './user-post-detail.component.html',
  styleUrls: ['./user-post-detail.component.css']
})
export class UserPostDetailComponent implements OnInit {

  @Input() userPost?: UserPost;

  constructor(
    private userPostService: UserPostService,
    private commentService: CommentService,
    private route: ActivatedRoute,
    private location: Location,
    private dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.getUserPost();
  }

  private getUserPost() {
    const id = Number(this.route.snapshot.paramMap.get("id"));
    this.userPostService.getUserPost(id).subscribe(
      userPost => this.userPost = userPost
    );
  }

  goBack(): void {
    this.location.back();
  }

  deleteUserPost(userPost: UserPost) {
    this.userPostService.deleteUserPost(userPost).subscribe();
    this.goBack();
  }

  updateUserPost(userPost: UserPost) {
    this.userPostService.updateUserPost(userPost).subscribe();
  }

  openAddCommentDialog() {
    const addCommentDialog = this.dialog.open(CommentDialog, {
      width: "60vw",
      data: {
        description: ""
      }
    });

    addCommentDialog.afterClosed().subscribe(result => {
      let user = this.userPost?.user;
      if (this.userPost && user && result) {
        const comment: PostComment = this.commentService.createComment(user, result);
        this.userPost?.comments.push(comment);
        this.updateUserPost(this.userPost);
      }
    });
  }
}
