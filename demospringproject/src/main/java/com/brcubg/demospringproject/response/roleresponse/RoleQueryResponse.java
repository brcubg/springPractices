package com.brcubg.demospringproject.response.roleresponse;

import com.fasterxml.jackson.annotation.JsonIgnore;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoleQueryResponse {
    @JsonIgnore
    private Long id;

    @NotNull
    private String roleName;
}
