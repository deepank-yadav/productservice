package com.scaler.productservicedecmwfeve.dto;

import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String email;
    private String username;
    private List<Role> role;
    private String name;
}
