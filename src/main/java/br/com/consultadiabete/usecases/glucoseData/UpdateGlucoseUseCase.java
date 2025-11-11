package br.com.consultadiabete.usecases.glucoseData;

import br.com.consultadiabete.Config.annotations.UseCase;
import br.com.consultadiabete.dto.glucoseData.UpdateGlucoseDto;
import br.com.consultadiabete.entities.GlucoseData;
import br.com.consultadiabete.repositories.GlucoseDataJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class UpdateGlucoseUseCase {

    private final GlucoseDataJpaRepository glucoseDataJpaRepository;

    public void execute(UUID glucoseId, UpdateGlucoseDto input) {
        var glucoseData = glucoseDataJpaRepository.findById(glucoseId).orElseThrow(() -> new EntityNotFoundException(String.valueOf(GlucoseData.class)));


        glucoseData.setGlucose(input.getGlucose());
        glucoseData.setMeassurementTime(input.getMeassurementTime());

        glucoseDataJpaRepository.save(glucoseData);
    }
}
