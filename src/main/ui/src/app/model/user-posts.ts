import { Post } from '../model/post';

export class UserPosts {
  public userId!: number;
  public firstName!: string;
  public fullName!: string
  public posts: Array<Post> = []

  constructor() { }
}
