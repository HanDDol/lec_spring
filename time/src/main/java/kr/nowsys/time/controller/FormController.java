package kr.nowsys.time.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.nowsys.time.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FormController {

    @Value("${countries}")
    List<String> countries;

    @Value("${programmingLanguages}")
    List<String> programmingLanguages;

    @Value("${oses}")
    List<String> oses;

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
        model.addAttribute("countries", countries);
        model.addAttribute("programmingLanguages", programmingLanguages);
        model.addAttribute("oses", oses);
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
