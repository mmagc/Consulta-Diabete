package br.com.consultadiabete.rest.controller;

import br.com.consultadiabete.dto.glucoseData.CreateGlucoseDto;
import br.com.consultadiabete.dto.glucoseData.GlucoseDataResponseDTO;
import br.com.consultadiabete.entities.GlucoseData;
import br.com.consultadiabete.mappers.GlucoseStructMapper;
import br.com.consultadiabete.repositories.GlucoseDataJpaRepository;
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

    private final GlucoseDataJpaRepository glucoseDataJpaRepository;
    private final GlucoseStructMapper glucoseStructMapper;

    @PostMapping("/create")
    public void createGlucoseData(@RequestBody CreateGlucoseDto  glucoseDto) {
        GlucoseData glucoseData = glucoseStructMapper.toEntity(glucoseDto);
        glucoseDataJpaRepository.save(glucoseData);
    }

    @GetMapping("/get/{id}")
    public List<GlucoseDataResponseDTO> getGlucoseDataByUser(
            @PathVariable("id") UUID userId,
            @ParameterObject
            @PageableDefault(page = 0, size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
            Pageable pageable) {

        return glucoseDataJpaRepository
                .findPageByUserIdFetchUser(userId, pageable)
                .map(glucoseStructMapper::toResponseDTO)
                .getContent();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGlucoseData(@PathVariable("id") UUID userId) {
        glucoseDataJpaRepository.deleteById(userId);
    }

}
