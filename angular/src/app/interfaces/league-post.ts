import {User} from "./user";
import {LeagueDetails} from "./league-details";

export interface LeaguePost {
  leagueId: number
  timestamp: Date,
  gameType: string,
  name: string,
  leagueAdmin: User,
  numberOfPlayers: number;
  numberOfRounds: number,
  numberOfComments: number
  imageSource: string,
}
