package com.brcubg.demoSpringProject.service.UserService;

import com.brcubg.demoSpringProject.entity.User;
import com.brcubg.demoSpringProject.repository.UserRepository;
import com.brcubg.demoSpringProject.respons.UserRepository.UserResponse.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceImpl {

    final private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAllUsers(String userName) {
        List<User> users;
        if(userName.isEmpty()){
            users = userRepository.findAll();
        } else {
            users = userRepository.findByUserNameContaining(userName);
        }
        return users.stream().map(user -> {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.getId());
            userResponse.setUserName(user.getUserName());
            userResponse.setPassword(user.getPassword());
            userResponse.setRole(user.getRoleId());
            return userResponse;
        }).collect(Collectors.toList());
    }
}
