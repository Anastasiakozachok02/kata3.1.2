package com.example.kata3_1_2.controller;

import com.example.kata3_1_2.model.User;
import com.example.kata3_1_2.service.UsersService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class UsersController {

    private final UsersService usersService;

    private final Validator validator;


    public UsersController(UsersService usersService, Validator validator) {
        this.usersService = usersService;
        this.validator = validator;
    }

    @RequestMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", usersService.getAll());
        return "users";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("user") User user, Model model) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (violations.size() > 0) {
            StringBuilder errorMessage = new StringBuilder();
            for (ConstraintViolation<User> violation : violations) {
                errorMessage.append(violation.getMessage()).append("\n");
            }
            model.addAttribute("error", errorMessage.toString().trim());
            return "add";
        }
        usersService.add(user);
        return "redirect:users";
    }

    @GetMapping("/add")
    public String add(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        usersService.deleteById(id);
        return "redirect:users";
    }

    @GetMapping("/change")
    public String change(@RequestParam("id") Long id, Model model) {
        User user = usersService.getById(id);
        model.addAttribute("user", user);
        return "change";
    }

    @PostMapping("/change")
    public String change(@ModelAttribute("user") User user, Model model) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (violations.size() > 0) {
            StringBuilder errorMessage = new StringBuilder();
            for (ConstraintViolation<User> violation : violations) {
                errorMessage.append(violation.getMessage()).append("\n");
            }
            model.addAttribute("error", errorMessage.toString().trim());
            return "change";
        }
        usersService.change(user);
        return "redirect:users";
    }
}

