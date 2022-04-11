package utility.api;

import io.restassured.http.Method;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.specification.RequestSpecification;
import org.testng.Reporter;

import static io.restassured.RestAssured.given;

public class Request {
    public RestAssuredResponseImpl sendRequest(RequestSpecification requestSpecification, Method method) {
              requestSpecification.relaxedHTTPSValidation();
        RestAssuredResponseImpl restAssuredResponse = (RestAssuredResponseImpl) given()
                    .spec(requestSpecification)
                .when()
                    .request(method)
                .then()
                    .extract().response();
        Reporter.log(restAssuredResponse.getLogRepository().getRequestLog());
        Reporter.log(restAssuredResponse.getLogRepository().getResponseLog());
        return restAssuredResponse;
    }

    public RestAssuredResponseImpl post(RequestSpecification requestSpecification) {
        return sendRequest(requestSpecification, Method.POST);
    }

    public RestAssuredResponseImpl put(RequestSpecification requestSpecification) {
        return sendRequest(requestSpecification, Method.PUT);
    }

    public RestAssuredResponseImpl patch(RequestSpecification requestSpecification) {
        return sendRequest(requestSpecification, Method.PATCH);
    }

    public RestAssuredResponseImpl get(RequestSpecification requestSpecification) {
        return sendRequest(requestSpecification, Method.GET);
    }

    public RestAssuredResponseImpl delete(RequestSpecification requestSpecification) {
        return sendRequest(requestSpecification, Method.DELETE);
    }
}
