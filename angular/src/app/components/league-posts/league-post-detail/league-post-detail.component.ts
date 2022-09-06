import {Component, OnInit} from '@angular/core';
import {MessageLoggerService} from "../../../services/message-logger/message-logger.service";
import {LeaguePostDetailService} from "../../../services/league-post-detail/league-post-detail.service";
import {ActivatedRoute} from "@angular/router";
import {LeagueDetails} from "../../../interfaces/league-details";

@Component({
  selector: 'app-league-post-detail',
  templateUrl: './league-post-detail.component.html',
  styleUrls: ['./league-post-detail.component.css']
})
export class LeaguePostDetailComponent implements OnInit {
  post?: LeagueDetails;
  isLoading: boolean = true;

  constructor(
    private messageService: MessageLoggerService,
    private postDetailService: LeaguePostDetailService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    const postId: number = Number(this.route.snapshot.paramMap.get('id'));
    this.getLeagueDetailsByPostId(postId);
  }

  private getLeagueDetailsByPostId(id: number): void {
    this.postDetailService.getByLeagueId(id).subscribe( (leagueDetails) => {
      this.post = leagueDetails[0];
      this.messageService.add(LeaguePostDetailService.name, `getPostById(${id}) fetched post`);
      this.isLoading = false;
    });
  }

  hasComment(): boolean {
    return (this.post?.comments) ? this.post.comments.length > 0 : false;
  }
}
