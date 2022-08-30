package com.brcubg.demoSpringProject.controller.UserController;

import com.brcubg.demoSpringProject.constant.ApiPaths;
import com.brcubg.demoSpringProject.request.UserRequest.UserQueryRequest;
import com.brcubg.demoSpringProject.response.UserResponse.UserQueryResponse;
import com.brcubg.demoSpringProject.service.UserService.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    final private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = ApiPaths.UserPaths.QUERY_PATH)
    private List<UserQueryResponse> getAllUsers(@RequestBody UserQueryRequest request) {
        return userService.getAllUsers(request);
    }
}
