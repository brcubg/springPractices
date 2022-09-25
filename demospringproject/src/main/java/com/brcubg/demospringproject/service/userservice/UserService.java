package com.brcubg.demospringproject.service.userservice;

import com.brcubg.demospringproject.entity.User;
import com.brcubg.demospringproject.request.userrequest.UserCreateRequest;
import com.brcubg.demospringproject.request.userrequest.UserQueryRequest;
import com.brcubg.demospringproject.response.userresponse.UserQueryResponse;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserQueryResponse> getAllUsers(UserQueryRequest request);
    UserQueryResponse getUser(Long id);

    User createUser(UserCreateRequest request);

    void deleteUser(Long id);

    User updateUser(Long id, UserCreateRequest request);
}
