import {UserPost} from "./user-post";
import {LeaguePost} from "./league-post";

export interface Post {
  userPost?: UserPost,
  leaguePost?: LeaguePost,
}
