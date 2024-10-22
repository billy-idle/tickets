package io.bootify.my_oracle_app.incidente;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
public class IncidenteDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("Ticket")
    private String ticket;

    @JsonProperty("EstacionBase")
    private String estacionBase;

    @JsonProperty("EstadoEB")
    private String estadoEB;

    @JsonProperty("InicioFalla")
    private LocalDateTime inicioFalla;

    @JsonProperty("FechaHoraReporte")
    private LocalDateTime fechaHoraReporte;

    @JsonProperty("FinFalla")
    private LocalDateTime finFalla;

    @JsonProperty("Tecnologia")
    private String tecnologia;

    @JsonProperty("Municipio")
    private String municipio;

    @JsonProperty("Departamento")
    private String departamento;

    @JsonProperty("CodigoDANE")
    private String codigoDane;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private String respuestaAPI;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private LocalDateTime fechaRespuestaAPI;
}
