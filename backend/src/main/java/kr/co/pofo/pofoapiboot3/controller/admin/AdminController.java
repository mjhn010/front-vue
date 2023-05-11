package kr.co.pofo.pofoapiboot3.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin1")
    public String admin() {
        return "admin.html";
    }

    @GetMapping("/admin2")
    public String admin2() {
        return "chartjs.html";
    }
}
