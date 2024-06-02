package com.assignment.userpostservice.comment.service;

import com.assignment.userpostservice.auth.controller.AuthController;
import com.assignment.userpostservice.comment.dto.CommentDto;
import com.assignment.userpostservice.excepton.DownstreamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class CommentService {
    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    private final RestClient restClient;


    public CommentService(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<CommentDto> getAllComments() {
        logger.info("Fetching all comments from the downstream service.");

        return restClient.get().uri("/comments").retrieve().onStatus(HttpStatusCode::isError, (request, response) -> {
                    throw new DownstreamException(response.getStatusCode(), response.getStatusText());
                })
                .body(new ParameterizedTypeReference<>() {
                });

    }
}
