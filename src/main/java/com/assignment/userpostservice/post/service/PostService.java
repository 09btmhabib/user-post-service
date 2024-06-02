package com.assignment.userpostservice.post.service;

import com.assignment.userpostservice.comment.dto.CommentDto;
import com.assignment.userpostservice.comment.service.CommentService;
import com.assignment.userpostservice.excepton.DownstreamException;
import com.assignment.userpostservice.post.dto.PostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    private final RestClient restClient;


    public PostService(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<PostDto> getAllPosts() {
        logger.info("Fetching all posts from the downstream service.");


        return restClient.get().uri("/posts").retrieve().onStatus(HttpStatusCode::isError, (request, response) -> {
                    throw new DownstreamException(response.getStatusCode(), response.getStatusText());
                })
                .body(new ParameterizedTypeReference<>() {
                });

    }

    public List<CommentDto> getCommentsByPost(Long id) {
        logger.info("Fetching all comments for post :{}", id);

        return restClient.get().uri("/posts/" + id + "/comments").retrieve().onStatus(HttpStatusCode::isError, (request, response) -> {
                    throw new DownstreamException(response.getStatusCode(), response.getStatusText());
                })
                .body(new ParameterizedTypeReference<>() {
                });
    }

}
