package com.thoughtworks.practice.TaskManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void expectedSameUserNameAfterSerialization() throws JsonProcessingException {

		User userOne = new User("neha2@gmail.com","Neha","neha22");
		ObjectMapper objectMapper = new ObjectMapper();
		String expectedString = objectMapper.writeValueAsString(userOne);
		Assertions.assertTrue(expectedString.contains("\"userName\":\"Neha\""));
	}

	@Test
	void expectedSamePasswordAfterSerialization() throws JsonProcessingException{
		User userOne = new User("avani6@gmail.com","Avani","avani22");
		ObjectMapper objectMapper = new ObjectMapper();
		String expectedString = objectMapper.writeValueAsString(userOne);
		Assertions.assertTrue(expectedString.contains("\"password\":\"avani22\""));

	}

}
