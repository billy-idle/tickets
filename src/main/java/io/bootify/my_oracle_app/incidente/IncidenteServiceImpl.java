package io.bootify.my_oracle_app.incidente;

import io.bootify.my_oracle_app.util.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class IncidenteServiceImpl implements IncidenteService {

    private final IncidenteRepository incidenteRepository;
    private final IncidenteMapper incidenteMapper;

    public IncidenteServiceImpl(final IncidenteRepository incidenteRepository,
            final IncidenteMapper incidenteMapper) {
        this.incidenteRepository = incidenteRepository;
        this.incidenteMapper = incidenteMapper;
    }

    @Override
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
        } else {
            page = incidenteRepository.findAll(pageable);
        }
        return new PageImpl<>(page.getContent()
                .stream()
                .map(incidente -> incidenteMapper.updateIncidenteDTO(incidente, new IncidenteDTO()))
                .toList(),
                pageable, page.getTotalElements());
    }

    @Override
    public IncidenteDTO get(final Long id) {
        return incidenteRepository.findById(id)
                .map(incidente -> incidenteMapper.updateIncidenteDTO(incidente, new IncidenteDTO()))
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Long create(final IncidenteDTO incidenteDTO) {
        final Incidente incidente = new Incidente();
        incidenteMapper.updateIncidente(incidenteDTO, incidente);
        return incidenteRepository.save(incidente).getId();
    }

    @Override
    public void update(final Long id, final IncidenteDTO incidenteDTO) {
        final Incidente incidente = incidenteRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        incidenteMapper.updateIncidente(incidenteDTO, incidente);
        incidenteRepository.save(incidente);
    }

    @Override
    public void delete(final Long id) {
        incidenteRepository.deleteById(id);
    }

}
