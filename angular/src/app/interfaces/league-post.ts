import {LeagueDetails} from "./league-details";

export interface LeaguePost {
  id: number,
  timestamp: Date,
  description: string,
  imageSource: string,
  leagueDetails: LeagueDetails,
  comments: Comment[]
}
