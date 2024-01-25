package Login;

import BaseUrl.TobetoUrl;
import TestData.LoginDataset;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ValidLogin extends TobetoUrl {
    @Test
    public void ValidLogin(){

        JSONObject sendData = LoginDataset.loginDataset("softwaretestdemotobeto@gmail.com",
                "wx6nn6ER3q.BY67");

        tobetoUrl.pathParams("pp1","auth","pp2", "local");
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .spec(tobetoUrl)
                .body(sendData.toString())
                .post("{pp1}/{pp2}");


        response.then().assertThat()
                .statusCode(200);

        String jwtToken = response.jsonPath().getString("jwt");
        System.out.println("JWT Token: " + jwtToken);

    }
}
