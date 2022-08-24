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
    const description = this.postForm.value.description;
    if (!description) {
      const errorMessage: string = "Cannot create post with empty description!";
      this.log(errorMessage);
      alert(errorMessage);
    } else if (confirm("Are you sure you want to create a post?")) {
      this.addPost(description);
      this.postForm.reset();
    }
  }

  addPost(description: string): void {
    this.log(`Added post: ${description}`);
  }

  log(message: string): void {
    this.messageLogger.add(UserPostFormComponent.name, message);
  }

}
