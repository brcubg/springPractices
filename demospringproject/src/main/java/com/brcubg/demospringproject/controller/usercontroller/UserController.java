package com.brcubg.demospringproject.controller.usercontroller;

import com.brcubg.demospringproject.constant.ApiPaths;
import com.brcubg.demospringproject.entity.User;
import com.brcubg.demospringproject.request.userrequest.UserCreateRequest;
import com.brcubg.demospringproject.request.userrequest.UserQueryRequest;
import com.brcubg.demospringproject.response.userresponse.UserQueryResponse;
import com.brcubg.demospringproject.service.userservice.UserService;
import com.brcubg.demospringproject.validator.UserValidator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping(path = ApiPaths.UserPaths.QUERY_PATH)
    public ResponseEntity<List<UserQueryResponse>> getAllUsers(@RequestBody UserQueryRequest request) {
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
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = ApiPaths.UserPaths.GET_USER_PATH)
    public ResponseEntity<UserQueryResponse> getUser(@PathVariable Long id) {
        List<String> errors = userValidator.validate(id);
        if(!errors.isEmpty()){
            throw new RuntimeException("Id not found!" + errors);
        }
        try {
            return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = ApiPaths.UserPaths.CREATE_PATH)
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest request) {
        List<String> errors = userValidator.createOrUpdateUserValidate(request);
        if(!errors.isEmpty()){
            throw new RuntimeException("Entered parameters must suitable to the format!" + errors);
        }
        try {
            return new ResponseEntity<>(userService.createUser(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = ApiPaths.UserPaths.DELETE_PATH)
    public void deleteUser(@PathVariable Long id) {
        List<String> errors = userValidator.validate(id);
        if(!errors.isEmpty()){
            throw new RuntimeException("Id not found!" + errors);
        }
        userService.deleteUser(id);
    }

    @PutMapping(path = ApiPaths.UserPaths.UPDATE_PATH)
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserCreateRequest request) {
        List<String> errors = userValidator.validate(id);
        errors.addAll(userValidator.createOrUpdateUserValidate(request));
        if(!errors.isEmpty()){
            throw new RuntimeException("Entered parameters must suitable to the format!" + errors);
        }
        try {
            return new ResponseEntity<>(userService.updateUser(id, request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
