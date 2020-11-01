package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.*;
import specs.Specs;
import utilities.ConfigReader;
import utilities.ReUsableMethods;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class PlaceNewBuyOrderSteps {
    private PostNewOrderBuyHeader header=new PostNewOrderBuyHeader();
    private PostNewOrderBuyPayload payload=new PostNewOrderBuyPayload();
    private ResponseBodyNewOrderBuy responseBodyNewOrderBuy=new ResponseBodyNewOrderBuy();
    private ResponseHeaderNewOrderBuy responseHeaderNewOrderBuy=new ResponseHeaderNewOrderBuy();
    private String payloadInBase64;
    private String signatureInSha384;
    private Response response;
    private String apiSecret;

    @Given("user enters new order fixed valid datas")
    public void userEntersNewOrderFixedValidDatas() {
        payload.setRequest("/v1/order/new");
        header.setCacheControl("no-cache");
        header.setContent_type("text/plain");
    }
    @Then("user enters a valid APIKey {string}")
    public void userEntersAValidAPIKey(String arg0) {
        header.setxGeminiApikey(ConfigReader.getProperty(arg0));
    }

    @Then("user enters a valid symbol {string}")
    //This function gets a symbol randomly from the list of available symbols
    public void userEntersAValidSymbol(String arg0) {
        if (arg0.equalsIgnoreCase("random")){
            Random random =new Random();
            payload.setSymbol(ReUsableMethods.getCoinList().get(random.nextInt(ReUsableMethods.getCoinList().size())));
        } else payload.setSymbol(arg0);
    }

    @Then("user enters a valid nonce {int}")
    public void user_enters_a_valid_nonce(int int1) {
        String str="";
        if(int1==0){
        payload.setNonce(ReUsableMethods.generateNonce());}
        else payload.setNonce(int1);
    }

    @Then("user enters a valid client order id {string}")
    public void user_enters_a_valid_client_order_id(String string) {

        if (string.equalsIgnoreCase("")) {
            payload.setClientOrderId(ReUsableMethods.generateClientOrderId());
        }
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

    @Then("user enters a valid side {string}")
    public void user_enters_a_valid_side(String string) {
        payload.setSide(string);
    }

    @Then("user enters a valid type {string}")
    public void userEntersAValidType(String arg0) {
        payload.setType(arg0);
    }

    @Then("user enters a valid option {string}")
    public void user_enters_a_valid_option(String string) {
        // this transfer the option to payload. if string is set to random it selects from option list automatically

        if(string.equalsIgnoreCase("random")){
            Random random=new Random();
            payload.setOptions(ReUsableMethods.
                    getOptionsList().get(random.nextInt(ReUsableMethods.getOptionsList().size())));
        }
        else payload.setOptions(string);
    }

    @Then("user enters a valid stop_price {string}")
    public void user_enters_a_valid_stop_price(String string) {
        payload.setStop_price(string);
    }

    @Then("user enters a valid accountname {string}")
    public void user_enters_a_valid_accountname(String string) {
        payload.setAccount(ConfigReader.getProperty(string));
    }

    @Then("user enters a valid APISecret {string}")
    public void userEntersAValidAPISecret(String arg0) {
        apiSecret=ConfigReader.getProperty("string");
    }

    @Then("system creates payload and signatures")
    public void system_creates_payload_and_signatures() {
        header.setxGeminiPayload(ReUsableMethods.encodeToBase64(payload.toString()));
        header.setxGeminiSignature(
                ReUsableMethods.encodeToHmacSha384(header.getxGeminiPayload(),
                        ConfigReader.getProperty("apisecret")));
    }

    @When("user posts the new buy order request")
    public void userPostsTheNewBuyOrderRequest() {

        response = given().
                spec(Specs.getGeminisandboxBaseUrlSpec()).
                accept(ContentType.JSON).
                headers(header.getAsAMap()).
                when().
                post(payload.getRequest());

        System.out.println("response Headers:");
        System.out.println(response.getHeaders());
        responseHeaderNewOrderBuy=response.as(ResponseHeaderNewOrderBuy.class);
        System.out.println(responseHeaderNewOrderBuy);
    }

    @Then("user verifies status code is {int}")
    public void user_verifies_status_code_is_statuscode(int int1) {
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Then("user verifies status code is {int}, reason is {string} and message is {string}")
    public void userVerifiesStatusCodeIsFailedstatuscodeReasonIsAnd(int int1,String arg0, String arg1) {
        // printing headers for tester verification
        Assert.assertEquals(int1,response.getStatusCode());

        // This gets response body to specially created Java ResponseError class for all error types....
        ResponseError responseError=response.as(ResponseError.class);

        System.out.println(responseError.toString());
        Assert.assertTrue(responseError.getReason().equalsIgnoreCase(arg0));

    }

    @Then("user enters a smaller nonce than previous")
    public void userEntersASmallerNonceThanPrevious() {

        long oldNonce=payload.getNonce();
        System.out.println("old nonce: "+oldNonce);
        Random random=new Random();
        long newNonce= oldNonce-random.nextInt(10000000)-1000;
        System.out.println("new nonce: "+newNonce);
        payload.setNonce(newNonce);
    }

}
