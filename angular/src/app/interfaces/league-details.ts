import {User} from "./user";

export interface LeagueDetails {
  "id": number,
  "game_type": string,
  "name": string,
  "image_source": string,
  "league_admin": User,
  "league_players": User[],
  "number_of_finished_rounds": number,
  "number_of_in_progress_rounds": number,
  "number_of_rounds": number,
}
