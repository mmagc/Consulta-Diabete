package br.com.consultadiabete.usecases.glucoseData;

import br.com.consultadiabete.Config.annotations.UseCase;
import br.com.consultadiabete.repositories.GlucoseDataJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class DeleteGlucoseUseCase {

    private final GlucoseDataJpaRepository glucoseDataJpaRepository;

    public void execute(UUID id){
        glucoseDataJpaRepository.deleteById(id);
    }
}
