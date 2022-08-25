import {Component, OnInit} from '@angular/core';
import {LeagueDetails} from "../../../interfaces/league-details";
import {MessageLoggerService} from "../../../services/message-logger/message-logger.service";
import {LeaguePostDetailService} from "../../../services/league-post-detail/league-post-detail.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-league-pots-detail',
  templateUrl: './league-pots-detail.component.html',
  styleUrls: ['./league-pots-detail.component.css']
})
export class LeaguePotsDetailComponent implements OnInit {
  postDetails?: LeagueDetails;

  constructor(
    private messageService: MessageLoggerService,
    private postDetailService: LeaguePostDetailService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.getPostDetailById();
  }

  private getPostDetailById() {
    const id: number = Number(this.route.snapshot.paramMap.get('id'));
    this.postDetailService.getByLeagueId(id).subscribe( (postDetails) => {
      this.postDetails = postDetails;
      this.messageService.add(LeaguePostDetailService.name, `getPostDetailsById(${id}) fetched post details`);
    });
  }
}
