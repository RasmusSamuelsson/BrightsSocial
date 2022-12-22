package com.example.BrightsSocial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BrightsSocialApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testUserCreation() {
		User user = new User("Andreas", "Olsson", "Sthlm", "Andreas", "12345678");
		Assertions.assertEquals("Andreas", user.getFirstName());
		Assertions.assertEquals("Andreas", user.getUsername());
		Assertions.assertEquals("Olsson", user.getLastName());
		Assertions.assertEquals("Sthlm", user.getCity());
		Assertions.assertEquals("12345678", user.getPassword());
	}

}
