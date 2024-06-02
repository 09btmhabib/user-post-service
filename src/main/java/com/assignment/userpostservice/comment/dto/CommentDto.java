package com.assignment.userpostservice.comment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CommentDto(int id, @JsonProperty("post_id") int postId, String name, String email, String body) {

}
