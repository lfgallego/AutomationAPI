package co.com.Test.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearUsuario implements Task {

    byte[] bytes = (Files.readAllBytes(Paths.get("src/test/resources/files/CrearUsuario.json")));
    String body = new String(bytes);

    public CrearUsuario() throws IOException {

    }
    public static CrearUsuario crearUsuario(){
        return instrumented(CrearUsuario.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON).body(body))
        );
    }
}
