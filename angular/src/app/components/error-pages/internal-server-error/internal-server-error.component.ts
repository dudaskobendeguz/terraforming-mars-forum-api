import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-internal-server-error',
  templateUrl: './internal-server-error.component.html',
  styleUrls: ['./internal-server-error.component.css']
})
export class InternalServerErrorComponent implements OnInit {
  header: string = "Server Error.";
  message: string = "Oops, something went wrong.\n Try to refresh this page or feel free to contact us if problem persist...";
  status: number = 500;

  constructor() { }

  ngOnInit(): void {
  }

}
