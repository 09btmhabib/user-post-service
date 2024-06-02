package com.assignment.userpostservice.excepton;

import org.springframework.http.HttpStatusCode;

public class DownstreamException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final HttpStatusCode httpStatus;

    public DownstreamException(HttpStatusCode httpStatus, String msg) {
        super(msg);
        this.httpStatus = httpStatus;
    }

    public HttpStatusCode getHttpStatus() {
        return this.httpStatus;
    }
}