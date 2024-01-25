// AuthManager.java
package Login;

import TestData.LoginDataset;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class AuthManager {

    public String authenticateUser(String username, String password) {

        String url = "https://api.tobeto.com/api/auth/local";

        JSONObject sendData = LoginDataset.loginDataset(username,
                password);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(sendData.toString())
                .post(url);


        response.then().assertThat()
                .statusCode(200);

        String jwtToken = response.jsonPath().getString("jwt");
        return jwtToken;

    }
}
