package com.assignment.userpostservice.post.controller;

import com.assignment.userpostservice.comment.dto.CommentDto;
import com.assignment.userpostservice.post.dto.PostDto;
import com.assignment.userpostservice.post.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}/comments")
    public List<CommentDto> getCommentsByPost(@PathVariable("id") Long id) {
        return postService.getCommentsByPost(id);
    }
}