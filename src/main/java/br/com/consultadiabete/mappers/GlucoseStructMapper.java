package br.com.consultadiabete.mappers;

import br.com.consultadiabete.dto.glucoseData.CreateGlucoseDto;
import br.com.consultadiabete.entities.GlucoseData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GlucoseStructMapper {
    @Mapping(target = "id",          ignore = true)
    @Mapping(target = "createdAt",   ignore = true)
    @Mapping(target = "updatedAt",   ignore = true)
    @Mapping(source = "dto.glucose",           target = "glucose")
    @Mapping(source = "dto.meassurementTime",   target = "meassurementTime")
    @Mapping(source = "dto.userId",            target = "user.id")
    GlucoseData toEntity(CreateGlucoseDto dto);
}
