package com.brcubg.demoSpringProject.response.UserResponse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserQueryResponse {

    @JsonIgnore
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private Long role;

    @NotNull
    private String password;

    private String roleName;

}
