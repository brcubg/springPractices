package com.brcubg.demoSpringProject.service.RoleService;

import com.brcubg.demoSpringProject.dao.RoleDao.RoleDao;
import com.brcubg.demoSpringProject.entity.Role;
import com.brcubg.demoSpringProject.repository.RoleRepository;
import com.brcubg.demoSpringProject.response.RoleResponse.RoleQueryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleDao roleDao, RoleRepository roleRepository) {
        this.roleDao = roleDao;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleQueryResponse> getAllRoles(String roleName) {
        List<Role> roles = roleDao.findRolesByRoleName(roleName);
        return roles.stream().map(role -> {
            RoleQueryResponse response = new RoleQueryResponse();
            response.setId(role.getId());
            response.setRoleName(role.getRoleName());
            return response;
        }).toList();
    }

    @Override
    public RoleQueryResponse findRoleById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        RoleQueryResponse response = null;
        if(role.isPresent()){
            response = new RoleQueryResponse();
            response.setId(role.get().getId());
            response.setRoleName(role.get().getRoleName());
        }
        return response;
    }
}
