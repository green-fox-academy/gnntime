package com.greenfoxacademy.reddit.controllers;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.services.RedditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  private RedditService redditService;

  @Autowired
  public MainController(RedditService redditService) {
    this.redditService = redditService;
  }

  @GetMapping("/")
  public String getLogin() {
    return "login";
  }

  @PostMapping("/")
  public String postLogin(@RequestParam("username") String userName) {
    redditService.loadUser(redditService.getUserByName(userName));
    return "redirect:/main";
  }

  @GetMapping("/createuser")
  public String getCreateUser(Model model) {
    model.addAttribute("user", new User());
    return "createuser";
  }

  @PostMapping("/createuser")
  public String postCreateUser(@ModelAttribute User user) {
    redditService.createUser(user);
    redditService.loadUser(redditService.getUserByName(user.getName()));
    return "redirect:/main";
  }

  @GetMapping("/main")
  public String getMain(Model model) {
    model.addAttribute("user", redditService.getActiveUser());
    model.addAttribute("posts", redditService.getPostsByScoreAfterOrderByScoreDesc(0));
    return "main";
  }

  @GetMapping("/createpost")
  public String getCreatePost(Model model) {
    model.addAttribute("post", new Post());
    return "createpost";
  }

  @PostMapping("/createpost")
  public String postCreatePost(@ModelAttribute Post post) {
    redditService.createPost(post);
    return "redirect:/main";
  }

  @GetMapping("/main/{id}/plus")
  public String getMainPlus(@PathVariable(value = "id") Long id,
                            Model model) {
    redditService.upvotePost(id);
    return "redirect:/main";
  }

  @GetMapping("/main/{id}/minus")
  public String getMainMinus(@PathVariable(value = "id") Long id,
                             Model model) {
    redditService.downvotePost(id);
    return "redirect:/main";
  }
}
