package com.brcubg.demospringproject.dao.userdao;

import com.brcubg.demospringproject.entity.User;
import com.brcubg.demospringproject.request.userrequest.UserCreateRequest;
import com.brcubg.demospringproject.request.userrequest.UserQueryRequest;
import com.brcubg.demospringproject.response.userresponse.UserQueryResponse;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    List<User> isFilteredUsers(UserQueryRequest request);
    boolean isExistId(Long id);
    UserQueryResponse getUser(Long id);
    User createUser(UserCreateRequest request);
    void deleteUser(Long id);
    User updateUser(Long id, UserCreateRequest request);
}
