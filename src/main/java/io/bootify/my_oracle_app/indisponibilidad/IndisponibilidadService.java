package io.bootify.my_oracle_app.indisponibilidad;

import feign.FeignException;
import io.bootify.my_oracle_app.incidente.IncidenteDTO;
import io.bootify.my_oracle_app.incidente.IncidenteService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Getter
@Setter
@Service
@ToString
@RequiredArgsConstructor
public class IndisponibilidadService {
    private final IndisponibilidadClient indisponibilidadClient;
    private final IncidenteService incidenteService;

    public void reportar() {
        Instant start = Instant.now();
        List<IncidenteDTO> incidentes = incidenteService.findAllPendientePorReportar(null);
        for (IncidenteDTO incidente : incidentes) {
            try {
                ResponseEntity<String> response = reportarIncidente(incidente);
                log.info(response.getBody());
                incidente.setRespuestaAPI(response.getBody());
                incidente.setFechaRespuestaAPI(LocalDateTime.now());
            }catch (FeignException.BadRequest e){
                log.error("Bad Request: {}, Incidente id {}", e.contentUTF8(), incidente.getId());
                incidente.setRespuestaAPI(e.contentUTF8());
                incidente.setFechaRespuestaAPI(LocalDateTime.now());
            }
        }
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toSeconds();
        log.info("Elapsed time: {}", timeElapsed);

    }

    public ResponseEntity<String> reportarIncidente(IncidenteDTO incidente) throws FeignException {
        ResponseEntity<String> response = indisponibilidadClient.reportarIncidente(incidente);
        return response;
    }
}
