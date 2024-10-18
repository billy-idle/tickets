package io.bootify.my_oracle_app.incidente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Incidente {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String ticket;

    @Column(nullable = false)
    private String estacionBase;

    @Column(nullable = false)
    private String estadoEB;

    @Column(nullable = false)
    private LocalDateTime inicioFalla;

    @Column
    private LocalDateTime finFalla;

    @Column(nullable = false)
    private LocalDateTime fechaHoraReporte;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tecnologia tecnologia;

    @Column(nullable = false)
    private String municipio;

    @Column(nullable = false)
    private String departamento;

    @Column
    private String codigoDANE;

    @Column(nullable = false)
    private String respuestaAPI;

    @Column(nullable = false)
    private LocalDateTime fechaRespuestaAPI;

}
