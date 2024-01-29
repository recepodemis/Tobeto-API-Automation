package social_media;

import BaseUrl.TobetoUrl;
import Login.AuthManager;
import TestData.SocialMediaDataset;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ExistSocialMediaAccount extends TobetoUrl {
    private static String authToken;
    @Before
    public void setUp() {

        AuthManager authManager = new AuthManager();
        authToken = authManager.authenticateUser("softwaretestdemotobeto@gmail.com", "wx6nn6ER3q.BY67");
    }
    @Test
    public void postExistMedia() {

        tobetoUrl.pathParams("pp1", "user-social-medias");
        JSONObject socialMediaJson = SocialMediaDataset.socialMedia("newss"
                , "https://www.linkedin.com/in/recepodemis/");

        Response response = given()
                .spec(tobetoUrl)
                .contentType("application/json")
                .header("Authorization", "Bearer\n" + authToken)
                .body(socialMediaJson.toString())
                .when()
                .post("{pp1}");

        response.then().assertThat()
                .statusCode(200)
                .body("error.message", Matchers.equalTo("Bu sosyal medya zaten mevcut."));


    }
}
