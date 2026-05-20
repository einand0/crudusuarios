package com.technando.crudusuarios.controller;

import com.technando.crudusuarios.dto.UserRequestDTO;
import com.technando.crudusuarios.dto.UserResponseDTO;
import com.technando.crudusuarios.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO dto){

        UserResponseDTO user = userService.createUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){

        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody @Valid  UserRequestDTO dto){

        UserResponseDTO user = userService.updateUser(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
