package kr.nowsys.time.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.nowsys.time.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String processForm2(@RequestParam("studentName") String theName, Model model) {

//        String studentName = request.getParameter("studentName");

        model.addAttribute("message", theName + "Message required xxx");

        return "hello-world2";
    }

    @RequestMapping("/showStudentForm")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @RequestMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student s) {
//
////        String studentName = request.getParameter("studentName");
//
//        model.addAttribute("message", s.getLastName() + ":" + s.getFirstName());
        System.out.println("The Student " + s);

        return "student-confirmation";
    }
}
