import { Component, OnInit } from '@angular/core';
import { BlogService } from '../../services/blog.service';
import { UserPosts } from '../../model/user-posts';
import { PostComments } from '../../model/post-comments';
import { LoadingService } from '../../services/loading.service';
import { Post } from '../../model/post';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})

export class AdminComponent implements OnInit {
  userPosts!: UserPosts[];
  postComments!: PostComments[];
  currUserPosts!: Post[];

  loading$ = this.loader.loading$;
  selectedUser = 0;
  currentPostId = 0;
  maxPosts = 3;
  isUserSelected = false;
  allCommentsLoaded = false;
  allPostsLoaded = false;
  selectedUserFullName = '';
  constructor(private blogService: BlogService, public loader: LoadingService) {
  }

  ngOnInit(): void {
    this.getUserAndPosts();
  }

  loadUserDetails(selectedUserId: number): void {
    this.selectedUser = selectedUserId;
    this.maxPosts = 3;
    this.isUserSelected = true;
    this.allPostsLoaded = false;
    var temp = this.userPosts?.find(x => x.userId == selectedUserId)?.fullName;
    this.selectedUserFullName = temp !== undefined ? temp : '';
    this.currUserPosts = this.userPosts?.find(x => x.userId == selectedUserId)?.posts ?? [];
  }

  loadAllComments(loadAll: boolean, event: any): void {
    this.maxPosts = this.currUserPosts.length;
    this.allPostsLoaded = true;
  }

  getUserAndPosts(): void {
    this.blogService.getUserAndPosts().subscribe(
      (data: UserPosts[]) => { this.userPosts = data },
      err => console.error(err),
      () => console.log('Blog info retrived')
    )
  }

  getPostComments(postId: number): void {
    if (this.allCommentsLoaded && postId == this.currentPostId) {
      this.postComments = [];
      this.allCommentsLoaded = false;
    }
    else {
      this.blogService.getCommentsForPost(postId).subscribe(
        (data: PostComments[]) => { this.postComments = data; this.allCommentsLoaded = true; this.currentPostId = postId; },
        err => console.error(err),
        () => console.log('Blog info retrived')
      )
    }

  }
}
