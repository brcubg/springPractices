package com.brcubg.demoSpringProject.service.UserService;

import com.brcubg.demoSpringProject.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceImpl {

    List<User> getAllUsers();
}
