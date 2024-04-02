package com.scaler.userservice.dtos;

import com.scaler.userservice.models.Address;
import com.scaler.userservice.models.Role;
import com.scaler.userservice.models.User;
import jakarta.persistence.Embedded;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String email;
    private String username;
    @ManyToMany
    private List<Role> role;
    //@Embedded
    private String name;

    public static UserDto from(User user){
        UserDto userDto = new UserDto();
        userDto.email = user.getEmail();
   //     userDto.username = user.getUsername();
   //     userDto.role = user.getRole();
        userDto.name = user.getName();

        return userDto;
    }
}
