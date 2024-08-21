package com.example.follow.model;

import lombok.Data;

@Data
public class FollowerApiResponse<T> {
    private boolean success;
    private String message;
    private int statusCode;
    private T data;

    public FollowerApiResponse(boolean success, String message, int statusCode, T data) {
        this.success = success;
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }
}

