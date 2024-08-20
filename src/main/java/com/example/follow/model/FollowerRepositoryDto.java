package com.example.follow.model;

import lombok.Data;

@Data
public class FollowerRepositoryDto {
    private String login;
    private String name;
    private String email;
    private Integer id;
}
