import {LeagueDetails} from "./league-details";
import {PostComment} from "./post-comment";

export interface LeaguePost {
  id: number,
  timestamp: Date,
  description: string,
  imageSource: string,
  leagueDetails: LeagueDetails,
  comments: PostComment[]
}
