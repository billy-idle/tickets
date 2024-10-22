package io.bootify.my_oracle_app.indisponibilidad;

import feign.FeignException;
import io.bootify.my_oracle_app.incidente.IncidenteDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
class IndisponibilidadAuditAspect {

    private final IndisponibilidadService indisponibilidadService;
    // 200
    @AfterReturning(value = "execution(* io.bootify.my_oracle_app.indisponibilidad.IndisponibilidadClient.reportarIncidente(*)))", returning = "response")
    public void reportarIncidenteLogOkResponse(final JoinPoint joinPoint, final ResponseEntity<String> response) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        String respuestaApi = response.getStatusCode().toString();
        indisponibilidadService.agregaRespuestaApiIncidente(respuestaApi, incidente);
        log.debug("Response: {} Id Incidente: {}", incidente.getId(), response.getStatusCode());
    }

    // 400
    @AfterThrowing(value = "execution(* io.bootify.my_oracle_app.indisponibilidad.IndisponibilidadClient.reportarIncidente(*)))", throwing = "e")
    public void reportarIncidenteThrowsBadRequest(final JoinPoint joinPoint, final FeignException.BadRequest e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        String respuestaApi = HttpStatus.BAD_REQUEST + " - " + e.contentUTF8();
        indisponibilidadService.agregaRespuestaApiIncidente(respuestaApi, incidente);
        log.error("Respuesta API: {}, Id Incidente: {}", respuestaApi, incidente.getId());
    }

    // 401
    @AfterThrowing(value = "execution(* io.bootify.my_oracle_app.indisponibilidad.IndisponibilidadClient.reportarIncidente(*)))", throwing = "e")
    public void reportarIncidenteThrowsUnauthorized(final JoinPoint joinPoint, final FeignException.Unauthorized e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        String respuestaApi = HttpStatus.UNAUTHORIZED + " - " + e.contentUTF8();
        indisponibilidadService.agregaRespuestaApiIncidente(respuestaApi, incidente);
        log.error("Respuesta API: {}, Id Incidente: {}", respuestaApi, incidente.getId());
    }

    // 403
    @AfterThrowing(value = "execution(* io.bootify.my_oracle_app.indisponibilidad.IndisponibilidadClient.reportarIncidente(*)))", throwing = "e")
    public void reportarIncidenteThrowsForbidden(final JoinPoint joinPoint, final FeignException.Forbidden e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        String respuestaApi = HttpStatus.FORBIDDEN + " - " + e.contentUTF8();
        indisponibilidadService.agregaRespuestaApiIncidente(respuestaApi, incidente);
        log.error("Respuesta API: {}, Id Incidente: {}", respuestaApi, incidente.getId());
    }

    // 404
    @AfterThrowing(value = "execution(* io.bootify.my_oracle_app.indisponibilidad.IndisponibilidadClient.reportarIncidente(*)))", throwing = "e")
    public void reportarIncidenteThrowsNotFound(final JoinPoint joinPoint, final FeignException.NotFound e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        String respuestaApi = HttpStatus.NOT_FOUND + " - " + e.contentUTF8();
        indisponibilidadService.agregaRespuestaApiIncidente(respuestaApi, incidente);
        log.error("Respuesta API: {}, Id Incidente: {}", respuestaApi, incidente.getId());
    }

    // 405
    @AfterThrowing(value = "execution(* io.bootify.my_oracle_app.indisponibilidad.IndisponibilidadClient.reportarIncidente(*)))", throwing = "e")
    public void reportarIncidenteThrowsMethodNotAllowed(final JoinPoint joinPoint, final FeignException.MethodNotAllowed e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        String respuestaApi = HttpStatus.METHOD_NOT_ALLOWED + " - " + e.contentUTF8();
        indisponibilidadService.agregaRespuestaApiIncidente(respuestaApi, incidente);
        log.error("Respuesta API: {}, Id Incidente: {}", respuestaApi, incidente.getId());
    }

    // 408
    @AfterThrowing(value = "execution(* io.bootify.my_oracle_app.indisponibilidad.IndisponibilidadClient.reportarIncidente(*)))", throwing = "e")
    public void reportarIncidenteThrowsRequestTimeout(final JoinPoint joinPoint, final TimeoutException e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        String respuestaApi = HttpStatus.REQUEST_TIMEOUT + " - " + e.getMessage();
        indisponibilidadService.agregaRespuestaApiIncidente(respuestaApi, incidente);
        log.error("Respuesta API: {}, Id Incidente: {}", respuestaApi, incidente.getId());
    }

    // 500
    @AfterThrowing(value = "execution(* io.bootify.my_oracle_app.indisponibilidad.IndisponibilidadClient.reportarIncidente(*)))", throwing = "e")
    public void reportarIncidenteThrowsInternalServerError(final JoinPoint joinPoint, final FeignException.InternalServerError e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        String respuestaApi = HttpStatus.INTERNAL_SERVER_ERROR + " - " + e.contentUTF8();
        indisponibilidadService.agregaRespuestaApiIncidente(respuestaApi, incidente);
        log.error("Respuesta API: {}, Id Incidente: {}", respuestaApi, incidente.getId());
    }

    // 502
    @AfterThrowing(value = "execution(* io.bootify.my_oracle_app.indisponibilidad.IndisponibilidadClient.reportarIncidente(*)))", throwing = "e")
    public void reportarIncidenteThrowsBadGateway(final JoinPoint joinPoint, final FeignException.BadGateway e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        String respuestaApi = HttpStatus.BAD_GATEWAY + " - " + e.contentUTF8();
        indisponibilidadService.agregaRespuestaApiIncidente(respuestaApi, incidente);
        log.error("Respuesta API: {}, Id Incidente: {}", respuestaApi, incidente.getId());
    }

    // 503
    @AfterThrowing(value = "execution(* io.bootify.my_oracle_app.indisponibilidad.IndisponibilidadClient.reportarIncidente(*)))", throwing = "e")
    public void reportarIncidenteThrowsServiceUnavailable(final JoinPoint joinPoint, final FeignException.ServiceUnavailable e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        String respuestaApi = HttpStatus.SERVICE_UNAVAILABLE + " - " + e.contentUTF8();
        indisponibilidadService.agregaRespuestaApiIncidente(respuestaApi, incidente);
        log.error("Respuesta API: {}, Id Incidente: {}", respuestaApi, incidente.getId());
    }

    // 504
    @AfterThrowing(value = "execution(* io.bootify.my_oracle_app.indisponibilidad.IndisponibilidadClient.reportarIncidente(*)))", throwing = "e")
    public void reportarIncidenteGatewayTimeout(final JoinPoint joinPoint, final FeignException.GatewayTimeout e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        String respuestaApi = HttpStatus.GATEWAY_TIMEOUT + " - " + e.contentUTF8();
        indisponibilidadService.agregaRespuestaApiIncidente(respuestaApi, incidente);
        log.error("Respuesta API: {}, Id Incidente: {}", respuestaApi, incidente.getId());
    }
}
