package com.in28minutes.rest.webservices;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.in28minutes.rest.webservices.user.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestfulWebServicesApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void contextLoads() throws Exception {
		User user;
		user = new User(1, "paula", new Date());

		Gson gson = new Gson();
	    String json = gson.toJson(user);
		
//		String json = "{\"name\": \"P\",\"birthDate\": \"2018-03-26T23:49:55.640+0000\"}";
		
		this.mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
				.content(json)).andExpect(status().is2xxSuccessful());
	}

}
