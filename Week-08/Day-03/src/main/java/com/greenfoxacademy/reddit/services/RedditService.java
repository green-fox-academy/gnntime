package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.ErrorMessage;
import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface RedditService {
  void loadUser(User user);
  boolean doesUserExistsWithUserName(String userName);
  User getUserByName(String userName);
  User getUserById(Long id);
  void createUser(User user);
  User getActiveUser();
  void createPost(Post post);
  List<Post> getPosts();
  void addPostToUserPosts(Post post);
  void upvotePost(Long id);
  void downvotePost(Long id);
  void createErrorMessage(String message);
  ErrorMessage getErrorMessageByContainsUserName(String username);
}
