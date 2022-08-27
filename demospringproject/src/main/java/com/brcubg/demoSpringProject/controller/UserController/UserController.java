package com.brcubg.demoSpringProject.controller.UserController;

import com.brcubg.demoSpringProject.entity.User;
import com.brcubg.demoSpringProject.service.UserService.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    final private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
