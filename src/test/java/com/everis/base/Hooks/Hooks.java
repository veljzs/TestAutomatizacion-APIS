package com.everis.base.Hooks;


import io.cucumber.java.BeforeStep;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Hooks.class);

    //https://www.baeldung.com/java-cucumber-hooks
    @BeforeStep
    public void beforeStep(){ //
        LOGGER.info( "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        // Configurar el escenario con un elenco de actores
        OnStage.setTheStage(new OnlineCast());
    }
}
