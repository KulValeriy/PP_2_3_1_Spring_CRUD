package usergroup.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import usergroup.service.UserService;
import usergroup.model.User;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String users(Model model) {
        model.addAttribute("users", userService.userList());
        return "users";
    }

    @GetMapping("/user")
    public String getUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute(userService.getUserById(id));
        return "editPage";
    }

    @PostMapping("/edit")
    public String editUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editPage";
        } else {
            userService.changeUser(user);
            return "redirect:/";
        }
    }

    @GetMapping("/add")
    public String add(User user) {
        return "add";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        } else {
            userService.addUser(user);
            return "redirect:/";
        }
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}