import { Component, OnInit } from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {MessageLoggerService} from "../../services/message-logger/message-logger.service";

@Component({
  selector: 'app-user-post-form',
  templateUrl: './user-post-form.component.html',
  styleUrls: ['./user-post-form.component.css']
})
export class UserPostFormComponent implements OnInit {

  postForm = this.formBuilder.group(
    {
      description: ''
    }
  );

  constructor(
    private formBuilder: FormBuilder,
    private messageLogger: MessageLoggerService
  ) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.messageLogger.add(UserPostFormComponent.name,
      `Submitted form with description: ${this.postForm.value.description}`);
    this.postForm.reset();
  }

}
