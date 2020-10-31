package pojos;

import io.cucumber.messages.internal.com.google.gson.annotations.Expose;
import io.cucumber.messages.internal.com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBodyNewOrderBuy {

    @SerializedName("client_order_id")
    @Expose
    private String orderId;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("symbol")
    @Expose
    private String symbol;

    @SerializedName("exchange")
    @Expose
    private String exchange;

    @SerializedName("avg_execution_price")
    @Expose
    private String avgExecutionPrice;

    @SerializedName("side")
    @Expose
    private String side;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    @SerializedName("timestampms")
    @Expose
    private String timestampms;

    @SerializedName("is_live")
    @Expose
    private boolean isLive;

    @SerializedName("is_cancelled")
    @Expose
    private boolean isCancelled;

    @SerializedName("is_hidden")
    @Expose
    private boolean isHidden;

    @SerializedName("was_forced")
    @Expose
    private boolean wasForced;

    @SerializedName("executed_amount")
    @Expose
    private String executedAmount;

    @SerializedName("client_order_id")
    @Expose
    private String client_order_id;

    @SerializedName("reason")
    @Expose
    private String reason;

    @SerializedName("options")
    @Expose
    private List<String> options;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("original_amount")
    @Expose
    private String originalAmount;

    @SerializedName("remaining_amount")
    @Expose
    private String remaining_amount;

    public ResponseBodyNewOrderBuy() {
    }

    public ResponseBodyNewOrderBuy(String orderId, String id, String symbol,
                                   String exchange, String avgExecutionPrice,
                                   String side, String type, String timestamp,
                                   String timestampms, boolean isLive, boolean isCancelled,
                                   boolean isHidden, boolean wasForced, String executedAmount,
                                   String client_order_id, String reason, List<String> options,
                                   String price, String originalAmount, String remaining_amount) {

        setOrderId(orderId);
        setId(id);
        setSymbol(symbol);
        setExchange(exchange);
        setAvgExecutionPrice(avgExecutionPrice);
        setSide(side);
        setType(type);
        setTimestamp(timestamp);
        setTimestampms(timestampms);
        setLive(isLive);
        setCancelled(isCancelled);
        setHidden(isHidden);
        setWasForced(wasForced);
        setExecutedAmount(executedAmount);
        setClient_order_id(client_order_id);
        setReason(reason);
        setOptions(options);
        setPrice(price);
        setOriginalAmount(originalAmount);
        setRemaining_amount(remaining_amount);

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getAvgExecutionPrice() {
        return avgExecutionPrice;
    }

    public void setAvgExecutionPrice(String avgExecutionPrice) {
        this.avgExecutionPrice = avgExecutionPrice;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestampms() {
        return timestampms;
    }

    public void setTimestampms(String timestampms) {
        this.timestampms = timestampms;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public boolean isWasForced() {
        return wasForced;
    }

    public void setWasForced(boolean wasForced) {
        this.wasForced = wasForced;
    }

    public String getExecutedAmount() {
        return executedAmount;
    }

    public void setExecutedAmount(String executedAmount) {
        this.executedAmount = executedAmount;
    }

    public String getClient_order_id() {
        return client_order_id;
    }

    public void setClient_order_id(String client_order_id) {
        this.client_order_id = client_order_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getRemaining_amount() {
        return remaining_amount;
    }

    public void setRemaining_amount(String remaining_amount) {
        this.remaining_amount = remaining_amount;
    }

    @Override
    public String toString() {
        return "{" +
                "client_order_id: " + getOrderId() + ",\n" +
                ", id: " + getId() + ",\n" +
                ", symbol: " + getSymbol() + ",\n" +
                ", exchange: " + getExchange() + ",\n" +
                ", avg_execution_price: '" + getAvgExecutionPrice() + ",\n" +
                ", side: " + getSide() + ",\n" +
                ", type: " + getType() + ",\n" +
                ", timestamp: " + getTimestamp() + ",\n" +
                ", timestampms: " + getTimestampms() + ",\n" +
                ", is_live: " + isLive +",\n" +
                ", is_cancelled: " + isCancelled+",\n" +
                ", is_hidden: " + isHidden +",\n" +
                ", wasForced: " + wasForced +",\n" +
                ", executed_mount: " + getExecutedAmount() + ",\n" +
                ", client_order_id: " + getClient_order_id() + ",\n" +
                ", reason: " + getReason() + ",\n" +
                ", options: " + getOptions() +",\n" +
                ", price: " + getPrice() + ",\n" +
                ", originalAmount: " + getOriginalAmount() + ",\n" +
                ", remaining_amount: " + getRemaining_amount()+ ",\n" +
                '}';
    }
}
