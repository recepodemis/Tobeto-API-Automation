package social_media;

import BaseUrl.TobetoUrl;
import Login.AuthManager;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class deleteMediaAccount extends TobetoUrl {
    private static String authToken;
    @Before
    public void setUp() {

        AuthManager authManager = new AuthManager();
        authToken = authManager.authenticateUser("softwaretestdemotobeto@gmail.com", "wx6nn6ER3q.BY67");
    }

    @Test
    public void deleteMedia() {

        tobetoUrl.pathParams("pp1", "user-social-medias","pp2", addSocialMediaAccount.id);
        JSONObject socialMediaJson = new JSONObject();
        socialMediaJson.put("SocialMediaName", addSocialMediaAccount.SocialMediaName);
        socialMediaJson.put("SocialMediaUrl", addSocialMediaAccount.SocialMediaUrl);
        socialMediaJson.put("createdAt", addSocialMediaAccount.createdAt);
        socialMediaJson.put("sitemap_exclude", addSocialMediaAccount.sitemap_exclude);
        socialMediaJson.put("updatedAt", addSocialMediaAccount.updatedAt);
        socialMediaJson.put("id", addSocialMediaAccount.id);


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
