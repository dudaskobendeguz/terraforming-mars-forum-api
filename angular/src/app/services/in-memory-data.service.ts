import { Injectable } from '@angular/core';
import {InMemoryDbService} from "angular-in-memory-web-api";
import {User} from "../interfaces/user";
import {UserPost} from "../interfaces/user-post";
import {LeaguePost} from "../interfaces/league-post";
import {PostComment} from "../interfaces/post-comment";
import {LeagueDetails} from "../interfaces/league-details";

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

    const leaguePostDetails: LeagueDetails[] = [
      {
        id: 1,
        leagueId: 1,
        leaguePlayers: users,
        numberOfFinishedRounds: 1,
        numberOfInProgressRounds: 0,
        comments: comments,
      },
    ];
    const leaguePosts: LeaguePost[] = [
      {
        id: 1,
        leagueId: 1,
        timestamp: new Date('2022-06-03T07:06:52.715Z'),
        gameType: "Ares Expedition",
        name: "My Test League",
        leagueAdmin: users[0],
        numberOfPlayers: 6,
        numberOfRounds: 2,
        numberOfComments: 8,
        imageSource: "https://bobbyhadz.com/images/blog/typescript-date-format/banner.webp",
        leagueDetails: leaguePostDetails[0],
      },
      {
        id: 2,
        leagueId: 2,
        timestamp: new Date('2017-04-14T07:06:52.715Z'),
        gameType: "Terraforming Mars",
        name: "Test Mars League",
        leagueAdmin:users[1],
        numberOfPlayers: 8,
        numberOfRounds: 4,
        numberOfComments: 5,
        imageSource: "https://raketa.hu/uploads/2022/07/mars_sample_return-768x432.jpg",
        leagueDetails: leaguePostDetails[0],
      }
    ]

    const userPosts: UserPost[] = [
      {
        id: 1,
        timestamp: new Date('2021-06-03T07:06:52.715Z'),
        user: users[0],
        description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        comments: comments,
      },
      {
        id: 2,
        timestamp: new Date('2000-06-03T07:06:52.715Z'),
        user: users[0],
        description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        comments: comments,
      }
    ];
    return {users, userPosts, leaguePosts, comments, leaguePostDetails};
  }
}
