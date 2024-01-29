package social_media;

import BaseUrl.TobetoUrl;
import Login.AuthManager;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteMediaAccount extends TobetoUrl {
    private static String authToken;
    @Before
    public void setUp() {

        AuthManager authManager = new AuthManager();
        authToken = authManager.authenticateUser("softwaretestdemotobeto@gmail.com", "wx6nn6ER3q.BY67");
    }

    @Test
    public void deleteMedia() {

        tobetoUrl.pathParams("pp1", "user-social-medias","pp2", AddSocialMediaAccount.id);
        JSONObject socialMediaJson = new JSONObject();
        socialMediaJson.put("SocialMediaName", AddSocialMediaAccount.SocialMediaName);
        socialMediaJson.put("SocialMediaUrl", AddSocialMediaAccount.SocialMediaUrl);
        socialMediaJson.put("createdAt", AddSocialMediaAccount.createdAt);
        socialMediaJson.put("sitemap_exclude", AddSocialMediaAccount.sitemap_exclude);
        socialMediaJson.put("updatedAt", AddSocialMediaAccount.updatedAt);
        socialMediaJson.put("id", AddSocialMediaAccount.id);


        Response response = given()
                .spec(tobetoUrl)
                .contentType("application/json")
                .header("Authorization", "Bearer\n" + authToken)
                .body(socialMediaJson.toString())
                .when()
                .delete("{pp1}/{pp2}");

        response.then().assertThat()
                .statusCode(200);

    }
}
