package co.kr.ch12.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class MainController {
    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "/index";
    }

    @GetMapping("/user/login")
    public String login() {
        return "/user/login";
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session) throws IOException {
        String token = (String) session.getAttribute("accessToken");
        System.out.println("token : " + token);
        URL url = new URL("https://kapi.kakao.com/v1/user/logout");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + token);
        int resCode = conn.getResponseCode();
        System.out.println("resCode : " +  resCode);
        return "redirect:/index";
    }
}
