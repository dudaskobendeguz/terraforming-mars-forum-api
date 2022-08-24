import { Injectable } from '@angular/core';
import {InMemoryDbService} from "angular-in-memory-web-api";
import {User} from "../interfaces/user";
import {UserPost} from "../interfaces/user-post";
import {LeaguePost} from "../interfaces/league-post";
import {PostComment} from "../interfaces/post-comment";

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
        imageSource: "https://xsgames.co/randomusers/assets/images/favicon.png",
        username: "bende",
        password: "1234"
      },
      {
        id: 2,
        email: "test2@gmail.com",
        firstName: "Test",
        lastName: "user2",
        imageSource: "https://cdn1.iconfinder.com/data/icons/linkedin-ui-glyph/48/Sed-04-512.png",
        username: "TestedUserName 2",
        password: "1234"
      },
    ];

    const userPosts: UserPost[] = [
      {
        id: 1,
        timestamp: new Date(),
        user: users[0],
        description: "This is the first test post of Hello user",
        comments: [],
      },
      {
        id: 2,
        timestamp: new Date(),
        user: users[0],
        description: "This is the second test post of Hello user",
        comments: [],
      }
    ];
    const comments: PostComment[] = [
      {
        id: 1,
        user: users[0],
        description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut" +
          "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut" +
          "aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum" +
          "dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia" +
          "deserunt mollit anim id est laborum.",
        timestamp: new Date()
      }
    ]
    const leaguePosts: LeaguePost[] = [
      {
        id: 1,
        timestamp: new Date(),
        description: "Im a league post description",
        imageSource: "https://bobbyhadz.com/images/blog/typescript-date-format/banner.webp",
        leagueDetails: {id: 1},
        comments: comments
      },
      {
        id: 2,
        timestamp: new Date(),
        description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
          "molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum\n" +
          "numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium\n" +
          "optio, eaque rerum! Provident similique accusantium nemo autem. Veritatis\n" +
          "obcaecati tenetur iure eius earum ut molestias architecto voluptate aliquam\n" +
          "nihil, eveniet aliquid culpa officia aut! Impedit sit sunt quaerat, odit,\n" +
          "tenetur error, harum nesciunt ipsum debitis quas aliquid. Reprehenderit,\n" +
          "quia. Quo neque error repudiandae fuga? Ipsa laudantium molestias eos \n" +
          "sapiente officiis modi at sunt excepturi expedita sint? Sed quibusdam\n" +
          "recusandae alias error harum maxime adipisci amet laborum. Perspiciatis \n" +
          "minima nesciunt dolorem! Officiis iure rerum voluptates a cumque velit ",
        imageSource: "https://raketa.hu/uploads/2022/07/mars_sample_return-768x432.jpg",
        leagueDetails: {id: 2},
        comments: comments
      }
    ]
    return {users, userPosts, leaguePosts, comments};
  }
}
