package com.example.follow.model;

import lombok.Getter;

@Getter
public enum FollowerEnum {
    FOLLOWER_URL("https://api.github.com/users/%s/followers?per_page=100&page=%d"),
    FOLLWING_URL("https://api.github.com/users/%s/following?per_page=100&page=%d"),
    FOLLWING_USER_URL("https://api.github.com/user/following/%s");

    public final String url;

    FollowerEnum(String url){
        this.url = url;
    }
}