package com.technando.crudusuarios.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id){
        super("Usuário com id " + id + " não encontrado.");
    }
}
