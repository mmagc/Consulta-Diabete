package br.com.consultadiabete.usecases.glucoseData;

import br.com.consultadiabete.Config.annotations.UseCase;
import br.com.consultadiabete.dto.glucoseData.GlucoseDataResponseDTO;
import br.com.consultadiabete.mappers.GlucoseStructMapper;
import br.com.consultadiabete.repositories.GlucoseDataJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class FindGlucoseByIdUseCase {

    private final GlucoseDataJpaRepository glucoseDataJpaRepository;
    private final GlucoseStructMapper glucoseStructMapper;

    public List<GlucoseDataResponseDTO> execute( UUID userId, Pageable pageable) {

        return glucoseDataJpaRepository
                .findPageByUserIdFetchUser(userId, pageable)
                .map(glucoseStructMapper::toResponseDTO)
                .getContent();
    }
}
