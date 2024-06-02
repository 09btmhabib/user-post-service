package com.assignment.userpostservice.user.service;

import com.assignment.userpostservice.excepton.DownstreamException;
import com.assignment.userpostservice.post.dto.PostDto;
import com.assignment.userpostservice.user.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final RestClient restClient;


    public UserService(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<UserDto> getAllUsers() {
        logger.info("Fetching all users from the downstream service.");

        return restClient.get().uri("/users").retrieve().onStatus(HttpStatusCode::isError, (request, response) -> {
                    throw new DownstreamException(response.getStatusCode(), response.getStatusText());
                })
                .body(new ParameterizedTypeReference<>() {
                });

    }

    public List<PostDto> getPostsByUser(Long id) {
        logger.info("Fetching all posts for user :{} ", id);

        return restClient.get().uri("/users/" + id + "/posts").
                retrieve().onStatus(HttpStatusCode::isError, (request, response) -> {
                    throw new DownstreamException(response.getStatusCode(), response.getStatusText());
                })
                .body(new ParameterizedTypeReference<>() {
                });

    }
}
