package br.com.consultadiabete.usecases.user;

import br.com.consultadiabete.Config.annotations.UseCase;
import br.com.consultadiabete.dto.users.CreateUserDto;
import br.com.consultadiabete.entities.User;
import br.com.consultadiabete.mappers.UserStructMapper;
import br.com.consultadiabete.repositories.UserJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

@UseCase
@Slf4j
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserJpaRepository userJpaRepository;
    private final UserStructMapper userStructMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(CreateUserDto input) {
        validate(input);

        User user = userStructMapper.toEntity(input);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // <- BCrypt aqui
        userJpaRepository.save(user);
    }

    private void validate(CreateUserDto input) {
        if (userJpaRepository.findByEmail(input.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já cadastrado");
        }
    }

}
