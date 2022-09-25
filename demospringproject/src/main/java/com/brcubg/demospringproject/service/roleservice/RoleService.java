package com.brcubg.demospringproject.service.roleservice;

import com.brcubg.demospringproject.response.roleresponse.RoleQueryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<RoleQueryResponse> getAllRoles(String roleName);
    RoleQueryResponse findRoleById(Long id);
}
