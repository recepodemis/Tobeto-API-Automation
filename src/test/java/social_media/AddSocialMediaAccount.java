package social_media;

import BaseUrl.TobetoUrl;
import Login.AuthManager;
import TestData.SocialMediaDataset;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AddSocialMediaAccount extends TobetoUrl {
    public static String authToken;
    public static String SocialMediaName;
    public static String SocialMediaUrl;
    public static String createdAt;
    public static Boolean sitemap_exclude;
    public static String updatedAt;
    public static int id;

    @Before
    public void setUp() {

        AuthManager authManager = new AuthManager();
        authToken = authManager.authenticateUser("softwaretestdemotobeto@gmail.com", "wx6nn6ER3q.BY67");
    }

    @Test
    public void postNewMedia() {

        tobetoUrl.pathParams("pp1", "user-social-medias");
        JSONObject socialMediaJson = SocialMediaDataset.socialMedia("random",
                "https://www.linkedin.com/in/recepodemis/");

        Response response = given()
                .spec(tobetoUrl)
                .contentType("application/json")
                .header("Authorization", "Bearer\n" + authToken)
                .body(socialMediaJson.toString())
                .when()
                .post("{pp1}");


        SocialMediaName = response.jsonPath().getString("SocialMediaName");
        SocialMediaUrl = response.jsonPath().getString("SocialMediaUrl");
        createdAt = response.jsonPath().getString("createdAt");
        sitemap_exclude = response.jsonPath().getBoolean("sitemap_exclude");
        updatedAt = response.jsonPath().getString("updatedAt");
        id = response.jsonPath().getInt("id");

        response.then().assertThat()
                .statusCode(200);
    }
}
