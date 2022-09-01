import {Component, OnInit} from '@angular/core';
import {MessageLoggerService} from "../../../services/message-logger/message-logger.service";
import {LeaguePostDetailService} from "../../../services/league-post-detail/league-post-detail.service";
import {ActivatedRoute} from "@angular/router";
import {LeaguePost} from "../../../interfaces/league-post";
import {LeaguePostService} from "../../../services/league-post/league-post.service";

@Component({
  selector: 'app-league-post-detail',
  templateUrl: './league-post-detail.component.html',
  styleUrls: ['./league-post-detail.component.css']
})
export class LeaguePostDetailComponent implements OnInit {
  isLoadingPostDetails: boolean = true;
  leaguePost?: LeaguePost;
  isLoadingLeaguePost: boolean = true;

  constructor(
    private messageService: MessageLoggerService,
    private postDetailService: LeaguePostDetailService,
    private leaguePostService: LeaguePostService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    const id: number = Number(this.route.snapshot.paramMap.get('id'));
    this.getPostByiD(id);
  }

  private getPostByiD(id: number): void {
    this.leaguePostService.getLeaguePostById(id).subscribe( (leaguePost) => {
      this.leaguePost = leaguePost;
      this.messageService.add(LeaguePostDetailService.name, `getPostById(${id}) fetched post`);
      this.isLoadingLeaguePost = false;
    });
  }

  hasComment(): boolean {
    return this.leaguePost?.leagueDetails?.comments ? this.leaguePost.leagueDetails.comments.length> 0 : false;
  }
}
