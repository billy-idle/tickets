package io.bootify.my_oracle_app.indisponibilidad;

import feign.FeignException;
import io.bootify.my_oracle_app.incidente.IncidenteDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Slf4j
@Aspect
@Component
class IndisponibilidadLoggingAspect {

    // 200
    @AfterReturning(value = "execution(* io.bootify.my_oracle_app.indisponibilidad.IndisponibilidadService.reportar(*))", returning = "response")
    public void reportarIncidenteDTOLogOkResponse(final JoinPoint joinPoint, final String response) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        log.debug("IncidenteDTO: {}", incidente);
        log.debug("response: {}", response);
    }

    // 400
    @AfterThrowing(value = "execution(* io..indisponibilidad.IndisponibilidadService.reportar(*))", throwing = "e")
    public void reportarIncidenteDTOThrowsBadRequest(final JoinPoint joinPoint,
                                                  final FeignException.BadRequest e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        log.error("IncidenteDTO: {}", incidente);
        String body = e.contentUTF8();
        log.error("error: {}, response: {}, id IncidenteDTO: {}", HttpStatus.BAD_REQUEST, body, incidente.getId());
    }

    // 401
    @AfterThrowing(value = "execution(* io..indisponibilidad.IndisponibilidadService.reportar(*))", throwing = "e")
    public void reportarIncidenteDTOThrowsUnauthorized(final JoinPoint joinPoint, final FeignException.Unauthorized e) {
        String body = e.contentUTF8();
        log.error("error: {}, response: {}", HttpStatus.UNAUTHORIZED, body);
    }

    // 403
    @AfterThrowing(value = "execution(* io..indisponibilidad.IndisponibilidadService.reportar(*))", throwing = "e")
    public void reportarIncidenteDTOThrowsForbidden(final JoinPoint joinPoint, final FeignException.Forbidden e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        log.error("IncidenteDTO: {}", incidente);
        String body = e.contentUTF8();
        log.error("error: {}, response: {}, id IncidenteDTO: {}", HttpStatus.FORBIDDEN, body, incidente.getId());
    }

    // 404
    @AfterThrowing(value = "execution(* io..indisponibilidad.IndisponibilidadService.reportar(*))", throwing = "e")
    public void reportarIncidenteDTOThrowsNotFound(final JoinPoint joinPoint, final FeignException.NotFound e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        log.error("IncidenteDTO: {}", incidente);
        String body = e.contentUTF8();
        log.error("error: {}, response: {}, id IncidenteDTO: {}", HttpStatus.NOT_FOUND, body, incidente.getId());
    }

    // 405
    @AfterThrowing(value = "execution(* io..indisponibilidad.IndisponibilidadService.reportar(*))", throwing = "e")
    public void reportarIncidenteDTOThrowsMethodNotAllowed(final JoinPoint joinPoint, final FeignException.MethodNotAllowed e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        log.error("IncidenteDTO: {}", incidente);
        String body = e.contentUTF8();
        log.error("error: {}, response: {}, id IncidenteDTO: {}", HttpStatus.METHOD_NOT_ALLOWED, body, incidente.getId());
    }

    // 408
    @AfterThrowing(value = "execution(* io..indisponibilidad.IndisponibilidadService.reportar(*))", throwing = "e")
    public void reportarIncidenteDTOThrowsRequestTimeout(final JoinPoint joinPoint, final TimeoutException e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        log.error("IncidenteDTO: {}", incidente);
        String body = e.getMessage();
        log.error("error: {}, response: {}, id IncidenteDTO: {}", HttpStatus.REQUEST_TIMEOUT, body, incidente.getId());
    }

    // 500
    @AfterThrowing(value = "execution(* io..indisponibilidad.IndisponibilidadService.reportar(*))", throwing = "e")
    public void reportarIncidenteDTOThrowsInternalServerError(final JoinPoint joinPoint, final FeignException.InternalServerError e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        log.error("IncidenteDTO: {}", incidente);
        String body = e.contentUTF8();
        log.error("error: {}, response: {}, id IncidenteDTO: {}", HttpStatus.INTERNAL_SERVER_ERROR, body,
                  incidente.getId());
    }

    // 502
    @AfterThrowing(value = "execution(* io..indisponibilidad.IndisponibilidadService.reportar(*))", throwing = "e")
    public void reportarIncidenteDTOThrowsBadGateway(final JoinPoint joinPoint, final FeignException.BadGateway e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        log.error("IncidenteDTO: {}", incidente);
        String body = e.contentUTF8();
        log.error("error: {}, response: {}, id IncidenteDTO: {}", HttpStatus.BAD_GATEWAY, body, incidente.getId());
    }

    // 503
    @AfterThrowing(value = "execution(* io..indisponibilidad.IndisponibilidadService.reportar(*))", throwing = "e")
    public void reportarIncidenteDTOThrowsServiceUnavailable(final JoinPoint joinPoint, final FeignException.ServiceUnavailable e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        log.error("IncidenteDTO: {}", incidente);
        String body = e.contentUTF8();
        log.error("error: {}, response: {}, id IncidenteDTO: {}", HttpStatus.SERVICE_UNAVAILABLE, body, incidente.getId());
    }

    // 504
    @AfterThrowing(value = "execution(* io..indisponibilidad.IndisponibilidadService.reportar(*))", throwing = "e")
    public void reportarIncidenteDTOGatewayTimeout(final JoinPoint joinPoint, final FeignException.GatewayTimeout e) {
        IncidenteDTO incidente = (IncidenteDTO) joinPoint.getArgs()[0];
        log.error("IncidenteDTO: {}", incidente);
        String body = e.contentUTF8();
        log.error("error: {}, response: {}, id IncidenteDTO: {}", HttpStatus.GATEWAY_TIMEOUT, body, incidente.getId());
    }
}
