package steps;

import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.PostNewOrderBuyPayload;
import pojos.PostNewOrderBuyHeader;
import pojos.ResponseBodyNewOrderBuy;
import specs.Specs;
import utilities.ConfigReader;
import utilities.ReUsableMethods;

import static io.restassured.RestAssured.given;

public class NewValidBuyOrderRequest {

    PostNewOrderBuyHeader header=new PostNewOrderBuyHeader();
    PostNewOrderBuyPayload payload=new PostNewOrderBuyPayload();
    Response response;
    ResponseBodyNewOrderBuy responseBodyNewOrderBuy=new ResponseBodyNewOrderBuy();


    @Then("user enters valid fixed new buy order payload parameters")
    public void user_enters_valid_fixed_new_buy_order_payload_parameters() {
        payload.setRequest("/v1/order/new");
        header.setContent_type("text/plain");
    }

    @Then("user enters valid fixed new buy order header parameters")
    public void userEntersValidFixedNewBuyOrderHeaderParameters() {
        header.setContent_type("text/plain");
        header.setCacheControl("no-cache");
    }

    @Then("user enters trader apikey {string} header parameter")
    public void user_enters_trader_apikey_header_parameter(String string) {
        header.setxGeminiApikey(ConfigReader.getProperty(string));
    }

    @Then("user enters a valid nonce {int}")
    public void user_enters_a_valid_nonce (int int1) {
        System.out.println("int1: "+int1);
        if ( int1 == 0) {
            payload.setNonce(Integer.parseInt(ReUsableMethods.generateStringId()));
        } else {
            payload.setNonce(int1);
        }
    }

    @Then("user enters a valid client_order_id {string}")
    public void user_enters_a_valid_client_order_id(String string) {
        if (string.equalsIgnoreCase("")){
            payload.setClientOrderId("coi".concat(String.valueOf(ReUsableMethods.generateStringId())));
        }else payload.setClientOrderId(string);
    }

    @Then("user enters a valid symbol {string}")
    public void user_enters_a_valid_symbol(String string) {
        payload.setSymbol(string);
    }

    @Then("user enters a valid amount {string}")
    public void user_enters_a_valid_amount(String string) {
        payload.setAmount(string);

    }

    @Then("user enters a valid min_amount {string}")
    public void user_enters_a_valid_min_amount(String string) {
        payload.setMin_amount(string);
    }

    @Then("user enters a valid price {string}")
    public void user_enters_a_valid_price(String string) {
        payload.setPrice(string);
    }

    @Then("user enters a valid side as {string}")
    public void user_enters_a_valid_side_as(String string) {
        payload.setSide(string);
    }

    @Then("user enters a valid type {string}")
    public void userEntersAValidType(String arg0) {
        payload.setType(arg0);
    }

    @Then("user enters a valid option {string}")
    public void userEntersAValidOption(String arg0) {
        payload.setOptions(arg0);
    }

    @Then("user enters a valid stop_price {string}")
    public void userEntersAValidStop_price(String arg0) {
        payload.setStop_price(arg0);
    }

    @Then("user enters a valid account_name {string}")
    public void userEntersAValidAccount_name(String arg0) {
        payload.setAccount(arg0);
    }

    @Then("user calculates and enters payload base64 header parameter")
    public void user_calculates_and_enters_payload_base64_header_parameter() {
        header.setxGeminiPayload(ReUsableMethods.encodeToBase64(payload.toString()));
        System.out.println("payload in base64: "+header.getxGeminiPayload());
    }

    @Then("user calculates and enters hmacsha384 parameter {string}")
    public void userCalculatesAndEntersHmacshaParameter(String apisecret)  {

        header.setxGeminiSignature(ReUsableMethods.encodeToHmacSha384(header.getxGeminiPayload(),
                ConfigReader.getProperty("apisecret")));
        System.out.println(header.getAsAMap());

    }

    @Then("user sends the new buy order post request")
    public void user_send_the_new_buy_order_post_request() {
        response=given().
                spec(Specs.getGeminisandboxBaseUrlSpec()).
                accept(ContentType.JSON).
                headers(header.getAsAMap()).
                when().
                        post(payload.getRequest());
        response.prettyPrint();
        System.out.println(response.getHeaders());
        ResponseBodyNewOrderBuy responseClass=response.as(ResponseBodyNewOrderBuy.class);
        System.out.println(responseClass);

    }

    @Then("user verifies the status code is {int}")
    public void userVerifiesTheStatusCodeIs(int arg0) {
        Assert.assertEquals(200, response.getStatusCode());

    }

    @Then("user verifies the status code is <statuscode>")
    public void userVerifiesTheStatusCodeIsStatuscode() {
    }

}
