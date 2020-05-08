package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.ErrorMessage;
import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.repositories.ErrorMessageRepository;
import com.greenfoxacademy.reddit.repositories.PostRepository;
import com.greenfoxacademy.reddit.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedditServiceImp implements RedditService {
  private UserRepository userRepository;
  private PostRepository postRepository;
  private ErrorMessageRepository errorMessageRepository;
  private User activeUser;

  @Autowired
  RedditServiceImp(UserRepository userRepository, PostRepository postRepository,
                   ErrorMessageRepository errorMessageRepository) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
    this.errorMessageRepository = errorMessageRepository;
  }

  @Override
  public User getUserByName(String userName) {
    return userRepository.getUserByName(userName);
  }

  @Override
  public User getUserById(Long id) {
    return userRepository.getUserById(id);
  }


  @Override
  public void loadUser(User user) {
    this.activeUser = user;
  }

  @Override
  public boolean doesUserExistsWithUserName(String userName) {
    return userRepository.existsByName(userName);
  }

  @Override
  public void createUser(User user) {
    userRepository.save(user);
  }

  @Override
  public User getActiveUser() {
    return activeUser;
  }

  @Override
  public void createPost(Post post) {
    post.setUser(activeUser);
    postRepository.save(post);
    addPostToUserPosts(post);
  }

  @Override
  public void addPostToUserPosts(Post post) {
    List<Post> changedPosts = activeUser.getPosts();
    changedPosts.add(post);
    activeUser.setPosts(changedPosts);
    userRepository.save(activeUser);
  }

  @Override
  public List<Post> getPosts() {
    return postRepository.findAllByOrderByScoreDesc();
  }

  @Override
  public void upvotePost(Long id) {
    postRepository.getPostById(id).incrementScore();
    postRepository.save(postRepository.getPostById(id));
  }

  @Override
  public void downvotePost(Long id) {
    postRepository.getPostById(id).decrementScore();
    postRepository.save(postRepository.getPostById(id));
  }

  @Override
  public void createErrorMessage(String message) {
    errorMessageRepository.save(new ErrorMessage(message));
  }

  @Override
  public ErrorMessage getErrorMessageByContainsUserName(String userName) {
    return errorMessageRepository.getByMessageContains(userName);
  }

}
