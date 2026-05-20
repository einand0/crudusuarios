package com.technando.crudusuarios.Mapper;

import com.technando.crudusuarios.dto.UserRequestDTO;
import com.technando.crudusuarios.dto.UserResponseDTO;
import com.technando.crudusuarios.entity.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto){
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        return user;
    }

    public static UserResponseDTO toDTO(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
