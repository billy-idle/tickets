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

    public void reportar(){
        List<IncidenteDTO> incidentes = incidenteService.findAllPendientePorReportar(null);
        for (IncidenteDTO incidente : incidentes){
            reportarIncidente(incidente);
        }
    }

    private String reportarIncidente(IncidenteDTO incidente) throws FeignException {
        ResponseEntity<String> exchange2 = indisponibilidadClient.reportarIncidente(incidente);
        return exchange2.getBody();
    }
}
