package pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;

public class PostNewOrderBuyHeader {

    @SerializedName("Content-Type")
    @Expose
    private String content_type;

    @SerializedName("X-GEMINI-APIKEY")
    @Expose
    private String xGeminiApikey;

    @SerializedName("X-GEMINI-PAYLOAD")
    @Expose
    private String xGeminiPayload;

    @SerializedName("X-GEMINI-SIGNATURE")
    @Expose
    private String xGeminiSignature;

    @SerializedName("Cache-Control")
    @Expose
    private String cacheControl;

    public PostNewOrderBuyHeader(String content_type,
                                 String xGeminiApikey,
                                 String payloadInBase64Format,
                                 String xGeminiSignature,
                                 String cacheControl) throws NoSuchAlgorithmException, InvalidKeyException {
        setContent_type(content_type);
        setxGeminiApikey(xGeminiApikey);
        setxGeminiPayload(payloadInBase64Format);
        setxGeminiSignature(xGeminiSignature);
        setCacheControl(cacheControl);
    }


    public PostNewOrderBuyHeader() {
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getxGeminiApikey() {
        return xGeminiApikey;
    }

    public void setxGeminiApikey(String xGeminiApikey) {
        this.xGeminiApikey = xGeminiApikey;
    }

    public String getxGeminiPayload() {
        return xGeminiPayload;
    }

    public void setxGeminiPayload(String xGeminiPayload) {

        this.xGeminiPayload = xGeminiPayload;
    }

    public String getxGeminiSignature() {
        return xGeminiSignature;
    }

    public void setxGeminiSignature(String xGeminiSignature) {
        this.xGeminiSignature = xGeminiSignature;
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\"Content_Type\": \"" + getContent_type() +"\",\n"+
                "\"X-GEMINI-APIKEY\": \"" + getxGeminiApikey() + "\",\n"+
                "\"X-GEMINI-PAYLOAD\": \"" + getxGeminiPayload() + "\",\n"+
                "\"X-GEMINI-SIGNATURE\": \"" + getxGeminiSignature() + "\",\n"+
                "\"Cache-Control\": \"" + getCacheControl() + "\"\n"+
                '}';
    }



    public Map<String,String> getAsAMap(){
        Map<String,String> map=new LinkedHashMap<>();
        map.put("Content-Type",getContent_type());
        map.put("X-GEMINI-APIKEY",getxGeminiApikey());
        map.put("X-GEMINI-PAYLOAD",getxGeminiPayload());
        map.put("X-GEMINI-SIGNATURE",getxGeminiSignature());
        map.put("Cache-Control",getCacheControl());

        return map;
    }

}
