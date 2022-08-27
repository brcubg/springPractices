package com.brcubg.demoSpringProject.service.UserService;

import com.brcubg.demoSpringProject.respons.UserRepository.UserResponse.UserQueryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceImpl {

    List<UserQueryResponse> getAllUsers(String userName);
}
