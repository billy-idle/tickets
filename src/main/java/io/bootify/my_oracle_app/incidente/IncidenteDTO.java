package io.bootify.my_oracle_app.incidente;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
public class IncidenteDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String ticket;

    @NotNull
    @Size(max = 255)
    private String estacionBase;

    @NotNull
    @Size(max = 255)
    private String estadoEB;

    @NotNull
    private LocalDateTime inicioFalla;

    private LocalDateTime finFalla;

    @NotNull
    private LocalDateTime fechaHoraReporte;

    @NotNull
    @Size(max = 2)
    private String tecnologia;

    @NotNull
    @Size(max = 255)
    private String municipio;

    @NotNull
    @Size(max = 255)
    private String departamento;

    @Size(max = 255)
    private String codigoDANE;

    @NotNull
    @Size(max = 255)
    @EqualsAndHashCode.Exclude
    private String respuestaAPI;

    @NotNull
    @EqualsAndHashCode.Exclude
    private LocalDateTime fechaRespuestaAPI;
}
