package com.brcubg.demoSpringProject.service.UserService;

import com.brcubg.demoSpringProject.entity.User;
import com.brcubg.demoSpringProject.repository.UserRepository;
import com.brcubg.demoSpringProject.respons.UserRepository.UserResponse.UserQueryResponse;
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
    public List<UserQueryResponse> getAllUsers(String userName) {
        List<User> users;
        if(userName.isEmpty()){
            users = userRepository.findAll();
        } else {
            users = userRepository.findByUserNameContaining(userName);
        }
        return users.stream().map(user -> {
            UserQueryResponse userQueryResponse = new UserQueryResponse();
            userQueryResponse.setId(user.getId());
            userQueryResponse.setUserName(user.getUserName());
            userQueryResponse.setPassword(user.getPassword());
            userQueryResponse.setRole(user.getRoleId());
            return userQueryResponse;
        }).collect(Collectors.toList());
    }
}
