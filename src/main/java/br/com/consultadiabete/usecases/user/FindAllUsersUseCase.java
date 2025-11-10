package br.com.consultadiabete.usecases.user;

import br.com.consultadiabete.Config.annotations.UseCase;
import br.com.consultadiabete.dto.users.UserResponseDTO;
import br.com.consultadiabete.mappers.UserStructMapper;
import br.com.consultadiabete.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllUsersUseCase {

    private final UserJpaRepository userJpaRepository;
    private final UserStructMapper userStructMapper;

    public List<UserResponseDTO> execute() {
        return userJpaRepository
                .findAll()
                .stream()
                .map(userStructMapper::toResponseDTO)
                .toList();
    }
}
