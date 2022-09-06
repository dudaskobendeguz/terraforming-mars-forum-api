import {User} from "./user";

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
