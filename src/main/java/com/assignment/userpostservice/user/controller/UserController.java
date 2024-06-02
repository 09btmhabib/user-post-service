package com.assignment.userpostservice.user.controller;

import com.assignment.userpostservice.comment.dto.CommentDto;
import com.assignment.userpostservice.post.dto.PostDto;
import com.assignment.userpostservice.user.dto.UserDto;
import com.assignment.userpostservice.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getPostsByUser(@PathVariable("id") Long id) {
        return userService.getPostsByUser(id);
    }
}
