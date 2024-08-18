package com.example.follow.model;

import lombok.Getter;

@Getter
public enum FollowerEnum {
    FOLLOWER_URL("https://api.github.com/users/%s/followers"),
    FOLLWING_URL("https://api.github.com/users/%s/following");

    public final String url;

    FollowerEnum(String url){
        this.url = url;
    }
}