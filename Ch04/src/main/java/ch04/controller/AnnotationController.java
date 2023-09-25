package ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch04.dto.ModelDTO;

@Controller
public class AnnotationController {
	@GetMapping("/annotation/param")
	public String param() {
		return "/annotation/param";
	}
	
	@GetMapping("/annotation/model")
	public String model() {
		return "/annotation/model";
	}
	
	@PostMapping("/annotation/param1")
	public String param1(@RequestParam("uid") String uid, Model model) {
		System.out.println("uid : " + uid);
		// 모델 참조를 통한 View 데이터 출력 
		model.addAttribute("uid", uid);
		return "/result/param";
	}
	
	@PostMapping("/annotation/param2")
	public String param2(	@RequestParam("uid") String uid, String name, Model model) {
		System.out.println("uid : " + uid);
		System.out.println("name : " + name);
		model.addAttribute("uid", uid);
		model.addAttribute("name", name);
		return "/result/param";
	}
	
	@PostMapping("/annotation/param3")
	public String param3(String uid, String name, String hp, int age, Model model) {
		model.addAttribute("uid", uid);
		model.addAttribute("name", name);
		model.addAttribute("hp", hp);
		model.addAttribute("age", age);
		return "/result/param";
	}
	
	@PostMapping("/annotation/model1")
	public String model1(@ModelAttribute ModelDTO dto) {
		return "/result/model";
	}
	
	@PostMapping("/annotation/model2")
	public String model2(@ModelAttribute("user") ModelDTO dto) {
		return "/result/model";
	}
	
	@PostMapping("/annotation/model3")
	public String model3(ModelDTO dto) {
		return "/result/model";
	}
}