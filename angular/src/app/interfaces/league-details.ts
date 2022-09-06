import {User} from "./user";
import {PostComment} from "./post-comment";

export interface LeagueDetails {
  postId: number,
  name: string,
  gameType: string,
  timestamp: Date,
  imageSource: string,
  leagueAdmin: User,
  leaguePlayers: User[],
  numberOfRounds: number,
  numberOfFinishedRounds: number,
  numberOfInProgressRounds: number,
  comments: PostComment[]
}
