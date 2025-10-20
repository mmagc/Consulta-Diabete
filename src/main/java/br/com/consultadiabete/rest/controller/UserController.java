package br.com.consultadiabete.rest.controller;

import br.com.consultadiabete.dto.users.CreateUserDto;
import br.com.consultadiabete.dto.users.UserResponseDTO;
import br.com.consultadiabete.entities.User;
import br.com.consultadiabete.mappers.UserStructMapper;
import br.com.consultadiabete.repositories.UserJpaRepository;
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

    private final UserJpaRepository userJpaRepository;
    private final UserStructMapper userStructMapper;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public void createUser(@RequestBody CreateUserDto userDto){
        if (userJpaRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já cadastrado");
        }
        User user = userStructMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // <- BCrypt aqui
        userJpaRepository.save(user);
    }

    @GetMapping("/get")
    public List<UserResponseDTO> findAll() {
        return userJpaRepository
                .findAll()
                .stream()
                .map(userStructMapper::toResponseDTO)
                .toList();
    }
}
