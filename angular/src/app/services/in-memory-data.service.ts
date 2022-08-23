import { Injectable } from '@angular/core';
import {InMemoryDbService} from "angular-in-memory-web-api";
import {User} from "../interfaces/user";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService{

  constructor() { }

  createDb() {
    const users: User[] = [
      {
        id: 1,
        email: "bende@gmail.com",
        firstName: "Hello",
        lastName: "user",
        imageSource: "img",
        username: "bende",
        password: "1234"
      }
    ]
    return {users};
  }
}
