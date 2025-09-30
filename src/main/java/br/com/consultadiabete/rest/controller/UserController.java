package br.com.consultadiabete.rest.controller;

import br.com.consultadiabete.dto.users.CreateUserDto;
import br.com.consultadiabete.entities.User;
import br.com.consultadiabete.mappers.UserStructMapper;
import br.com.consultadiabete.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserJpaRepository userJpaRepository;
    private final UserStructMapper userStructMapper;

    @PostMapping("/create")
    public void createUser(@RequestBody CreateUserDto userDto){
        User user = userStructMapper.toEntity(userDto);
        userJpaRepository.save(user);
    }

    @GetMapping("/get")
    public List<User> findAll(){
        return userJpaRepository.findAll();
    }

}
