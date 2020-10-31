package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Specs {
    public static RequestSpecification getGeminisandboxBaseUrlSpec(){
        RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
        return requestSpecBuilder.setBaseUri(
                "https://api.sandbox.gemini.com").build();
    }

}
