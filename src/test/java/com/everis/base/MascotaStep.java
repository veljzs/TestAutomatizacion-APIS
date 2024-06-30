package com.everis.base;

import com.everis.base.models.Mascota;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class MascotaStep {
    private String URL_BASE = "https://petstore.swagger.io/v2";

    @Step("Crear orden de una nueva mascota")
    public void crearMascotaOrder(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        String jsonBody = "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"petId\": " + petId + ",\n" +
                "  \"quantity\": " + quantity + ",\n" +
                "  \"shipDate\": \"" + shipDate + "\",\n" +
                "  \"status\": \"" + status + "\",\n" +
                "  \"complete\": " + complete + "\n" +
                "}";
        SerenityRest.given()
                .baseUri(URL_BASE)
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body(jsonBody)
                .log().all()
                .post("store/order/")
                .then()
                .log().all()
        ;

    }

    @Step("Validar el body del response")
    public void validarBodyResponse(String key, int expectedValue) {
        given()
                .then()
                .body(key, equalTo(expectedValue))
        ;

        System.out.println("1scenario body response: " +expectedValue);
    }



    @Step("consulto la orden de mascota de ID")
    public void consultaMascota(int id) {
        Mascota mascota =
                given()
                        .baseUri(URL_BASE)
                        .log()
                        .all()
                        .when()
                        .get("store/order/" + id)
                        //.then()
                        //.log().all()
                        .as(Mascota.class);

        System.out.println("OUT - id " + mascota.getId());
        System.out.println("OUT - petId " + mascota.getPetId());


    }

    @Step("Validar el código de respuesta sea {0}")
    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
        System.out.println("paso validacion 200");
    }

    @Step("Validar el body del response para consulta")
    public void validarBodyResponseConsulta(String key, int expectedValue) {
        restAssuredThat(response -> response.body(key, equalTo(expectedValue)));
    }
}