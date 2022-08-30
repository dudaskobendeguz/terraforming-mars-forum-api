import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-page-not-found',
  templateUrl: './page-not-found.component.html',
  styleUrls: ['./page-not-found.component.css']
})
export class PageNotFoundComponent implements OnInit {
  header: string = "Are you lost?";
  message: string = "Looks like the page you were looking for does not exist."
  constructor() { }

  ngOnInit(): void {
  }
}
