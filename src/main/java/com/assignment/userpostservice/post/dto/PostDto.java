package com.assignment.userpostservice.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PostDto(int id, @JsonProperty("user_id") int userId, String title, String body) {

}
