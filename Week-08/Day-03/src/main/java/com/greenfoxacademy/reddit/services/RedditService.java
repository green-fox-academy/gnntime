package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface RedditService {
  void loadUser(User user);
  User getUserByName(String userName);
  void createUser(User user);
  User getActiveUser();
  void createPost(Post post);
  List<Post> getPostsByScoreAfterOrderByScoreDesc(int number);
  void addPostToUserPosts(Post post);
  void upvotePost(Long id);
  void downvotePost(Long id);
}
