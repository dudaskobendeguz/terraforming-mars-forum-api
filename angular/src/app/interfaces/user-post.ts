import {User} from "./user";
import {PostComment} from "./post-comment";

export interface UserPost {
  id: number,
  timestamp: Date,
  user: User,
  description: string,
  comments: PostComment[]
}
