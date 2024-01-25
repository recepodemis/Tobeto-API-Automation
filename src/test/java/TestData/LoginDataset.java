package TestData;

import org.json.JSONObject;

public class LoginDataset {
    public static JSONObject loginDataset(String identifier, String password){
        JSONObject sendData = new JSONObject();
        sendData.put("identifier",identifier);
        sendData.put("password",password);
        return sendData;
    }
}
