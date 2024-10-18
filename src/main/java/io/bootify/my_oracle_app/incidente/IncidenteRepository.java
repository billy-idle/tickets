package io.bootify.my_oracle_app.incidente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IncidenteRepository extends JpaRepository<Incidente, Long> {

    Page<Incidente> findAllById(Long id, Pageable pageable);

}
