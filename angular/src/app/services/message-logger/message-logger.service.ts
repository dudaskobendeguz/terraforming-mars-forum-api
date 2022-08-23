import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageLoggerService {
  messages: String[] = [];

  constructor() { }

  add(className: String, message: string): void {
    this.messages.push(`__[${className}]__: ${message}`);
  }

  clear(): void {
    this.messages = [];
  }
}
