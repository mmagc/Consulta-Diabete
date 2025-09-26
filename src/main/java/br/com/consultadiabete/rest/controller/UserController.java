package br.com.consultadiabete.rest.controller;

import br.com.consultadiabete.dto.users.CreateUserDto;
import br.com.consultadiabete.entities.User;
import br.com.consultadiabete.mappers.UserStructMapper;
import br.com.consultadiabete.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final UserJpaRepository userJpaRepository;
    private final UserStructMapper userStructMapper;

    @PostMapping
    public void createUser(@RequestBody CreateUserDto userDto){
        User user = userStructMapper.toEntity(userDto);
        userJpaRepository.save(user);
    }

}
