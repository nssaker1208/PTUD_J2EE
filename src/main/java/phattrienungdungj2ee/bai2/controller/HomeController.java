package phattrienungdungj2ee.bai2.controller;

import org.springframework.stereotype.Controller; // Lưu ý: Không dùng RestController
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Dùng annotation này để trả về giao diện HTML
@RequestMapping("/")
public class HomeController {
    @GetMapping("/home")
    public String index() {
        return "index"; // Trả về tên file HTML (không cần đuôi .html)
    }
}
