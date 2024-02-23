package com.example.reddit.Controllers;

import com.example.reddit.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostsControllers {

  private final PostService postService;

  @Autowired
  public PostsControllers(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/")
  public String start(Model model) {
    model.addAttribute("posts", postService.listPosts());
    return "index";
  }

  @GetMapping("/submit")
  public String submit() {
    return "submit";
  }

  @PostMapping("/submit/done")
  public String addPost(String title, String url) {
    postService.addPost(title, url);
    return "redirect:/";
  }

  @GetMapping("/add/{id}")
  public String add(@PathVariable long id) {
    postService.addVote(id);
    return "redirect:/";
  }

  @GetMapping("/sub/{id}")
  public String sub(@PathVariable long id) {
    postService.subVote(id);
    return "redirect:/";
  }
}
