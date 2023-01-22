package co.com.Test.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarUsuario implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("?page=2").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
        );

    }
    public static ConsultarUsuario consultarUsuario() {

        return instrumented(ConsultarUsuario.class);
    }
}
