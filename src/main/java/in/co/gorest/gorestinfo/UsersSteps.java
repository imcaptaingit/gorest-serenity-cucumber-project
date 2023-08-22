package in.co.gorest.gorestinfo;


import in.co.gorest.constants.EndPoints;
import in.co.gorest.model.UserPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

/**
 * Author - Sarvat Shaikh
 * Project Name: gorest-serenity-cucumber-project
 */
public class UsersSteps {

    static final String token = "Bearer 5023c6dd6ec5b223c2642a60282c5d312924813dc7931ecae9911d197c1076b3";
    private int userId;

    @Step("Creating User with Name :{0}, email : {1}, gender : {2} and status: {3}")
    public static ValidatableResponse createUser(String name, String email, String gender, String status) {

        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);
        return (ValidatableResponse) SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .body(userPojo)
                .when()
                .post(EndPoints.CREATE_USER)
                .then();

    }

    @Step("Getting user ID : {0}")
    public ValidatableResponse getUserById(int userId) {
        return SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Connection", "keep-alive")
                .pathParam("id", userId)
                .when()
                .get(EndPoints.GET_USER)
                .then().log().all();

    }


    @Step("Updating User with Name :{0}, email : {1}, gender : {2} and status: {3}")
    public ValidatableResponse updateUser(int userId, String name, String email, String gender, String status) {

        UserPojo userPojo = new UserPojo();

        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);
        return SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .pathParam("id", userId)
                .body(userPojo)
                .when()
                .put(EndPoints.UPDATE_USER)
                .then().log().all();
    }

    @Step("Deleting student information with userId: {0}")
    public ValidatableResponse deleteUser(int userId) {

        return SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Connection", "keep-alive")
                .pathParam("id", userId)
                .when()
                .delete(EndPoints.DELETE_USER)
                .then().log().all();

    }

    @Step("Getting user ID : {0}")
    public ValidatableResponse getUserByName(String name) {
        return SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Connection", "keep-alive")
                .pathParam("name", name)
                .when()
                .get(EndPoints.GET_USER_NAME)
                .then().log().all();

    }
}
