package kr.co.sboard.controller.aritcle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    @GetMapping("/article/list")
    public String list() {
        return "/article/list";
    }
    @GetMapping("/article/register")
    public String register() {
        return "/article/register";
    }
}