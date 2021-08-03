package me.loda.spring.controllerweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WebController {
    // Đón nhận request GET
    @GetMapping("/") // Nếu người dùng request tới địa chỉ "/"
    public String index() {
        return "index"; // Trả về file indexc.html
    }

    @GetMapping("/about") // Nếu người dùng request tới địa chỉ "/about"
    public String about() {
        return "about"; // Trả về file about.html
    }

    @GetMapping("/hello")
    public String hello(
        @RequestParam Map<String, Object> params,
            // Model là một object của Spring Boot, được gắn vào trong mọi request.
            Model model){
        // Gắn vào model giá trị  nhận được
        model.addAttribute("name", params.get("name"));
        model.addAttribute("check", params.get("checkbox"));
        model.addAttribute("check1", params.get("checkbox1"));
        return "hello";
    }

}
