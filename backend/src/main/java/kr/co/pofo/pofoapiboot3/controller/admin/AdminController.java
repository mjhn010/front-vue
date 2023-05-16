package kr.co.pofo.pofoapiboot3.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin1")
public class AdminController {

    @GetMapping("/index")
    public String admin() {
        return "admin.html";
    }

    @GetMapping("/login")
    public String admin2() {
        return "login.html";
    }
}