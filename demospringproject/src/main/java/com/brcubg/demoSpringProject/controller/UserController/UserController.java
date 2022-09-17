package com.brcubg.demoSpringProject.controller.UserController;

import com.brcubg.demoSpringProject.constant.ApiPaths;
import com.brcubg.demoSpringProject.entity.User;
import com.brcubg.demoSpringProject.request.UserRequest.UserCreateRequest;
import com.brcubg.demoSpringProject.request.UserRequest.UserQueryRequest;
import com.brcubg.demoSpringProject.response.UserResponse.UserQueryResponse;
import com.brcubg.demoSpringProject.service.UserService.UserService;
import com.brcubg.demoSpringProject.validator.userValidator.UserValidator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    final private UserService userService;
    final private UserValidator userValidator;
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping(path = ApiPaths.UserPaths.QUERY_PATH)
    private List<UserQueryResponse> getAllUsers(@RequestBody UserQueryRequest request) throws Exception {
        //TODO: Add errorList for pageValidator when Pagination added
        /*
        List<String> errors = pageValidator.validate(pageSize, pageNum);
        errors.addAll(userValidator.validateUserName(userName));
          if(!errors.isEmpty()){
            throw new Exception("User Not Found!");
        }
         */
        List<String> errors = userValidator.validateUserName(request.getUserName());
        if(!errors.isEmpty()){
            throw new Exception("Not found user by with " + request.getUserName() + " username!");
        }
        return userService.getAllUsers(request);
    }

    @GetMapping(path = ApiPaths.UserPaths.GET_USER_PATH)
    private UserQueryResponse getUser(@PathVariable Long id) throws Exception {
        List<String> errors = userValidator.validate(id);
        if(!errors.isEmpty()){
            throw new Exception("User Not Found!");
        }
        return userService.getUser(id);
    }

    @PostMapping(path = ApiPaths.UserPaths.CREATE_PATH)
    private User createUser(@RequestBody UserCreateRequest request) throws Exception {
        List<String> errors = userValidator.createUserValidate(request);
        if(!errors.isEmpty()){
            throw new Exception("Entered parameters must suitable to the format!" + errors);
        }
        return userService.createUser(request);
    }
}
