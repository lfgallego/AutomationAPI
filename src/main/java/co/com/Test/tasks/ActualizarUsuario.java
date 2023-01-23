package co.com.Test.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ActualizarUsuario implements Task {
    byte[] bytes = (Files.readAllBytes(Paths.get("./src/test/resources/files/Actualizar.json")));

    public ActualizarUsuario() throws IOException {

    }
    String body = new String(bytes);
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Patch.to("/2").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON).body(body))
        );
    }
    public static ActualizarUsuario actualizarUsuario(){
        return instrumented(ActualizarUsuario.class);
    }
}
