package br.com.consultadiabete.mappers;

import br.com.consultadiabete.dto.glucoseData.CreateGlucoseDto;
import br.com.consultadiabete.dto.glucoseData.GlucoseDataResponseDTO;
import br.com.consultadiabete.entities.GlucoseData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GlucoseStructMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.meassurementTime", target = "meassurementTime")
    @Mapping(source = "dto.userId", target = "user.id")
    GlucoseData toEntity(CreateGlucoseDto dto);

    @Mapping(source = "user.name", target = "userName")
    GlucoseDataResponseDTO toResponseDTO(GlucoseData entity);
}
