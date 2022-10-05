package com.brcubg.demospringproject.service.userservice;

import com.brcubg.demospringproject.dao.userdao.UserDao;
import com.brcubg.demospringproject.entity.User;
import com.brcubg.demospringproject.request.userrequest.UserCreateRequest;
import com.brcubg.demospringproject.request.userrequest.UserQueryRequest;
import com.brcubg.demospringproject.response.roleresponse.RoleQueryResponse;
import com.brcubg.demospringproject.response.userresponse.UserQueryResponse;
import com.brcubg.demospringproject.service.roleservice.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final RoleService roleService;

    public UserServiceImpl(UserDao userDao, RoleService roleService) {
        this.userDao = userDao;
        this.roleService = roleService;
    }

    @Override
    public List<UserQueryResponse> getAllUsers(UserQueryRequest request) {
        List<User> users = userDao.isFilteredUsers(request);

        // TODO: check user isEmpty
        return users.stream().map(user -> {
            UserQueryResponse userQueryResponse = UserQueryResponse.builder()
                    .id(user.getId())
                    .userName(user.getUserName())
                    .password(user.getPassword())
                    .role(user.getRoleId())
                    .build();
            //TODO: convert roleService to roleDao
            RoleQueryResponse role = roleService.findRoleById(user.getRoleId());
            if(role != null){
                userQueryResponse.setRole(user.getRoleId());
                userQueryResponse.setRoleName(role.getRoleName());
            }
            return userQueryResponse;
        }).toList();
    }

    @Override
    public UserQueryResponse getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public User createUser(UserCreateRequest request) {
        return userDao.createUser(request);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User updateUser(Long id, UserCreateRequest request) {
        return userDao.updateUser(id, request);
    }
}
