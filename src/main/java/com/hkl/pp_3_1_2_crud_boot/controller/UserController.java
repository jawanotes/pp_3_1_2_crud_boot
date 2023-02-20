package com.hkl.pp_3_1_2_crud_boot.controller;


import com.hkl.pp_3_1_2_crud_boot.model.User;
import com.hkl.pp_3_1_2_crud_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:users";
    }
    @GetMapping("/users")
    public String listUsers(ModelMap model) {
        model.addAttribute("userlist", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam(value = "id", required = true) Long id, ModelMap model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/addnew")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.deleteUser(user);
        return "redirect:/users";
    }
}
