package com.socialmedia.project.service;

import com.socialmedia.project.dto.PostDto;
import com.socialmedia.project.handler.ForbiddenException;
import com.socialmedia.project.handler.PostNotFoundException;
import com.socialmedia.project.model.Post;
import com.socialmedia.project.model.User;
import com.socialmedia.project.repo.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(PostDto postDto, User user) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setText(postDto.getText());
        post.setAuthor(user);
        return postRepository.save(post);
    }

    public Post save(PostDto postDto, Post post) {
        post.setTitle(postDto.getTitle());
        post.setText(postDto.getText());
        return postRepository.save(post);
    }

    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Integer id) {
        return postRepository.findById(id)
                .orElseThrow(PostNotFoundException::new);
    }

    public void deleteById(Integer id) {
        postRepository.deleteById(id);
    }

    public void checkAuthor(Integer id, User user) {
        Post post = findById(id);
        if (post.getAuthor().getId() != user.getId()) {
            throw new ForbiddenException();
        }
    }
}