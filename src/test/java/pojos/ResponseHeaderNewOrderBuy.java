package pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseHeaderNewOrderBuy {

    @SerializedName("Server")
    @Expose
    private String server;

    @SerializedName("Date")
    @Expose
    private String date;

    @SerializedName("Content-Type")
    @Expose
    private String contentType;

    @SerializedName("Content-Length")
    @Expose
    private String contentLength;

    @SerializedName("Vary")
    @Expose
    private String vary;

    @SerializedName("body")
    @Expose
    private ResponseBodyNewOrderBuy responseBody;


    public ResponseHeaderNewOrderBuy(String server, String date, String contentType, String contentLength, String vary, ResponseBodyNewOrderBuy responseBody) {
        setServer(server);
        setDate(date);
        setContentType(contentType);
        setContentLength(contentLength);
        setVary(vary);
        setResponseBody(responseBody);
    }

    public ResponseHeaderNewOrderBuy() {
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public String getVary() {
        return vary;
    }

    public void setVary(String vary) {
        this.vary = vary;
    }

    @Override
    public String toString() {
        return "{\n" +
                "server='" + server + ",\n" +
                "date='" + date + ",\n" +
                "contenType=" + contentType +",\n" +
                "contentLength='" + contentLength + ",\n" +
                "contentLength='" + contentLength + ",\n" +
                "vary='" + vary + ",\n" +
                "body: [\n"+
                "\n]\n"+
                '}';
    }

    public String getHeaders() {
        return "{\n" +
                "server=" + server + "\n" +
                "date= " + date + ",\n" +
                "contenType= " + contentType +",\n" +
                "contentLength= " + contentLength + ",\n" +
                "contentLength= " + contentLength + ",\n" +
                "vary='" + vary + ",\n" +
                '}';
    }

    public ResponseBodyNewOrderBuy getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBodyNewOrderBuy responseBody) {
        this.responseBody = responseBody;
    }
}
