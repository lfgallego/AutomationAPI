package co.com.Test.stepdefinitions;

import co.com.Test.tasks.ActualizarUsuario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ActualizarUsuarioStepdefinition {
    private EnvironmentVariables environmentVariables;
    @Before
    public void initialConfiguration() {
        setTheStage(new OnlineCast());
    }
    @Given("since you need to update  a user")
    public void sinceYouNeedToUpdateAUser() {
        String vpcEndpoint = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("url");
        theActorCalled("actor").whoCan(
                CallAnApi.at(vpcEndpoint));
    }
    @When("User information is sent for the update")
    public void userInformationIsSentForTheUpdate() {
theActorInTheSpotlight().attemptsTo(ActualizarUsuario.actualizarUsuario());
        System.out.println(lastResponse().prettyPrint());
    }
    @Then("User update is successful")
    public void userUpdateIsSuccessful() {
        Ensure.that(lastResponse().statusCode()).isEqualTo(200);
        String job = lastResponse().jsonPath().getString("job");
        System.out.println(job);
    }
}
