package com.socialmedia.project.repo;

import com.socialmedia.project.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByAuthor(String username);
}