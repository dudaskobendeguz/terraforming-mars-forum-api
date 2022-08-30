import {Component, Input, OnInit} from '@angular/core';
import {Location} from "@angular/common";

@Component({
  selector: 'app-error-detail',
  templateUrl: './error-detail.component.html',
  styleUrls: ['./error-detail.component.css']
})
export class ErrorDetailComponent implements OnInit {
  @Input() header?: string;
  @Input() message?: string;

  constructor(private location: Location) { }

  ngOnInit(): void {
  }

  goBack() {
    this.location.historyGo(-2);
  }

}
