import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-icons',
  templateUrl: './icons.component.html',
  styleUrls: ['./icons.component.css']
})
export class IconsComponent implements OnInit {
  @Input() numberOfComments?: number;
  @Input() numberOfPlayers?: number;
  @Input() numberOfRounds?: number;

  constructor() { }

  ngOnInit(): void {
  }

}
