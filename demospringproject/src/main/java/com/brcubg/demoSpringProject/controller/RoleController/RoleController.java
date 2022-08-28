package com.brcubg.demoSpringProject.controller.RoleController;

import com.brcubg.demoSpringProject.request.RoleRequest.RoleQueryRequest;
import com.brcubg.demoSpringProject.response.RoleResponse.RoleQueryResponse;
import com.brcubg.demoSpringProject.service.RoleService.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    final private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    private List<RoleQueryResponse> getAllRoles(@RequestBody RoleQueryRequest request){
        return roleService.getAllRoles(request.getRoleName());
    }
}
