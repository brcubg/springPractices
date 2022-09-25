package com.brcubg.demoSpringProject.controller.RoleController;

import com.brcubg.demoSpringProject.constant.ApiPaths;
import com.brcubg.demoSpringProject.request.RoleRequest.RoleQueryRequest;
import com.brcubg.demoSpringProject.response.RoleResponse.RoleQueryResponse;
import com.brcubg.demoSpringProject.service.RoleService.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(path = ApiPaths.RolePaths.QUERY_PATH)
    public List<RoleQueryResponse> getAllRoles(@RequestBody RoleQueryRequest request){
        return roleService.getAllRoles(request.getRoleName());
    }

    @GetMapping(path = ApiPaths.RolePaths.GET_ROLE_PATH)
    public RoleQueryResponse findRoleById(@PathVariable Long id) {
        return roleService.findRoleById(id);
    }
}
