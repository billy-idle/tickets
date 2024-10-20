package io.bootify.my_oracle_app.incidente;

import io.bootify.my_oracle_app.util.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;


@Service
public class IncidenteService {

    private final IncidenteRepository incidenteRepository;
    private final IncidenteMapper incidenteMapper;

    public IncidenteService(final IncidenteRepository incidenteRepository,
                            final IncidenteMapper incidenteMapper) {
        this.incidenteRepository = incidenteRepository;
        this.incidenteMapper = incidenteMapper;
    }

    public Page<IncidenteDTO> findAll(final String filter, final Pageable pageable) {
        Page<Incidente> page;
        if (filter != null) {
            Long longFilter = null;
            try {
                longFilter = Long.parseLong(filter);
            } catch (final NumberFormatException numberFormatException) {
                // keep null - no parseable input
            }
            page = incidenteRepository.findAllById(longFilter, pageable);
        }
        else {
            page = incidenteRepository.findAll(pageable);
        }
        return new PageImpl<>(page.getContent()
                                  .stream()
                                  .map(incidente -> incidenteMapper.updateIncidenteDTO(incidente, new IncidenteDTO()))
                                  .toList(),
                              pageable, page.getTotalElements());
    }

    public IncidenteDTO get(final Long id) {
        return incidenteRepository.findById(id)
                                  .map(incidente -> incidenteMapper.updateIncidenteDTO(incidente, new IncidenteDTO()))
                                  .orElseThrow(NotFoundException::new);
    }


    public void update(final Long id, final IncidenteDTO incidenteDTO) {
        final Incidente incidente = incidenteRepository.findById(id)
                                                       .orElseThrow(NotFoundException::new);
        incidenteMapper.updateIncidente(incidenteDTO, incidente);
        incidenteRepository.save(incidente);
    }

    public Page<IncidenteDTO> findAllPendientePorReportar(Pageable pageable, LocalDateTime fecha) {
        fecha = Objects.nonNull(fecha) ? fecha : LocalDateTime.now();
        LocalDateTime startOfDay = fecha.with(LocalTime.MIN);
        LocalDateTime endOfDay = fecha.with(LocalTime.MAX);

        Page<Incidente> page = incidenteRepository.findAllByRespuestaAPIIsNullAndFechaHoraReporteIsBetween(pageable,
                                                                                                           startOfDay
                , endOfDay);

        return new PageImpl<>(page.getContent()
                                  .stream()
                                  .map(incidente -> incidenteMapper.updateIncidenteDTO(incidente, new IncidenteDTO()))
                                  .toList(),
                              pageable, page.getTotalElements());
    }

    public List<IncidenteDTO> findAllPendientePorReportar(LocalDateTime fecha) {
        fecha = Objects.nonNull(fecha) ? fecha : LocalDateTime.now();
        LocalDateTime startOfDay = fecha.with(LocalTime.MIN);
        LocalDateTime endOfDay = fecha.with(LocalTime.MAX);

        List<Incidente> page = incidenteRepository.findAllByRespuestaAPIIsNullAndFechaHoraReporteIsBetween(startOfDay , endOfDay);

        return page.stream().map(incidente -> incidenteMapper.updateIncidenteDTO(incidente, new IncidenteDTO())).toList();
    }
}
