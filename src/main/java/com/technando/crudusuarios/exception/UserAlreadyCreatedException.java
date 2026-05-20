package com.technando.crudusuarios.exception;

public class UserAlreadyCreatedException extends RuntimeException{
    public UserAlreadyCreatedException(String email){
        super("Usuário com e-mail " + email + " já existe.");
    }
}
