package kr.co.pofo.pofoapiboot3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @RequestMapping("")
    public String home() {
        return "Hello, World!";
    }
}
