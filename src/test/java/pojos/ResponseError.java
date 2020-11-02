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

    private String statusCode;

    public ResponseError(String result,
                         String reason,
                         String message,
                         String statusCode) {
     setResult(result);
     setReason(reason);
     setMessage(message);
     setStatusCode(statusCode);
    }

    public ResponseError() {
    }

    @Override
    public String toString() {
        return "\nError: {\n" +
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
