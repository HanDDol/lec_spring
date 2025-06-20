package kr.nowsys.time.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class TimeController {

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("currentTime", LocalDateTime.now());
        return "hellotime";
    }
}
