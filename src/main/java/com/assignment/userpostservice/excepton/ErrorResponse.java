package com.assignment.userpostservice.excepton;

public record ErrorResponse(
        String timestamp,
        int status,
        String error,
        String path
) {


}