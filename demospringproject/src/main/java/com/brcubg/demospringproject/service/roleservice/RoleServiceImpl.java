package com.brcubg.demospringproject.service.roleservice;

import com.brcubg.demospringproject.dao.roledao.RoleDao;
import com.brcubg.demospringproject.entity.Role;
import com.brcubg.demospringproject.response.roleresponse.RoleQueryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<RoleQueryResponse> getAllRoles(String roleName) {
        List<Role> roles = roleDao.findRolesByRoleName(roleName);
        return roles.stream()
                .map(role -> RoleQueryResponse.builder()
                    .id(role.getId())
                    .roleName(role.getRoleName())
                    .build()
        ).toList();
    }

    @Override
    public RoleQueryResponse findRoleById(Long id) {
        Optional<Role> role = roleDao.findRoleById(id);
        RoleQueryResponse response = null;
        if(role.isPresent()){
            response = RoleQueryResponse.builder()
                    .id(role.get().getId())
                    .roleName(role.get().getRoleName())
                    .build();
        }
        return response;
    }
}
