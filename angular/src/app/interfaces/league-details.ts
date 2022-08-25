import {User} from "./user";

export interface LeagueDetails {
  "id": number,
  "gameType": string,
  "name": string,
  "imageSource": string,
  "leagueAdmin": User,
  "leaguePlayers": User[],
  "numberOfFinishedRounds": number,
  "numberOfInProgressRounds": number,
  "numberOfRounds": number,
}
