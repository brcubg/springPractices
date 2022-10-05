package com.brcubg.demospringproject.response.roleresponse;

import com.fasterxml.jackson.annotation.JsonIgnore;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleQueryResponse {
    @JsonIgnore
    private Long id;

    @NotNull
    private String roleName;
}