package api;

import io.restassured.RestAssured;
import utility.ui.constant.SystemPropertyNames;

public class BaseApiTest {

    public BaseApiTest() {
        // If base url is not set, default to prod url
        if (System.getProperty(SystemPropertyNames.BASE_API_URL) == null) {
            System.setProperty(SystemPropertyNames.BASE_API_URL, "");
        }

        RestAssured.baseURI = System.getProperty(SystemPropertyNames.BASE_API_URL);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
