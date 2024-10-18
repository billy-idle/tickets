package io.bootify.my_oracle_app.incidente;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;


@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IncidenteMapper {

    IncidenteDTO updateIncidenteDTO(Incidente incidente, @MappingTarget IncidenteDTO incidenteDTO);

    @Mapping(target = "id", ignore = true)
    Incidente updateIncidente(IncidenteDTO incidenteDTO, @MappingTarget Incidente incidente);

}
