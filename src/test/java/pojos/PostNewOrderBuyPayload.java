package pojos;

public class PostNewOrderBuyPayload {

    private String request;
    private long nonce;
    private String clientOrderId;
    private String symbol;
    private String amount;
    private String min_amount;
    private String price;
    private String side;
    private String type;
    private String options;
    private String stop_price;
    private String account;

    public PostNewOrderBuyPayload() {
    }

    public PostNewOrderBuyPayload(String request,
                                  long nonce,
                                  String clientOrderId,
                                  String symbol,
                                  String amount,
                                  String min_amount,
                                  String price,
                                  String side,
                                  String type,
                                  String options,
                                  String stop_price,
                                  String account) {

        setRequest(request);
        setNonce(nonce);
        setClientOrderId(clientOrderId);
        setSymbol(symbol);
        setAmount(amount);
        setMin_amount(min_amount);
        setPrice(price);
        setSide(side);
        setType(type);
        setOptions(options);
        setStop_price(stop_price);
        setAccount(account);
    }
    /*--------------------- Getters&Setters-----------------------------------*/

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public long getNonce() {
        return nonce;
    }

    public void setNonce(long nonce) {
        this.nonce = nonce;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMin_amount() {
        return min_amount;
    }

    public void setMin_amount(String min_amount) {
        this.min_amount = min_amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getStop_price() {
        return stop_price;
    }

    public void setStop_price(String stop_price) {
        this.stop_price = stop_price;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    /*--------------------- ToString Method -----------------------------------*/

    @Override
    public String toString() {
        return "{\n" +
                "\"request\": \"" + getRequest() + "\",\n" +
                "\"nonce\": " + getNonce() + ",\n" +
                "\"client_order_id\": \"" + getClientOrderId() + "\",\n" +
                "\"symbol\": \"" + getSymbol() + "\",\n" +
                "\"amount\": \"" + getAmount() + "\",\n" +
                (getMin_amount()==null||getMin_amount().equals("")?"":
                        ("\"min_amount\": \"" + getMin_amount() + "\",\n"))+
                "\"price\": \"" + getPrice() + "\",\n" +
                "\"side\": \"" + getSide() + "\",\n" +
                "\"type\": \"" + getType() + "\"\n" +
                (
                (getOptions()==null||getOptions().equals("")) ? "" :
                        (",\"options\": [\n\"" + getOptions() + "\"\n]"))+
                (getStop_price()==null||getStop_price().equals("")?"":
                        (",\n\"stop_price\": \"" + getStop_price() + "\""))+
                (getAccount()==null||getAccount().equals("")?"":
                        (",\n\"account\": \"" + getAccount() + "\""))+

                "\n}";
    }


}
