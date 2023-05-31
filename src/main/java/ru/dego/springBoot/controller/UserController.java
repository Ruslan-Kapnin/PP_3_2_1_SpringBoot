package ru.dego.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.dego.springBoot.model.User;
import ru.dego.springBoot.service.UserServiceImpl;

import java.util.List;


@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping()
    public String getUsers(ModelMap model) {
        List<User> users = userServiceImpl.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "users";
    }

    @GetMapping("/{id}/edit")
    public String getEditUser(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userServiceImpl.getById(id));
        return "editUser";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userServiceImpl.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImpl.remove(id);
        return "redirect:/users";
    }
}
