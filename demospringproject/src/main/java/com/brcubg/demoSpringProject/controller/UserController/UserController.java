package com.brcubg.demoSpringProject.controller.UserController;

import com.brcubg.demoSpringProject.request.UserRequest.UserRequest;
import com.brcubg.demoSpringProject.respons.UserRepository.UserResponse.UserResponse;
import com.brcubg.demoSpringProject.service.UserService.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    final private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private List<UserResponse> getAllUsers(@RequestBody UserRequest userRequest) {
        return userService.getAllUsers(userRequest.getUserName());
    }
}
