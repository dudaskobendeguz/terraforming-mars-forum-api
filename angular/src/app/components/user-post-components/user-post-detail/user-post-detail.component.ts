import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";
import {UserPostService} from "../../../services/user-post/user-post.service";
import {UserPost} from "../../../interfaces/user-post";

@Component({
  selector: 'app-user-post-detail',
  templateUrl: './user-post-detail.component.html',
  styleUrls: ['./user-post-detail.component.css']
})
export class UserPostDetailComponent implements OnInit {

  @Input() userPost?: UserPost;

  constructor(
    private userPostService: UserPostService,
    private route: ActivatedRoute,
    private location: Location
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
}
