package br.com.consultadiabete.usecases.glucoseData;

import br.com.consultadiabete.Config.annotations.UseCase;
import br.com.consultadiabete.dto.glucoseData.CreateGlucoseDto;
import br.com.consultadiabete.entities.GlucoseData;
import br.com.consultadiabete.mappers.GlucoseStructMapper;
import br.com.consultadiabete.repositories.GlucoseDataJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@Slf4j
@RequiredArgsConstructor
public class CreateGlucoseDataUseCase {

    private final GlucoseDataJpaRepository glucoseDataJpaRepository;
    private final GlucoseStructMapper glucoseStructMapper;

    public void execute(CreateGlucoseDto input){
        GlucoseData glucoseData = glucoseStructMapper.toEntity(input);
        glucoseDataJpaRepository.save(glucoseData);
    }

}
