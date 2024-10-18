package io.bootify.my_oracle_app.incidente;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
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
    private Tecnologia tecnologia;

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
    private String respuestaAPI;

    @NotNull
    private LocalDateTime fechaRespuestaAPI;

}
