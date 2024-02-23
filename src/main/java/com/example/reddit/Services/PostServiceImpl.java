package com.example.reddit.Services;

import com.example.reddit.Models.Post;
import com.example.reddit.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  @Autowired
  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public List<Post> listPosts() {
    List<Post> postList = postRepository.findAll();
    return postList;
  }

  @Override
  public void addPost(String title, String url) {
    postRepository.save(new Post(title, url));
  }

  @Override
  public void subVote(long id) {
    Optional<Post> post = postRepository.findById(id);
    if (post.isPresent()) {
      post.get().setVotes(post.get().getVotes() - 1);
      postRepository.save(post.get());
    }
  }

  @Override
  public void addVote(long id) {
    Optional<Post> post = postRepository.findById(id);
    if (post.isPresent()) {
      post.get().setVotes(post.get().getVotes() + 1);
      postRepository.save(post.get());
    }
  }
}
