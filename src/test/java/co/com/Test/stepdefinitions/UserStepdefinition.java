package co.com.Test.stepdefinitions;

import co.com.Test.tasks.ConsultarUsuario;
import co.com.Test.tasks.CrearUsuario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class UserStepdefinition {

    private static Actor juan;
    private EnvironmentVariables environmentVariables;
    @Before
    public void initialConfiguration() {
        setTheStage(new OnlineCast());
    }

    @Given("User requires to create new users")
    public void userRequiresToCreateNewUsers() {
        String vpcEndpoint = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("url");
        theActorCalled("actor").whoCan(
                CallAnApi.at(vpcEndpoint));
    }
    @When("User information is sent")
    public void userInformationIsSent() {
        theActorInTheSpotlight().attemptsTo(CrearUsuario.crearUsuario());
        System.out.println(lastResponse().prettyPrint());
    }

    @Then("Successful creation response is given")
    public void successfulCreationResponseIsGiven() {
        Ensure.that(lastResponse().statusCode()).isEqualTo(201);
        String user = lastResponse().jsonPath().getString("name");
        System.out.println(user);
    }
    @Given("since you need to search for a user")
    public void sinceYouNeedToSearchForAUser() {
        String vpcEndpoint = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("url");
        theActorCalled("actor").whoCan(
                CallAnApi.at(vpcEndpoint));
    }
    @When("User information is sent for the query")
    public void userInformationIsSentForTheQuery() {
theActorInTheSpotlight().attemptsTo(ConsultarUsuario.consultarUsuario());
        System.out.println(lastResponse().prettyPrint());
    }
    @Then("User query is successful")
    public void userQueryIsSuccessful() {
        Ensure.that(lastResponse().statusCode()).isEqualTo(200);
        String total = lastResponse().jsonPath().getString("total");
        System.out.println(total);
    }

}
