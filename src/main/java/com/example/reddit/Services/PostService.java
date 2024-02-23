package com.example.reddit.Services;

import com.example.reddit.Models.Post;
import java.util.List;

public interface PostService {
  List<Post> listPosts();

  void addVote(long id);

  void addPost(String title, String url);

  void subVote(long id);
}
