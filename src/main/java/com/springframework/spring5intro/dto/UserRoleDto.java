package com.springframework.spring5intro.dto;

import lombok.Data;

@Data
public class UserRoleDto {

    private long userId;

    private String firstName;

    private String lastName;

    private String emailId;

    private String address;

    private String roleName;

    private String roleDescription;
}
