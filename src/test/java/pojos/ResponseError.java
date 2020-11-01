package pojos;

import io.cucumber.messages.internal.com.google.gson.annotations.Expose;
import io.cucumber.messages.internal.com.google.gson.annotations.SerializedName;

public class ResponseError {
    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("reason")
    @Expose
    private String reason;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("statuscode")
    @Expose
    private String statusCode;

    public ResponseError(String result, String reason, String message, String statusCode) {
        this.result = result;
        this.reason = reason;
        this.message = message;
        this.statusCode = statusCode;
    }

    public ResponseError() {
    }

    @Override
    public String toString() {
        return "ResponseError{" +
                "result= " + result + ",\n" +
                "reason=" + reason + ",\n" +
                "message=" + message + ",\n" +
                "statusCode=" + statusCode + ",\n" +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
