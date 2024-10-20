package io.bootify.my_oracle_app.incidente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/incidentes", produces = MediaType.APPLICATION_JSON_VALUE)
public class IncidenteResource {

    private final IncidenteService incidenteService;

    public IncidenteResource(final IncidenteService incidenteService) {
        this.incidenteService = incidenteService;
    }

    @Operation(
            parameters = {
                    @Parameter(
                            name = "page",
                            in = ParameterIn.QUERY,
                            schema = @Schema(implementation = Integer.class)
                    ),
                    @Parameter(
                            name = "size",
                            in = ParameterIn.QUERY,
                            schema = @Schema(implementation = Integer.class)
                    ),
                    @Parameter(
                            name = "sort",
                            in = ParameterIn.QUERY,
                            schema = @Schema(implementation = String.class)
                    )
            }
    )
    @GetMapping
    public ResponseEntity<Page<IncidenteDTO>> getAllIncidentes(
            @RequestParam(name = "filter", required = false) final String filter,
            @Parameter(hidden = true) @SortDefault(sort = "id") @PageableDefault(size = 20) final Pageable pageable) {
        return ResponseEntity.ok(incidenteService.findAll(filter, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidenteDTO> getIncidente(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(incidenteService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createIncidente(
            @RequestBody @Valid final IncidenteDTO incidenteDTO) {
        final Long createdId = incidenteService.create(incidenteDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateIncidente(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final IncidenteDTO incidenteDTO) {
        incidenteService.update(id, incidenteDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteIncidente(@PathVariable(name = "id") final Long id) {
        incidenteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
