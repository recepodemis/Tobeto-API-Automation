package foreignLanguage;

import BaseUrl.TobetoUrl;
import Login.AuthManager;
import TestData.ForeignLangDataset;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AddLanguage extends TobetoUrl {
    private String authToken;
    @Before
    public void setUp() {

        AuthManager authManager = new AuthManager();
        authToken = authManager.authenticateUser("softwaretestdemotobeto@gmail.com",
                                            "wx6nn6ER3q.BY67");
    }
    @Test
    public void addLang(){

        tobetoUrl.pathParam("pp1","user-foreign-languages");

        JSONObject data = ForeignLangDataset.foreignLangData("3",
            "Temel Seviye ( A1 , A2)");

        Response response = given()
                .spec(tobetoUrl)
                .contentType("application/json")
                .header("Authorization", "Bearer\n" + authToken)
                .body(data.toString())
                .when()
                .post("{pp1}");

        response.then().assertThat()
                .statusCode(200)
                .body("error.message", Matchers.equalTo("Bu dil zaten mevcut."));
    }

}
