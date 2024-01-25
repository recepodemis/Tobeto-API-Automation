package BaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.BeforeClass;

public class TobetoUrl {
    protected RequestSpecification tobetoUrl;
    @Before
    public void setUpClass(){
        tobetoUrl = new RequestSpecBuilder()
                .setBaseUri("https://api.tobeto.com/api")
                .build();
    }
}
