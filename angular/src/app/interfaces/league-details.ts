import {User} from "./user";
import {PostComment} from "./post-comment";

export interface LeagueDetails {
  id: number,
  leagueId: number,
  leaguePlayers: User[],
  numberOfFinishedRounds: number,
  numberOfInProgressRounds: number,
  comments: PostComment[]
}
