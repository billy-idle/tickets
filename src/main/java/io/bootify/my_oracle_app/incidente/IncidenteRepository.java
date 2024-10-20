package io.bootify.my_oracle_app.incidente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


interface IncidenteRepository extends JpaRepository<Incidente, Long> {

    Page<Incidente> findAllById(Long id, Pageable pageable);

    Page<Incidente> findAllByRespuestaAPIIsNullAndFechaHoraReporteIsBetween(Pageable pageable,
                                                                            LocalDateTime startOfDay,
                                                                            LocalDateTime endOfDay);

    List<Incidente> findAllByRespuestaAPIIsNullAndFechaHoraReporteIsBetween(LocalDateTime startOfDay,
                                                                            LocalDateTime endOfDay);
}
