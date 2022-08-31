import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-date-ago',
  templateUrl: './date-ago.component.html',
  styleUrls: ['./date-ago.component.css']
})
export class DateAgoComponent implements OnInit {
  @Input() date?: Date;

  constructor() { }

  ngOnInit(): void {
  }

}
