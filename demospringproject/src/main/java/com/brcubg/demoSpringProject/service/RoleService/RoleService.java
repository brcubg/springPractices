package com.brcubg.demoSpringProject.service.RoleService;

import com.brcubg.demoSpringProject.response.RoleResponse.RoleQueryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<RoleQueryResponse> getAllRoles(String roleName);
    RoleQueryResponse findRoleById(Long id);
}
