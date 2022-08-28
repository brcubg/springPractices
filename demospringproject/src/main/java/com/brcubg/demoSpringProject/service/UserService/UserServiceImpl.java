package com.brcubg.demoSpringProject.service.UserService;

import com.brcubg.demoSpringProject.dao.UserDao.UserDao;
import com.brcubg.demoSpringProject.entity.User;
import com.brcubg.demoSpringProject.repository.UserRepository;
import com.brcubg.demoSpringProject.response.UserResponse.UserQueryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;
    final private UserDao userDao;

    public UserServiceImpl(UserRepository userRepository, UserDao userDao) {
        this.userRepository = userRepository;
        this.userDao = userDao;
    }

 /*   @Override
    public List<UserQueryResponse> getAllUsers(String userName) {
        List<User> users;
        if(userName.isEmpty()){
            users = userRepository.findAll();
        } else {
            //users = userRepository.findByUserNameContaining(userName);
            users = userRepository.findUsersByUserName(userName);
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
*/

    @Override
    public List<UserQueryResponse> getAllUsers(String userName) {
        List<User> users = userDao.findUsersByUserName(userName);
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
