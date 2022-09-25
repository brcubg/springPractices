package com.brcubg.demoSpringProject.controller.UserController;

import com.brcubg.demoSpringProject.constant.ApiPaths;
import com.brcubg.demoSpringProject.entity.User;
import com.brcubg.demoSpringProject.request.UserRequest.UserCreateRequest;
import com.brcubg.demoSpringProject.request.UserRequest.UserQueryRequest;
import com.brcubg.demoSpringProject.response.UserResponse.UserQueryResponse;
import com.brcubg.demoSpringProject.service.UserService.UserService;
import com.brcubg.demoSpringProject.validator.userValidator.UserValidator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<List<UserQueryResponse>> getAllUsers(@RequestBody UserQueryRequest request) {
        //TODO: Add errorList for pageValidator when Pagination added
        /*
        List<String> errors = pageValidator.validate(pageSize, pageNum);
        errors.addAll(userValidator.validateUserName(userName));
          if(!errors.isEmpty()){
            throw new Exception("User Not Found!");
        }
         */
        try{
            return new ResponseEntity<>(userService.getAllUsers(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = ApiPaths.UserPaths.GET_USER_PATH)
    private ResponseEntity<UserQueryResponse> getUser(@PathVariable Long id) throws Exception {
        List<String> errors = userValidator.validate(id);
        if(!errors.isEmpty()){
            throw new Exception("Id not found!" + errors);
        }
        try {
            return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = ApiPaths.UserPaths.CREATE_PATH)
    private ResponseEntity<User> createUser(@RequestBody UserCreateRequest request) throws Exception {
        List<String> errors = userValidator.createOrUpdateUserValidate(request);
        if(!errors.isEmpty()){
            throw new Exception("Entered parameters must suitable to the format!" + errors);
        }
        try {
            return new ResponseEntity<>(userService.createUser(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = ApiPaths.UserPaths.DELETE_PATH)
    private void deleteUser(@PathVariable Long id) throws Exception {
        List<String> errors = userValidator.validate(id);
        if(!errors.isEmpty()){
            throw new Exception("Id not found!" + errors);
        }
        userService.deleteUser(id);
    }

    @PutMapping(path = ApiPaths.UserPaths.UPDATE_PATH)
    private ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserCreateRequest request) throws Exception {
        List<String> errors = userValidator.validate(id);
        errors.addAll(userValidator.createOrUpdateUserValidate(request));
        if(!errors.isEmpty()){
            throw new Exception("Entered parameters must suitable to the format!" + errors);
        }
        try {
            return new ResponseEntity<>(userService.updateUser(id, request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
