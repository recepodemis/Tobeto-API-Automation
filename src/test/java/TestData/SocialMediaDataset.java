package TestData;

import org.json.JSONObject;

public class SocialMediaDataset {
    public static JSONObject socialMedia(String SocialMediaName, String SocialMediaUrl){
        JSONObject sendData = new JSONObject();
        JSONObject data = new JSONObject();
        sendData.put("SocialMediaName",SocialMediaName);
        sendData.put("SocialMediaUrl",SocialMediaUrl);
        data.put("data",sendData);
        return data;
    }
}
