package co.com.Test.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarUsuario implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/2").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
        );

    }
    public static EliminarUsuario eliminarUsuario() { return instrumented(EliminarUsuario.class);}
}
