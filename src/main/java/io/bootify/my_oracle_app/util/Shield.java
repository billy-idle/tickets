package io.bootify.my_oracle_app.util;

import io.bootify.my_oracle_app.incidente.IncidenteDTO;
import lombok.experimental.UtilityClass;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

/**
 * Clase de utilidad que proporciona métodos para sanitizar y proteger entradas contra
 * ataques XSS (Cross-Site Scripting) utilizando la biblioteca Jsoup.
 */
@UtilityClass
public class Shield {

    /**
     * Sanitiza los campos de un objeto de tipo {@link IncidenteDTO} utilizando el método
     * de sanitización {@link #blindStr(String)} para limpiar cada campo del DTO.
     *
     * @param incidente el DTO de entrada que contiene los datos a sanitizar.
     * @return una nueva instancia de {@link IncidenteDTO} con los campos sanitizados.
     */
/*
    public static IncidenteDTO blindIncidenteDTO(IncidenteDTO incidente) {
        return IncidenteDTO.builder()
                .id(blindStr(incidente.getId()))
                .ticket(blindStr(incidente.getTicket()))
                .estacionBase(blindStr(incidente.getEstacionBase()))
                .estadoEB(blindStr(incidente.getEstadoEB()))
                .inicioFalla(blindStr(incidente.getInicioFalla()))
                .finFalla(blindStr(incidente.getFinFalla()))
                .fechaHoraReporte(blindStr(incidente.getFechaHoraReporte()))
                .tecnologia(blindStr(incidente.getTecnologia()))
                .municipio(blindStr(incidente.getMunicipio()))
                .departamento(blindStr(incidente.getDepartamento()))
                .codigoDane(blindStr(incidente.getCodigoDane()))
                .build();
    }
*/

    /**
     * Sanitiza una cadena de entrada limpiándola de elementos peligrosos utilizando una lista
     * segura (Safelist) básica. Además, reemplaza ciertas entidades HTML por sus equivalentes
     * para evitar problemas de codificación.
     *
     * @param value la cadena de entrada que debe ser sanitizada.
     * @return la cadena sanitizada y limpia.
     */
    public static String blindStr(String value) {
        String sanitizedValue = Jsoup.clean(value, Safelist.basic());
        return sanitizedValue
                .replace("&#34;", "'")
                .replace("&#43;", "+")
                .replace("&#39;", "'")
                .replace("&#61;", "=")
                .replace("&amp;", " & ")
                .replace("&#64;", "@");
    }
}
