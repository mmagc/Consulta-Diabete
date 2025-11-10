package br.com.consultadiabete.rest.controller;

import br.com.consultadiabete.dto.users.CreateUserDto;
import br.com.consultadiabete.dto.users.UserResponseDTO;
import br.com.consultadiabete.entities.User;
import br.com.consultadiabete.mappers.UserStructMapper;
import br.com.consultadiabete.repositories.UserJpaRepository;
import br.com.consultadiabete.usecases.user.CreateUserUsecase;
import br.com.consultadiabete.usecases.user.FindAllUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final CreateUserUsecase createUserUsecase;
    private final FindAllUsersUseCase findAllUsersUseCase;

    @PostMapping("/create")
    public void createUser(@RequestBody CreateUserDto request){
        createUserUsecase.execute(request);
    }

    @GetMapping("/get")
    public List<UserResponseDTO> findAll() {
        return findAllUsersUseCase.execute();
    }
}
