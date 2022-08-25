import {User} from "./user";

export interface LeagueDetails {
  "id": number,
  "game_type": string,
  "name": string,
  "image_source": string,
  "league_admin": User,
  "league_players": User[],
  "numberOfFinishedRounds": number,
  "numberOfInProgressRounds": number,
  "numberOfRounds": number,
}
