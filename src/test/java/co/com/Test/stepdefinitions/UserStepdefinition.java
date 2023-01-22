package co.com.Test.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class UserStepdefinition {

    private EnvironmentVariables environmentVariables;
    @Before
    public void initialConfiguration() {
        setTheStage(new OnlineCast());
    }
}
