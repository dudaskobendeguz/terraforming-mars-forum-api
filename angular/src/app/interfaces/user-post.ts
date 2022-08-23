import {User} from "./user";

export interface UserPost {
  id: number,
  timestamp: Date,
  user: User,
  description: string,
  comments: Comment[]
}
