package io.bootify.my_oracle_app.incidente;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;


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

    @Size(max = 255)
    private String codigoDANE;

    @NotNull
    @Size(max = 255)
    private String respuestaAPI;

    @NotNull
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
