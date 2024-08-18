package com.example.follow.service;

import com.example.follow.model.FollowerEnum;
import com.example.follow.model.FollowerRepositoryDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@Service
public class FollowerService {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Value("${github.token}")
    private String token;

    public FollowerService(HttpClient httpClient) {
        this.httpClient = httpClient;
        this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    public List<FollowerRepositoryDto> getFollowerRepositories(String username) throws Exception {
        String uri = String.format(FollowerEnum.FOLLOWER_URL.getUrl(), username);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Accept", "application/vnd.github+json")
                .header("Authorization", "Bearer " + token)
                .header("X-GitHub-Api-Version", "2022-11-28")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            FollowerRepositoryDto[] followers = objectMapper.readValue(response.body(), FollowerRepositoryDto[].class);
            return Arrays.asList(followers);
        } else {
            throw new RuntimeException("Failed to get followers: " + response.statusCode());
        }
    }

    public List<FollowerRepositoryDto> getFollowingRepositories(String username) throws Exception {
        String uri = String.format(FollowerEnum.FOLLWING_URL.getUrl(), username);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Accept", "application/vnd.github+json")
                .header("Authorization", "Bearer " + token)
                .header("X-GitHub-Api-Version", "2022-11-28")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            FollowerRepositoryDto[] followers = objectMapper.readValue(response.body(), FollowerRepositoryDto[].class);
            return Arrays.asList(followers);
        } else {
            throw new RuntimeException("Failed to get followers: " + response.statusCode());
        }
    }
}