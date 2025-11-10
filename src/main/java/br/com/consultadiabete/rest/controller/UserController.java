package br.com.consultadiabete.rest.controller;

import br.com.consultadiabete.dto.users.CreateUserDto;
import br.com.consultadiabete.dto.users.UserResponseDTO;
import br.com.consultadiabete.usecases.user.CreateUserUseCase;
import br.com.consultadiabete.usecases.user.FindAllUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final CreateUserUseCase createUserUsecase;
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
