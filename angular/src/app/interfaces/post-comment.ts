import {User} from "./user";

export interface PostComment {
  id: number,
  user: User,
  description: string,
  timestamp: Date
}
