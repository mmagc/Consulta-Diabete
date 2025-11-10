package br.com.consultadiabete.rest.controller;

import br.com.consultadiabete.dto.glucoseData.CreateGlucoseDto;
import br.com.consultadiabete.dto.glucoseData.GlucoseDataResponseDTO;
import br.com.consultadiabete.entities.GlucoseData;
import br.com.consultadiabete.mappers.GlucoseStructMapper;
import br.com.consultadiabete.repositories.GlucoseDataJpaRepository;
import br.com.consultadiabete.usecases.glucoseData.CreateGlucoseDataUseCase;
import br.com.consultadiabete.usecases.glucoseData.DeleteGlucoseUseCase;
import br.com.consultadiabete.usecases.glucoseData.FindGlucoseByIdUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/glucose")
public class GlucoseController {

    private final CreateGlucoseDataUseCase createGlucoseDataUseCase;
    private final FindGlucoseByIdUseCase findGlucoseByIdUseCase;
    private final DeleteGlucoseUseCase deleteGlucoseUseCase;


    @PostMapping("/create")
    public void createGlucoseData(@RequestBody CreateGlucoseDto  request) {
       createGlucoseDataUseCase.execute(request);
    }

    @GetMapping("/get/{id}")
    public List<GlucoseDataResponseDTO> getGlucoseDataByUser(
            @PathVariable("id") UUID userId,
            @ParameterObject
            @PageableDefault(page = 0, size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
            Pageable pageable) {

        return findGlucoseByIdUseCase.execute(userId, pageable);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGlucoseData(@PathVariable("id") UUID userId) {
        deleteGlucoseUseCase.execute(userId);
    }

}
