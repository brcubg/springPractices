package com.brcubg.demoSpringProject.service.UserService;

import com.brcubg.demoSpringProject.entity.User;
import com.brcubg.demoSpringProject.request.UserRequest.UserCreateRequest;
import com.brcubg.demoSpringProject.request.UserRequest.UserQueryRequest;
import com.brcubg.demoSpringProject.response.UserResponse.UserQueryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserQueryResponse> getAllUsers(UserQueryRequest request);
    UserQueryResponse getUser(Long id);

    User createUser(UserCreateRequest request);
}
