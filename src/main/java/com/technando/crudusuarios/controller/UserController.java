package com.technando.crudusuarios.controller;

import com.technando.crudusuarios.dto.UserRequestDTO;
import com.technando.crudusuarios.dto.UserResponseDTO;
import com.technando.crudusuarios.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Tag(
        name = "Users",
        description = "Endpoints responsáveis pelo gerenciamento de usuários"
)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST - CRIAR USUARIO
    @Operation(summary = "Criar um usuário",
                description = "Endpoint responsável por cadastrar um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO dto){

        UserResponseDTO user = userService.createUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // GET - BUSCAR TODOS OS USUARIOS
    @Operation(summary = "Buscar todos os usuários",
                description = "Endpoint responsável por buscar todos os usuários cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna todos os usuários com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){

        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    // GET - BUSCAR TODOS OS USUÁRIOS COM PAGINAÇÃO
    @GetMapping("/paginacao")
    public ResponseEntity<Page<UserResponseDTO>> findAllPaginacao(@RequestParam("page") int page, @RequestParam("size") int size){
        return ResponseEntity.ok().body(userService.findAllPaginacao(page, size));
    }


    // GET - BUSCAR USUÁRIO PELO ID
    @Operation(summary = "Buscar o usuário pelo ID",
                description = "Endpoint responsável por buscar um usuário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable @Parameter(description = "ID do usuário") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    // DELETE - DELETAR USUÁRIO
    @Operation(summary = "Deletar o usuário pelo ID",
                description = "Endpoint responsável por deletar um usuário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable @Parameter(description = "ID do usuário") Long id){
        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    // PUT - ALTERAR DADOS DO USUÁRIO
    @Operation(summary = "Alterar os dados do usuário",
                description = "Endpoint responsável por alterar os dados do usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados do usuário alterados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Falha na alteração dos dados do usuário")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable @Parameter(description = "ID do usuário") Long id, @RequestBody @Valid  UserRequestDTO dto){

        UserResponseDTO user = userService.updateUser(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
