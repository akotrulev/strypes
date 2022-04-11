package api.action;

import api.pojo.AuthenticatePojo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.RestAssuredResponseImpl;
import utility.api.BasePath;
import utility.api.Request;

public class ExampleAction {
    private RequestSpecBuilder requestSpecBuilder;

    public ExampleAction() {
        requestSpecBuilder = new RequestSpecBuilder()
                .setBasePath(BasePath.AUTH);
    }

    public RestAssuredResponseImpl postAuthentication(AuthenticatePojo authenticatePojo) {
        RequestSpecBuilder spec = new RequestSpecBuilder()
                .addRequestSpecification(requestSpecBuilder.build())
                .setBody(authenticatePojo);

        return new Request().post(spec.build());
    }
}
