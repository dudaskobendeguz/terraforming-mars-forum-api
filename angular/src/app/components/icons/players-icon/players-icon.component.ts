import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-players-icon',
  templateUrl: './players-icon.component.html',
  styleUrls: ['./players-icon.component.css']
})
export class PlayersIconComponent implements OnInit {
  @Input() numberOfPlayers?: number;

  constructor() { }

  ngOnInit(): void {
  }

}
