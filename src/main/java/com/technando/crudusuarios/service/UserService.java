package com.technando.crudusuarios.service;

import com.technando.crudusuarios.Mapper.UserMapper;
import com.technando.crudusuarios.dto.UserRequestDTO;
import com.technando.crudusuarios.dto.UserResponseDTO;
import com.technando.crudusuarios.entity.User;
import com.technando.crudusuarios.exception.UserAlreadyCreatedException;
import com.technando.crudusuarios.exception.UserNotFoundException;
import com.technando.crudusuarios.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CRIAR USUÁRIO
    public UserResponseDTO createUser(UserRequestDTO dto){
        Optional<User> user = userRepository.findByEmail(dto.email());

        if(user.isPresent()){
            throw new UserAlreadyCreatedException(dto.email());
        }

        User newUser = UserMapper.toEntity(dto);

        return UserMapper.toDTO(userRepository.save(newUser));
    }

    // BUSCAR TODOS OS USUÁRIOS
    public List<UserResponseDTO> getAllUsers(){
        return userRepository.findAll().stream().map(UserMapper::toDTO).toList();
    }

    // BUSCA USUÁRIOS COM PAGINAÇÃO
    public Page<UserResponseDTO> findAllPaginacao(int page, int size) {
        return userRepository
                .findAll(PageRequest.of(page, size))
                .map(UserMapper::toDTO);
    }

    // BUSCAR POR ID
    public UserResponseDTO getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException(id)
        );

        return UserMapper.toDTO(user);
    }

    // DELETAR USUÁRIO
    public void deleteUser(Long id){
       userRepository.deleteById(id);
    }

    // ALTERAR DADOS DO USUÁRIO
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        // valida se email já existe em outro usuário
        userRepository.findByEmail(dto.email())
                .ifPresent(existing -> {
                    if (!existing.getId().equals(id)) {
                        throw new UserAlreadyCreatedException(dto.email());
                    }
                });

        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());

        return UserMapper.toDTO(userRepository.save(user));
    }
}
