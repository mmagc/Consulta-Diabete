package br.com.consultadiabete.rest.controller;

import br.com.consultadiabete.dto.glucoseData.CreateGlucoseDto;
import br.com.consultadiabete.entities.GlucoseData;
import br.com.consultadiabete.mappers.GlucoseStructMapper;
import br.com.consultadiabete.repositories.GlucoseDataJpaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
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
    public Page<GlucoseData> getGlucoseDataByUser(@PathVariable UUID id, @RequestBody @Valid Pageable pageable) {
        return glucoseDataJpaRepository.findByUser_Id(id, pageable);
    }
}
