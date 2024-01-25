package Login;

import BaseUrl.TobetoUrl;
import TestData.LoginDataset;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class InvalidPassword extends TobetoUrl {

    @Test
    public void invalid_password(){

        JSONObject sendData = LoginDataset.loginDataset("rcpodemis@gmail.com",
                                                        "invalidPass");

        tobetoUrl.pathParams("pp1","auth","pp2", "local");
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .spec(tobetoUrl)
                .body(sendData.toString())
                .post("{pp1}/{pp2}");
        response.then().assertThat()
                .statusCode(400)
                .body("error.message", Matchers.equalTo("Invalid identifier or password"));


}
}
