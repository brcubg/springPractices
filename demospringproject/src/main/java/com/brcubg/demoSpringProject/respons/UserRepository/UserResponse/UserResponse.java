package com.brcubg.demoSpringProject.respons.UserRepository.UserResponse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserResponse {

    @JsonIgnore
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private Long role;

    @NotNull
    private String password;

}
