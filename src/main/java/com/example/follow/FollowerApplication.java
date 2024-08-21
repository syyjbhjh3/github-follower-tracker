package com.example.follow;

import com.example.follow.model.FollowerApiResponse;
import com.example.follow.model.FollowerRepositoryDto;
import com.example.follow.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class FollowerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FollowerApplication.class, args);
	}
	private final FollowerService followerService;

	@Autowired
	public FollowerApplication(FollowerService followerService) {
		this.followerService = followerService;
	}

	@Override
	public void run(String... args) throws Exception {
		String username = "syyjbhjh3";

		int page = 1;
		boolean hasMoreFollowers = true;
		boolean hasMoreFollowing = true;

		Set<String> followerSet = new HashSet<>();
		Set<String> followingSet = new HashSet<>();

		while (hasMoreFollowers || hasMoreFollowing) {
			if (hasMoreFollowers) {
				List<FollowerRepositoryDto> followerBatch = followerService.getFollowerRepositories(username, page);
				followerBatch.forEach(data -> followerSet.add(data.getLogin()));

				if (followerBatch.size() < 100) {
					hasMoreFollowers = false;
				}
			}

			if (hasMoreFollowing) {
				List<FollowerRepositoryDto> followingBatch = followerService.getFollowingRepositories(username, page);
				followingBatch.forEach(data -> followingSet.add(data.getLogin()));

				if (followingBatch.size() < 100) {
					hasMoreFollowing = false;
				}
			}
			page++;
		}

		/* 맞팔 해제한 사용자 출력 */
		followingSet.forEach(login -> {
			if (!followerSet.contains(login)) {
				try {
					FollowerApiResponse<String> response = followerService.unFollowingUser(login);

					if (!response.isSuccess()) {
						System.out.println("Error: " + response.getMessage() + " (Status Code: " + response.getStatusCode() + ")");
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});

		/* 내가 맞팔하지 않은 사용자 출력 */
		followerSet.forEach(login -> {
			if (!followingSet.contains(login)) {
				try {
					FollowerApiResponse<String> response = followerService.followingUser(login);

					if (!response.isSuccess()) {
						System.out.println("Error: " + response.getMessage() + " (Status Code: " + response.getStatusCode() + ")");
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}
}
