package com.greenfoxacademy.reddit.repositories;

import com.greenfoxacademy.reddit.models.Post;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
  List<Post> getPostsByScoreAfterOrderByScoreDesc(int number);
  Post getPostById(Long id);
}
