import { Component, OnInit } from '@angular/core';
import {MessageLoggerService} from "../../services/message-logger/message-logger.service";

@Component({
  selector: 'app-message-logger',
  templateUrl: './message-logger.component.html',
  styleUrls: ['./message-logger.component.css']
})
export class MessageLoggerComponent implements OnInit {

  constructor(public messageLoggerService: MessageLoggerService) { }

  ngOnInit(): void {
  }

}
