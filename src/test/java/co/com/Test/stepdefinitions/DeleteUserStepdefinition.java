package co.com.Test.stepdefinitions;

import co.com.Test.tasks.EliminarUsuario;
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

public class DeleteUserStepdefinition {
    private EnvironmentVariables environmentVariables;
    @Before
    public void initialConfiguration() {
        setTheStage(new OnlineCast());
    }
    @Given("since you need to delete  a user")
    public void sinceYouNeedToDeleteAUser() {
        String vpcEndpoint = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("url");
        theActorCalled("actor").whoCan(
                CallAnApi.at(vpcEndpoint));
    }
    @When("User information is sent for the delte")
    public void userInformationIsSentForTheDelte() {
        theActorInTheSpotlight().attemptsTo(EliminarUsuario.eliminarUsuario());
        System.out.println(lastResponse().prettyPrint());
    }
    @Then("User delete is successful")
    public void userDeleteIsSuccessful() {
        Ensure.that(lastResponse().statusCode()).isEqualTo(204);
    }

}
