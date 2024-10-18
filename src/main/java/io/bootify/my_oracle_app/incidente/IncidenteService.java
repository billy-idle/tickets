package io.bootify.my_oracle_app.incidente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IncidenteService {

    Page<IncidenteDTO> findAll(String filter, Pageable pageable);

    IncidenteDTO get(Long id);

    Long create(IncidenteDTO incidenteDTO);

    void update(Long id, IncidenteDTO incidenteDTO);

    void delete(Long id);

}
