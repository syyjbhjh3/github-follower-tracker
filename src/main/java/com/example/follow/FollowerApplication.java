package com.example.follow;

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
		List<FollowerRepositoryDto> follower = followerService.getFollowerRepositories(username);
		List<FollowerRepositoryDto> following = followerService.getFollowingRepositories(username);

		/* 팔로워와 팔로잉을 Set으로 관리 */
		Set<String> followerSet = new HashSet<>();
		Set<String> followingSet = new HashSet<>();

		/* 팔로워 Set 구성 */
		follower.forEach(data -> {
			followerSet.add(data.getLogin());
		});

		/* 팔로잉 Set 구성과 동시에 비교 */
		following.forEach(data -> {
			followingSet.add(data.getLogin());

			/* 맞팔 해제한 User */
			if (!followerSet.contains(data.getLogin())) {
				System.out.println("맞팔 해제한 User: " + data.getLogin());
			}
		});

		/* 내가 맞팔 안한 User */
		followerSet.forEach(login -> {
			if (!followingSet.contains(login)) {
				System.out.println("내가 맞팔 안한 User: " + login);
			}
		});
	}
}
