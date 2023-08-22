package in.co.gorest.goresttestsuite;


import in.co.gorest.gorestinfo.UsersSteps;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

/**
 * Author - Sarvat Shaikh
 * Project Name: gorest-serenity-cucumber-project
 */


@RunWith(SerenityRunner.class)
public class GoRestCURDTest extends TestBase {
    static String name = "jinx";
    static String email = "jinxys" + getRandomValue() + "@gmail.com";
    static String gender = "male";
    static String status = "active";

    static int id;


    @Steps
    UsersSteps usersSteps;

    @Title("This method will create a new users record and verify it by its ID")
    @Test
    public void test002() {
        ValidatableResponse getId = usersSteps.updateUser(id, name, email, gender, status);
        id = getId.extract().path("id");
    }

    @Title("This method will update the existing record")
    @Test
    public void test003() {
        status = "inactive";
        usersSteps.updateUser(id, name, email, gender, status);
        ValidatableResponse response = usersSteps.getUserById(id).statusCode(200);
        HashMap<String, ?> userRecord = response.extract().path("");
        Assert.assertThat(userRecord, hasValue(status));
    }

    @Title("This method will delete the existing record")
    @Test
    public void test004() {
        usersSteps.deleteUser(id).statusCode(204);
        usersSteps.getUserById(id).statusCode(404);
    }

}
