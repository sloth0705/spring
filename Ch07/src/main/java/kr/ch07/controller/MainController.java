package kr.ch07.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ch07.dto.User1DTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
		String str1 = "스프링부트";
		String str2 = "타임리프";
		User1DTO user1  = new User1DTO("a101", "김춘추", "010-1111-2222", 22);
		User1DTO user2 = new User1DTO();
		user2.setUid("a102");
		user2.setName("김유신");
		user2.setHp("010-1234-5678");
		user2.setAge(23);
		User1DTO user3 = User1DTO.builder().uid("a103").name("장보고").hp("010-2222-3333").age(33).build();
		User1DTO user4 = null;
		List<User1DTO> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		model.addAttribute("str1", str1);
		model.addAttribute("str2", str2);
		model.addAttribute("user1", user1);
		model.addAttribute("user2", user2);
		model.addAttribute("user3", user3);
		model.addAttribute("user4", user4);
		model.addAttribute("users", users);
		log.info(user1.toString());
		return "index";
	}
	
	@GetMapping("/include")
	public String include() {
		return "/include";
	}
	
	@GetMapping("/layout")
	public String layout() {
		return "/layout";
	}
}