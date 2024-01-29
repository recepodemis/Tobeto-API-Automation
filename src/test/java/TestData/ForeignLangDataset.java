package TestData;

import org.json.JSONObject;

public class ForeignLangDataset {
    public static JSONObject foreignLangData(String language, String proficiency){
        JSONObject data = new JSONObject();
        JSONObject outData = new JSONObject();
        data.put("Language",language);
        data.put("Proficiency",proficiency);
        outData.put("data",data);
        return outData;
    }
}
