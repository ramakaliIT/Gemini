package pojos;

import io.cucumber.messages.internal.com.google.gson.annotations.Expose;
import io.cucumber.messages.internal.com.google.gson.annotations.SerializedName;

public class ResponseHeaderNewOrderBuy {

    @SerializedName("Server")
    @Expose
    private String server;

    @SerializedName("Date")
    @Expose
    private String date;

    @SerializedName("Content-Type")
    @Expose
    private int contenType;

    @SerializedName("Content-Length")
    @Expose
    private String contentLength;

    @SerializedName("Vary")
    @Expose
    private String vary;

    public ResponseHeaderNewOrderBuy(String server, String date, int contenType, String contentLength, String vary) {
        this.server = server;
        this.date = date;
        this.contenType = contenType;
        this.contentLength = contentLength;
        this.vary = vary;
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

    public int getContenType() {
        return contenType;
    }

    public void setContenType(int contenType) {
        this.contenType = contenType;
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
        return "{" +
                "server='" + server + '\'' +
                ", date='" + date + '\'' +
                ", contenType=" + contenType +
                ", contentLength='" + contentLength + '\'' +
                ", vary='" + vary + '\'' +
                '}';
    }
}
