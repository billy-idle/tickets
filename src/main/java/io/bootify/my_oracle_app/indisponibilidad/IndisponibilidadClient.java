package io.bootify.my_oracle_app.indisponibilidad;

import io.bootify.my_oracle_app.incidente.IncidenteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "indisponibilidad")
public interface IndisponibilidadClient {
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> reportarIncidente(@RequestBody IncidenteDTO incidente);
}

