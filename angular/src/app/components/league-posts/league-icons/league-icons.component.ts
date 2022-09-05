import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-league-icons',
  templateUrl: './league-icons.component.html',
  styleUrls: ['./league-icons.component.css']
})
export class LeagueIconsComponent implements OnInit {
  @Input() numberOfComments?: number;
  @Input() numberOfPlayers?: number;
  @Input() numberOfRounds?: number;

  constructor() { }

  ngOnInit(): void {
  }

}
