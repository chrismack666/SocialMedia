package com.socialmedia.project.rest;

import com.socialmedia.project.dto.PostDto;
import com.socialmedia.project.model.Post;
import com.socialmedia.project.security.UserDetails;
import com.socialmedia.project.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@Api(value = "Управление постами", description = "Управляет операциями над постами")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    @ApiOperation(value = "Получение всех постов")
    public Iterable<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Получение одного поста по его идентификатору")
    public Post getPost(@PathVariable @ApiParam(value = "Идентификатор поста") Integer id) {
        return this.postService.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Создание поста")
    public Post createPost(@RequestBody PostDto postDto, @AuthenticationPrincipal UserDetails userDetails) {
        return postService.save(postDto, userDetails.getUser());
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаление поста")
    public void delete(@PathVariable Integer id, @AuthenticationPrincipal UserDetails userDetails) {
        postService.checkAuthor(id, userDetails.getUser());
        postService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменение поста")
    public Post update(@RequestBody PostDto postDto, @PathVariable Integer id, @AuthenticationPrincipal UserDetails userDetails) {
        postService.checkAuthor(id, userDetails.getUser());
        Post post = postService.findById(id);
        return postService.save(postDto, post);
    }
}
