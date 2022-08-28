package com.brcubg.demoSpringProject.service.UserService;

import com.brcubg.demoSpringProject.dao.UserDao.UserDao;
import com.brcubg.demoSpringProject.entity.User;
import com.brcubg.demoSpringProject.request.UserRequest.UserQueryRequest;
import com.brcubg.demoSpringProject.response.RoleResponse.RoleQueryResponse;
import com.brcubg.demoSpringProject.response.UserResponse.UserQueryResponse;
import com.brcubg.demoSpringProject.service.RoleService.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    final private UserDao userDao;
    final private RoleService roleService;

    public UserServiceImpl(UserDao userDao, RoleService roleService) {
        this.userDao = userDao;
        this.roleService = roleService;
    }

    @Override
    public List<UserQueryResponse> getAllUsers(UserQueryRequest request) {
        List<User> users = userDao.findUsersByUserName(request);
        return users.stream().map(user -> {
            UserQueryResponse userQueryResponse = new UserQueryResponse();
            userQueryResponse.setId(user.getId());
            userQueryResponse.setUserName(user.getUserName());
            userQueryResponse.setPassword(user.getPassword());

            RoleQueryResponse role = roleService.findRoleById(user.getRoleId());
            if(role!=null){
                userQueryResponse.setRole(user.getRoleId());
                userQueryResponse.setRoleName(role.getRoleName());
            }
            return userQueryResponse;
        }).collect(Collectors.toList());
    }
}
