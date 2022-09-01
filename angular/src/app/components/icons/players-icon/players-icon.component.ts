import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-players-icon',
  templateUrl: './players-icon.component.html',
  styleUrls: ['./players-icon.component.css']
})
export class PlayersIconComponent implements OnInit {
  @Input() numberOfPlayers?: number;
  iconType: string = "supervisor_account";
  tooltip: string = "Players";

  constructor() { }

  ngOnInit(): void {
  }

}
