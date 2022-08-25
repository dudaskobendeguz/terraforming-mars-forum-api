import {Component, OnInit} from '@angular/core';
import {LeagueDetails} from "../../../interfaces/league-details";
import {MessageLoggerService} from "../../../services/message-logger/message-logger.service";
import {LeaguePostDetailService} from "../../../services/league-post-detail/league-post-detail.service";
import {ActivatedRoute} from "@angular/router";
import {LeaguePost} from "../../../interfaces/league-post";
import {LeaguePostService} from "../../../services/league-post/league-post.service";

@Component({
  selector: 'app-league-pots-detail',
  templateUrl: './league-pots-detail.component.html',
  styleUrls: ['./league-pots-detail.component.css']
})
export class LeaguePotsDetailComponent implements OnInit {
  postDetails?: LeagueDetails;
  leaguePost?: LeaguePost;

  constructor(
    private messageService: MessageLoggerService,
    private postDetailService: LeaguePostDetailService,
    private leaguePostService: LeaguePostService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    const id: number = Number(this.route.snapshot.paramMap.get('id'));
    this.getPostByiD(id);
    this.getPostDetailById(id);
  }

  private getPostDetailById(id: number): void {
    this.postDetailService.getByLeagueId(id).subscribe( (leagueDetails) => {
      this.postDetails = leagueDetails;
      this.messageService.add(LeaguePostDetailService.name, `getPostDetailsById(${id}) fetched post details`);
    });
  }

  private getPostByiD(id: number): void {
    this.leaguePostService.getLeaguePostById(id).subscribe( (leaguePost) => {
      this.leaguePost = leaguePost;
      this.messageService.add(LeaguePostDetailService.name, `getPostById(${id}) fetched post`);
    });
  }

  hasComment(): boolean {
    return this.leaguePost?.comments ? this.leaguePost.comments.length> 0 : false;
  }
}
