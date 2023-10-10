package kr.ch07.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ch07.dto.User6DTO;
import kr.ch07.service.User6Service;

@WebMvcTest(controllers = User6Controller.class)
public class User6ControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private User6Service service;
	
	public void register() throws Exception {
		mvc
			.perform(get("/user6/register"))
			.andExpect(status().isOk())
			.andExpect(view().name("/user6/register"))
			.andDo(print());
	}
	
	@Test
	public void registerPost() throws Exception {
		User6DTO dto = User6DTO.builder()
						.uid("a101")
						.name("김유신")
						.birth("2023-09-26")
						.gender("M")
						.age(23)
						.addr("서울")
						.hp("010-1234-5678")
						.build();
		String json = new ObjectMapper().writeValueAsString(dto);
		mvc
			.perform(
						post("/user6/register")
						.queryParam("uid", "a101")
						.queryParam("name", "김유신")
						.queryParam("birth", "2023-09-26")
						.queryParam("gender", "M")
						.queryParam("age", "23")
						.queryParam("addr", "서울")
						.queryParam("hp", "010-1234-5678")
					)
			.andExpect(redirectedUrl("/user6/list"))
			.andDo(print());
	}
}