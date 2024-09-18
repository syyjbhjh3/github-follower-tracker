package com.example.follow;

import com.example.follow.service.FollowerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.http.HttpClient;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		FollowerService svc = new FollowerService(HttpClient.newHttpClient());
		try {
			svc.followingUser("syyjbhjh3");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
