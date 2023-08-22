package in.co.gorest.goresttestsuite;


import in.co.gorest.gorestinfo.UsersSteps;
import in.co.gorest.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Author - Sarvat Shaikh
 * Project Name: gorest-serenity-cucumber-project
 */


@UseTestDataFrom("src/test/java/resources/testdata/userinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class UserDataDrivenTest extends TestBase {

    private String name;
    private String email;
    private String gender;
    private String status;


    @Steps
    UsersSteps usersSteps;

    @Title("Data Driven test for creating multiple users")
    @Test
    public void createMultipleUsers() {
        UsersSteps.createUser(name, email, gender, status).statusCode(201);
    }
}
