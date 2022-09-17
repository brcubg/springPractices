package com.brcubg.demoSpringProject.request.UserRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserCreateRequest {

    private String userName;

    private String password;

    private Long role;
}
