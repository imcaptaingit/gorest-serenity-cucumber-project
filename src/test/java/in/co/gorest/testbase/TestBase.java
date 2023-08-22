package in.co.gorest.testbase;


import in.co.gorest.constants.Path;
import in.co.gorest.utils.PropertyReader;
import in.co.gorest.utils.TestUtils;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Author - Sarvat Shaikh
 * Project Name: gorest-serenity-cucumber-project
 */

public class TestBase extends TestUtils {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void inIt() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.basePath = Path.RESOURCE;
    }

}