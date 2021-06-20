package ru.flendger.interview.lesson7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
public class StudentSpringController {
    private final StudentSpringService studentSpringService;

    public StudentSpringController(StudentSpringService studentSpringService) {
        this.studentSpringService = studentSpringService;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        model.addAttribute("students",
                studentSpringService.findAll().stream()
                        .sorted(Comparator.comparing(StudentSpring::getId))
                        .collect(Collectors.toList()));
        return "students";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentSpringService.findById(id));
        return "edit";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable Long id) {
        studentSpringService.delete(id);
        return "redirect:/list";
    }

    @PostMapping("/save")
    public String save(StudentSpring studentSpring) {
        studentSpringService.save(studentSpring);
        return "redirect:/list";
    }
}
