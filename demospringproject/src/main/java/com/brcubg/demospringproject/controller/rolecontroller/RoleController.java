package com.brcubg.demospringproject.controller.rolecontroller;

import com.brcubg.demospringproject.constant.ApiPaths;
import com.brcubg.demospringproject.request.rolerequest.RoleQueryRequest;
import com.brcubg.demospringproject.response.roleresponse.RoleQueryResponse;
import com.brcubg.demospringproject.service.roleservice.RoleService;
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
