package com.everis.base.stepDefinitions;

import com.everis.base.MascotaStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MascotaStepDef {
    @Steps
    MascotaStep mascota;

    @Given("Estoy en la tienda")
    public void estoyEnLaTienda() {
        System.out.println("Estoy en la tienda.");
    }

    @When("Hago un post de orden de mascota con id {int}, petId {int}, quantity {int}, shipDate {string}, status {string}, complete {string}")
    public void crearMascotaOrder(int id, int petId, int quantity, String shipDate, String status, String complete) {
        mascota.crearMascotaOrder(id,petId,quantity,shipDate,status, Boolean.parseBoolean(complete));
    }

    @Then("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSea(int statusCode) {
        mascota.validarCodigoRespuesta(statusCode);
    }

    @And("valido el body del response tiene {string} con valor {int}")
    public void validoElBodyDelResponseTieneConValor(String key, int expextedValue) {
        mascota.validarBodyResponse(key, expextedValue);
    }

    @When("consulto la mascota de ID {int}")
    public void consultoLaMascotaDeID(int arg0) {
        mascota.consultaMascota(arg0);
    }


    @And("valido el body del response de consulta tiene {string} con valor {int}")
    public void validoElBodyDelResponseDeConsultaTieneConValor(String key, int expectedValue) {
        mascota.validarBodyResponseConsulta(key,expectedValue);
    }
}
