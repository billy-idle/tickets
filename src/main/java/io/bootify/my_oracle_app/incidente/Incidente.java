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


@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(final String ticket) {
        this.ticket = ticket;
    }

    public String getEstacionBase() {
        return estacionBase;
    }

    public void setEstacionBase(final String estacionBase) {
        this.estacionBase = estacionBase;
    }

    public String getEstadoEB() {
        return estadoEB;
    }

    public void setEstadoEB(final String estadoEB) {
        this.estadoEB = estadoEB;
    }

    public LocalDateTime getInicioFalla() {
        return inicioFalla;
    }

    public void setInicioFalla(final LocalDateTime inicioFalla) {
        this.inicioFalla = inicioFalla;
    }

    public LocalDateTime getFinFalla() {
        return finFalla;
    }

    public void setFinFalla(final LocalDateTime finFalla) {
        this.finFalla = finFalla;
    }

    public LocalDateTime getFechaHoraReporte() {
        return fechaHoraReporte;
    }

    public void setFechaHoraReporte(final LocalDateTime fechaHoraReporte) {
        this.fechaHoraReporte = fechaHoraReporte;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(final Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(final String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(final String departamento) {
        this.departamento = departamento;
    }

    public String getCodigoDANE() {
        return codigoDANE;
    }

    public void setCodigoDANE(final String codigoDANE) {
        this.codigoDANE = codigoDANE;
    }

    public String getRespuestaAPI() {
        return respuestaAPI;
    }

    public void setRespuestaAPI(final String respuestaAPI) {
        this.respuestaAPI = respuestaAPI;
    }

    public LocalDateTime getFechaRespuestaAPI() {
        return fechaRespuestaAPI;
    }

    public void setFechaRespuestaAPI(final LocalDateTime fechaRespuestaAPI) {
        this.fechaRespuestaAPI = fechaRespuestaAPI;
    }

}
