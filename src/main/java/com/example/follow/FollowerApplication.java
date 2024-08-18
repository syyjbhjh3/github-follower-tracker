package com.example.follow;

import com.example.follow.model.FollowerRepositoryDto;
import com.example.follow.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

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
		String username = "syyjbhjh3";  // 예시 사용자 이름
		List<FollowerRepositoryDto> follower = followerService.getFollowerRepositories(username);
		List<FollowerRepositoryDto> following = followerService.getFollowingRepositories(username);

		following.forEach(repo -> {
			System.out.println(repo.getLogin());
		});

		follower.forEach(repo -> {
			System.out.println(repo.getLogin());
		});
	}
}
