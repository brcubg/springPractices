package com.brcubg.demoSpringProject.service.UserService;

import com.brcubg.demoSpringProject.entity.User;
import com.brcubg.demoSpringProject.request.UserRequest.UserRequest;
import com.brcubg.demoSpringProject.respons.UserRepository.UserResponse.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceImpl {

    List<UserResponse> getAllUsers(String userName);
}
