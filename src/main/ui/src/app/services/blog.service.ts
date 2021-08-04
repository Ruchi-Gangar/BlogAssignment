import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { UserPosts } from '../model/user-posts';
import { PostComments } from '../model/post-comments';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  private userAndPost_URL = '/server/admin/usersAndPosts';
  private comments_URL = '/server/admin/Comments/Post';

  constructor(private http: HttpClient) { }

  getUserAndPosts(): Observable<UserPosts[]> {
    return this.http.get<UserPosts[]>(this.userAndPost_URL)
      .pipe()
      ;
  }

  getCommentsForPost(id: number): Observable<PostComments[]> {
    const url = `${this.comments_URL}/${id}`;
    return this.http.get<PostComments[]>(url)
      .pipe()
      ;
  }
}
