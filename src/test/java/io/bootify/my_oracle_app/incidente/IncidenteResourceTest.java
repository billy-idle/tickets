package io.bootify.my_oracle_app.incidente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.bootify.my_oracle_app.config.BaseIT;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;


public class IncidenteResourceTest extends BaseIT {

    @Test
    @Sql("/data/incidenteData.sql")
    void getAllIncidentes_success() {
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                .when()
                    .get("/api/incidentes")
                .then()
                    .statusCode(HttpStatus.OK.value())
                    .body("page.totalElements", Matchers.equalTo(2))
                    .body("content.get(0).id", Matchers.equalTo(1000));
    }

    @Test
    @Sql("/data/incidenteData.sql")
    void getAllIncidentes_filtered() {
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                .when()
                    .get("/api/incidentes?filter=1001")
                .then()
                    .statusCode(HttpStatus.OK.value())
                    .body("page.totalElements", Matchers.equalTo(1))
                    .body("content.get(0).id", Matchers.equalTo(1001));
    }

    @Test
    @Sql("/data/incidenteData.sql")
    void getIncidente_success() {
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                .when()
                    .get("/api/incidentes/1000")
                .then()
                    .statusCode(HttpStatus.OK.value())
                    .body("ticket", Matchers.equalTo("Consectetuer adipiscing."));
    }

    @Test
    void getIncidente_notFound() {
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                .when()
                    .get("/api/incidentes/1666")
                .then()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .body("code", Matchers.equalTo("NOT_FOUND"));
    }

    @Test
    void createIncidente_success() {
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .body(readResource("/requests/incidenteDTORequest.json"))
                .when()
                    .post("/api/incidentes")
                .then()
                    .statusCode(HttpStatus.CREATED.value());
        assertEquals(1, incidenteRepository.count());
    }

    @Test
    void createIncidente_missingField() {
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .body(readResource("/requests/incidenteDTORequest_missingField.json"))
                .when()
                    .post("/api/incidentes")
                .then()
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .body("code", Matchers.equalTo("VALIDATION_FAILED"))
                    .body("fieldErrors.get(0).property", Matchers.equalTo("ticket"))
                    .body("fieldErrors.get(0).code", Matchers.equalTo("REQUIRED_NOT_NULL"));
    }

    @Test
    @Sql("/data/incidenteData.sql")
    void updateIncidente_success() {
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .body(readResource("/requests/incidenteDTORequest.json"))
                .when()
                    .put("/api/incidentes/1000")
                .then()
                    .statusCode(HttpStatus.OK.value());
        assertEquals("Sed diam voluptua.", incidenteRepository.findById(((long)1000)).orElseThrow().getTicket());
        assertEquals(2, incidenteRepository.count());
    }

    @Test
    @Sql("/data/incidenteData.sql")
    void deleteIncidente_success() {
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                .when()
                    .delete("/api/incidentes/1000")
                .then()
                    .statusCode(HttpStatus.NO_CONTENT.value());
        assertEquals(1, incidenteRepository.count());
    }

}
