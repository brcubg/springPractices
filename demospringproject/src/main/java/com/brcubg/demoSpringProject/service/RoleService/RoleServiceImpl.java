package com.brcubg.demoSpringProject.service.RoleService;

import com.brcubg.demoSpringProject.dao.RoleDao.RoleDao;
import com.brcubg.demoSpringProject.entity.Role;
import com.brcubg.demoSpringProject.response.RoleResponse.RoleQueryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService{

    final private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<RoleQueryResponse> getAllRoles(String roleName) {
        List<Role> roles = roleDao.findRolesByRoleName(roleName);
        return roles.stream().map(role -> {
            RoleQueryResponse response = new RoleQueryResponse();
            response.setId(role.getId());
            response.setRoleName(role.getRoleName());
            return response;
        }).collect(Collectors.toList());
    }
}
