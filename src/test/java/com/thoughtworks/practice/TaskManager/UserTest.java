package com.thoughtworks.practice.TaskManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTest {

	@Test
	void expectedSameUserNameAfterSerialization() throws JsonProcessingException {

		User userOne = new User("Neha","neha22");
		ObjectMapper objectMapper = new ObjectMapper();
		String expectedString = objectMapper.writeValueAsString(userOne);
		Assertions.assertTrue(expectedString.contains("\"userName\":\"Neha\""));
	}

}
