import {Component, Input, OnInit} from '@angular/core';
import {LeaguePost} from "../../../interfaces/league-post";

@Component({
  selector: 'app-league-post',
  templateUrl: './league-post.component.html',
  styleUrls: ['./league-post.component.css']
})
export class LeaguePostComponent implements OnInit {
  @Input() post?: LeaguePost;
  link: string = '';

  constructor() { }

  ngOnInit(): void {
    this.link = `/league-post/${this.post!.leagueId}`;
  }

}
