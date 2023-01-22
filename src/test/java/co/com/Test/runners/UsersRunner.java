package co.com.Test.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/users.feature",
        glue="co.com.Test.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class UsersRunner {
}
