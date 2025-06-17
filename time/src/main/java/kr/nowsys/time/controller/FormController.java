package kr.nowsys.time.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "hello-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {

        return "hello-world";
    }

    @RequestMapping("/processForm2")
    public String processForm2(HttpServletRequest request, Model model) {

        String studentName = request.getParameter("studentName");

        model.addAttribute("message", studentName + "Message required");

        return "hello-world2";
    }
}
