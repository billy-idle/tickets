package io.bootify.my_oracle_app.incidente;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INCIDENTE")
class Incidente {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "TICKET", nullable = false)
    private String ticket;

    @Column(name = "ESTACIONBASE", nullable = false)
    private String estacionBase;

    @Column(name = "ESTADOEB", nullable = false)
    private String estadoEB;

    @Column(name = "INICIOFALLA", nullable = false)
    private LocalDateTime inicioFalla;

    @Column(name = "FINFALLA")
    private LocalDateTime finFalla;

    @Column(name = "FECHAHORAREPORTE", nullable = false)
    private LocalDateTime fechaHoraReporte;

    @Column(name = "TECNOLOGIA", nullable = false)
    private String tecnologia;

    @Column(name = "MUNICIPIO", nullable = false)
    private String municipio;

    @Column(name = "DEPARTAMENTO", nullable = false)
    private String departamento;

    @Column(name = "CODIGODANE", nullable = false)
    private String codigoDane;

    @Column(name = "RESPUESTA_API", nullable = true)
    private String respuestaAPI;

    @Column(name = "FECHARESPUESTA_API", nullable = true)
    private LocalDateTime fechaRespuestaAPI;

    @Override
    public int hashCode() {
        return Objects.hash(id, ticket, estacionBase, estadoEB, inicioFalla, finFalla, fechaHoraReporte, tecnologia,
                            municipio, departamento, codigoDane);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Incidente incidente)) return false;
        return Objects.equals(id, incidente.id) && Objects.equals(ticket, incidente.ticket) && Objects.equals(estacionBase, incidente.estacionBase) && Objects.equals(estadoEB, incidente.estadoEB) && Objects.equals(inicioFalla, incidente.inicioFalla) && Objects.equals(finFalla, incidente.finFalla) && Objects.equals(fechaHoraReporte, incidente.fechaHoraReporte) && tecnologia == incidente.tecnologia && Objects.equals(municipio, incidente.municipio) && Objects.equals(departamento, incidente.departamento) && Objects.equals(codigoDane, incidente.codigoDane);
    }
}
