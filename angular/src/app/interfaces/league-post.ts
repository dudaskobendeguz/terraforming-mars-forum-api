import {PostComment} from "./post-comment";
import {User} from "./user";

export interface LeaguePost {
  id: number,
  leagueId: number,
  timestamp: Date,
  "gameType": string,
  "name": string,
  "leagueAdmin": User,
  "numberOfRounds": number,
  "imageSource": string,
  comments: PostComment[]
}
