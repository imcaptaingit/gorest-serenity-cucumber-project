package in.co.gorest.cucumber;


import cucumber.api.CucumberOptions;
import in.co.gorest.testbase.TestBase;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Author - Sarvat Shaikh
 * Project Name: gorest-serenity-cucumber-project
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/feature/")


public class CucumberRunner extends TestBase {
}
