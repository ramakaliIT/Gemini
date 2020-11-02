package utilities;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ReUsableMethods {


    public static String encodeToBase64(String string) {
        /*This method returns base64 encoded format of a string */
        return Base64.encodeBase64String(string.getBytes());
    }

    public static String encodeToHmacSha384(String base64,
                                            String key_secret) {
        /*This method returns Hmacsha384 encoding format of a string and a secret key */
        HmacUtils hmacUtils = new HmacUtils((HmacAlgorithms.HMAC_SHA_384), key_secret);
        String hmac = hmacUtils.hmacHex(base64);
        return hmac;
    }

    public static String generateStringId() {
        /*This method generates a random String id   */
        long timeinMilisecs = System.currentTimeMillis();

        System.out.println(timeinMilisecs);
        return String.valueOf(timeinMilisecs / 10000);
    }

    public static Long generateNonce() {
        /*This method generates a random Long integer   */
        return System.currentTimeMillis();
    }

    public static String generateClientOrderId() {
        /*This method generates a random String id   */
        return "coid".concat(String.valueOf(System.currentTimeMillis()));
    }

    public static String getCoinSymbol(String symbol) {

        return symbol.length()==6 ? symbol.substring(0, 3):symbol.substring(0, 4);
    }

    public static String getCurrencyOftheSymbol(String symbol) {
        /*-------------     gives the currency of the symbol ----------*/
        return symbol.length()==6 ? symbol.substring(3, 6): symbol.substring(4,7);
    }

    public static List<String> getOptionsList() {
        List<String> listOfOptions = new ArrayList();
        listOfOptions.add("fill-or-kill");
        listOfOptions.add("immediate-or-cancel");
        listOfOptions.add("auction-only");
        listOfOptions.add("maker-or-cancel");
        listOfOptions.add("indication-of-interest");

        return listOfOptions;

    }


    public static double getMinimumTickSize(String symbol) {
        /*Tis method gives the registered min Tick size of the symbol*/
        /* This can get data from an axcelsheet, sql or anywhere else in a real life scenario */
        Map<String, Double> minimumTickSize = new HashMap<>();
        minimumTickSize.put("btcusd", 0.00000001);
        minimumTickSize.put("btceur", 0.00000001);
        minimumTickSize.put("btcgbp", 0.00000001);
        minimumTickSize.put("ethbtc", 0.000001);
        minimumTickSize.put("ethusd", 0.000001);
        minimumTickSize.put("etheur", 0.000001);
        minimumTickSize.put("ethgbp", 0.000001);
        minimumTickSize.put("zecusd", 0.000001);
        minimumTickSize.put("zecbtc", 0.000001);
        minimumTickSize.put("zeceth", 0.000001);
        minimumTickSize.put("zecbch", 0.000001);
        minimumTickSize.put("zecltc", 0.000001);
        minimumTickSize.put("bchusd", 0.000001);
        minimumTickSize.put("bchbtc", 0.000001);
        minimumTickSize.put("bcheth", 0.000001);
        minimumTickSize.put("ltcusd", 0.00001);
        minimumTickSize.put("ltcbtc", 0.00001);
        minimumTickSize.put("ltceth", 0.00001);
        minimumTickSize.put("ltcbch", 0.00001);
        minimumTickSize.put("batusd", 0.000001);
        minimumTickSize.put("daiusd", 0.000001);
        minimumTickSize.put("linkusd", 0.000001);
        minimumTickSize.put("oxtusd", 0.000001);
        minimumTickSize.put("batbtc", 0.000001);
        minimumTickSize.put("linkbtc", 0.000001);
        minimumTickSize.put("oxtbtc", 0.000001);
        minimumTickSize.put("bateth", 0.000001);
        minimumTickSize.put("linketh", 0.000001);
        minimumTickSize.put("oxteth", 0.000001);
        minimumTickSize.put("ampusd", 0.000001);
        minimumTickSize.put("compusd", 0.000001);
        minimumTickSize.put("paxgusd", 0.00000001);
        minimumTickSize.put("mkrusd", 0.000001);
        minimumTickSize.put("zrxusd", 0.000001);
        minimumTickSize.put("kncusd", 0.000001);
        minimumTickSize.put("manausd", 0.000001);
        minimumTickSize.put("storjusd", 0.000001);
        minimumTickSize.put("snxusd", 0.000001);
        minimumTickSize.put("crvusd", 0.000001);
        minimumTickSize.put("balusd", 0.000001);
        minimumTickSize.put("uniusd", 0.000001);
        minimumTickSize.put("renusd", 0.000001);
        minimumTickSize.put("umausd", 0.000001);
        minimumTickSize.put("yfiusd", 0.00000001);
        minimumTickSize.put("btcdai", 0.00000001);
        minimumTickSize.put("ethdai", 0.000001);
        minimumTickSize.put("aaveusd", 0.000001);
        minimumTickSize.put("filusd", 0.000001);
        return minimumTickSize.get(symbol);
    }

    public static double getMinimumOrderSize(String symbol) {
        /*----------This returns the registered currency minimumOrderSize -------- */
        Map<String, Double> minimumOrderSize = new HashMap<>();
        minimumOrderSize.put("btcusd", 0.00001);
        minimumOrderSize.put("btceur", 0.00001);
        minimumOrderSize.put("btcgbp", 0.00001);
        minimumOrderSize.put("ethbtc", 0.001);
        minimumOrderSize.put("ethusd", 0.001);
        minimumOrderSize.put("etheur", 0.001);
        minimumOrderSize.put("ethgbp", 0.001);
        minimumOrderSize.put("zecusd", 0.001);
        minimumOrderSize.put("zecbtc", 0.001);
        minimumOrderSize.put("zeceth", 0.001);
        minimumOrderSize.put("zecbch", 0.001);
        minimumOrderSize.put("zecltc", 0.001);
        minimumOrderSize.put("bchusd", 0.001);
        minimumOrderSize.put("bchbtc", 0.001);
        minimumOrderSize.put("bcheth", 0.001);
        minimumOrderSize.put("ltcusd", 0.01);
        minimumOrderSize.put("ltcbtc", 0.01);
        minimumOrderSize.put("ltceth", 0.01);
        minimumOrderSize.put("ltcbch", 0.01);
        minimumOrderSize.put("batusd", 1.00);
        minimumOrderSize.put("daiusd", 0.1);
        minimumOrderSize.put("linkusd", 0.1);
        minimumOrderSize.put("oxtusd", 1.00);
        minimumOrderSize.put("batbtc", 1.0);
        minimumOrderSize.put("linkbtc", 0.1);
        minimumOrderSize.put("oxtbtc", 1.0);
        minimumOrderSize.put("bateth", 1.0);
        minimumOrderSize.put("linketh", 0.1);
        minimumOrderSize.put("oxteth", 1.0);
        minimumOrderSize.put("ampusd", 10.0);
        minimumOrderSize.put("compusd", 0.001);
        minimumOrderSize.put("paxgusd", 0.0001);
        minimumOrderSize.put("mkrusd", 0.001);
        minimumOrderSize.put("zrxusd", 0.1);
        minimumOrderSize.put("kncusd", 0.1);
        minimumOrderSize.put("manausd", 1.0);
        minimumOrderSize.put("storjusd", 0.1);
        minimumOrderSize.put("snxusd", 0.01);
        minimumOrderSize.put("crvusd", 0.1);
        minimumOrderSize.put("balusd", 0.01);
        minimumOrderSize.put("uniusd", 0.01);
        minimumOrderSize.put("renusd", 0.01);
        minimumOrderSize.put("umausd", 0.01);
        minimumOrderSize.put("yfiusd", 0.00001);
        minimumOrderSize.put("btcdai", 0.00001);
        minimumOrderSize.put("ethdai", 0.001);
        minimumOrderSize.put("aaveusd", 0.001);
        minimumOrderSize.put("filusd", 0.1);
        return minimumOrderSize.get(symbol);
    }


    public static double getQuotedCurrencyPriceIncrement(String symbol) {
        /*----------This returns the registered currency quoted currency price increment--- */
        Map<String, Double> quotedCurrencyPriceIncrement = new HashMap<>();
        quotedCurrencyPriceIncrement.put("btcusd", 0.01);
        quotedCurrencyPriceIncrement.put("btceur", 0.01);
        quotedCurrencyPriceIncrement.put("btcgbp", 0.01);
        quotedCurrencyPriceIncrement.put("ethbtc", 0.00001);
        quotedCurrencyPriceIncrement.put("ethusd", 0.01);
        quotedCurrencyPriceIncrement.put("etheur", 0.01);
        quotedCurrencyPriceIncrement.put("ethgbp", 0.01);
        quotedCurrencyPriceIncrement.put("zecusd", 0.01);
        quotedCurrencyPriceIncrement.put("zecbtc", 0.00001);
        quotedCurrencyPriceIncrement.put("zeceth", 0.0001);
        quotedCurrencyPriceIncrement.put("zecbch", 0.0001);
        quotedCurrencyPriceIncrement.put("zecltc", 0.001);
        quotedCurrencyPriceIncrement.put("bchusd", 0.01);
        quotedCurrencyPriceIncrement.put("bchbtc", 0.00001);
        quotedCurrencyPriceIncrement.put("bcheth", 0.0001);
        quotedCurrencyPriceIncrement.put("ltcusd", 0.01);
        quotedCurrencyPriceIncrement.put("ltcbtc", 0.00001);
        quotedCurrencyPriceIncrement.put("ltceth", 0.0001);
        quotedCurrencyPriceIncrement.put("ltcbch", 0.0001);
        quotedCurrencyPriceIncrement.put("batusd", 0.00001);
        quotedCurrencyPriceIncrement.put("daiusd", 0.00001);
        quotedCurrencyPriceIncrement.put("linkusd", 0.00001);
        quotedCurrencyPriceIncrement.put("oxtusd", 0.00001);
        quotedCurrencyPriceIncrement.put("batbtc", 0.00000001);
        quotedCurrencyPriceIncrement.put("linkbtc", 0.00000001);
        quotedCurrencyPriceIncrement.put("oxtbtc", 0.00000001);
        quotedCurrencyPriceIncrement.put("bateth", 0.0000001);
        quotedCurrencyPriceIncrement.put("linketh", 0.0000001);
        quotedCurrencyPriceIncrement.put("oxteth", 0.0000001);
        quotedCurrencyPriceIncrement.put("ampusd", 0.00001);
        quotedCurrencyPriceIncrement.put("compusd", 0.01);
        quotedCurrencyPriceIncrement.put("paxgusd", 0.01);
        quotedCurrencyPriceIncrement.put("mkrusd", 0.01);
        quotedCurrencyPriceIncrement.put("zrxusd", 0.00001);
        quotedCurrencyPriceIncrement.put("kncusd", 0.00001);
        quotedCurrencyPriceIncrement.put("manausd", 0.00001);
        quotedCurrencyPriceIncrement.put("storjusd", 0.00001);
        quotedCurrencyPriceIncrement.put("snxusd", 0.0001);
        quotedCurrencyPriceIncrement.put("crvusd", 0.0001);
        quotedCurrencyPriceIncrement.put("balusd", 0.0001);
        quotedCurrencyPriceIncrement.put("uniusd", 0.0001);
        quotedCurrencyPriceIncrement.put("renusd", 0.00001);
        quotedCurrencyPriceIncrement.put("umausd", 0.0001);
        quotedCurrencyPriceIncrement.put("yfiusd", 0.01);
        quotedCurrencyPriceIncrement.put("btcdai", 0.01);
        quotedCurrencyPriceIncrement.put("ethdai", 0.01);
        quotedCurrencyPriceIncrement.put("aaveusd", 0.0001);
        quotedCurrencyPriceIncrement.put("filusd", 0.0001);
        return quotedCurrencyPriceIncrement.get(symbol);
    }

    public static String getQuotedCurrency(String symbol) {
        /*This returns a quoted currency of the symbol as a string*/

        Map<String, String> quotedCurrencyPriceIncrement = new HashMap<>();
        quotedCurrencyPriceIncrement.put("btcusd", "USD");
        quotedCurrencyPriceIncrement.put("btceur", "EUR");
        quotedCurrencyPriceIncrement.put("btcgbp", "GBP");
        quotedCurrencyPriceIncrement.put("ethbtc", "BTC");
        quotedCurrencyPriceIncrement.put("ethusd", "USD");
        quotedCurrencyPriceIncrement.put("etheur", "EUR");
        quotedCurrencyPriceIncrement.put("ethgbp", "GBP");
        quotedCurrencyPriceIncrement.put("zecusd", "USD");
        quotedCurrencyPriceIncrement.put("zecbtc", "BTC");
        quotedCurrencyPriceIncrement.put("zeceth", "ETH");
        quotedCurrencyPriceIncrement.put("zecbch", "BCH");
        quotedCurrencyPriceIncrement.put("zecltc", "LTC");
        quotedCurrencyPriceIncrement.put("bchusd", "USD");
        quotedCurrencyPriceIncrement.put("bchbtc", "BTC");
        quotedCurrencyPriceIncrement.put("bcheth", "ETH");
        quotedCurrencyPriceIncrement.put("ltcusd", "USD");
        quotedCurrencyPriceIncrement.put("ltcbtc", "BTC");
        quotedCurrencyPriceIncrement.put("ltceth", "ETH");
        quotedCurrencyPriceIncrement.put("ltcbch", "BCH");
        quotedCurrencyPriceIncrement.put("batusd", "USD");
        quotedCurrencyPriceIncrement.put("daiusd", "USD");
        quotedCurrencyPriceIncrement.put("linkusd", "USD");
        quotedCurrencyPriceIncrement.put("oxtusd", "USD");
        quotedCurrencyPriceIncrement.put("batbtc", "BTC");
        quotedCurrencyPriceIncrement.put("linkbtc", "BTC");
        quotedCurrencyPriceIncrement.put("oxtbtc", "BTC");
        quotedCurrencyPriceIncrement.put("bateth", "ETH");
        quotedCurrencyPriceIncrement.put("linketh", "ETH");
        quotedCurrencyPriceIncrement.put("oxteth", "ETH");
        quotedCurrencyPriceIncrement.put("ampusd", "USD");
        quotedCurrencyPriceIncrement.put("compusd", "USD");
        quotedCurrencyPriceIncrement.put("paxgusd", "USD");
        quotedCurrencyPriceIncrement.put("mkrusd", "USD");
        quotedCurrencyPriceIncrement.put("zrxusd", "USD");
        quotedCurrencyPriceIncrement.put("kncusd", "USD");
        quotedCurrencyPriceIncrement.put("manausd", "USD");
        quotedCurrencyPriceIncrement.put("storjusd", "USD");
        quotedCurrencyPriceIncrement.put("snxusd", "USD");
        quotedCurrencyPriceIncrement.put("crvusd", "USD");
        quotedCurrencyPriceIncrement.put("balusd", "USD");
        quotedCurrencyPriceIncrement.put("uniusd", "USD");
        quotedCurrencyPriceIncrement.put("renusd", "USD");
        quotedCurrencyPriceIncrement.put("umausd", "USD");
        quotedCurrencyPriceIncrement.put("yfiusd", "USD");
        quotedCurrencyPriceIncrement.put("btcdai", "DAI");
        quotedCurrencyPriceIncrement.put("ethdai", "DAI");
        quotedCurrencyPriceIncrement.put("aaveusd", "USD");
        quotedCurrencyPriceIncrement.put("filusd", "USD");

        return quotedCurrencyPriceIncrement.get(symbol);
    }

    public static List<String> getCoinList() {
        /*This give the full list of sysmbols in the system ( for a quick solution in short time )*/
        List<String> coinsList = new ArrayList<>();
        coinsList.add("btcusd");
        coinsList.add("btceur");
        coinsList.add("btcgbp");
        coinsList.add("ethbtc");
        coinsList.add("ethusd");
        coinsList.add("etheur");
        coinsList.add("ethgbp");
        coinsList.add("zecusd");
        coinsList.add("zecbtc");
        coinsList.add("zeceth");
        coinsList.add("zecbch");
        coinsList.add("zecltc");
        coinsList.add("bchusd");
        coinsList.add("bchbtc");
        coinsList.add("bcheth");
        coinsList.add("ltcusd");
        coinsList.add("ltcbtc");
        coinsList.add("ltceth");
        coinsList.add("ltcbch");
        coinsList.add("batusd");
        coinsList.add("daiusd");
        coinsList.add("linkusd");
        coinsList.add("oxtusd");
        coinsList.add("batbtc");
        coinsList.add("linkbtc");
        coinsList.add("oxtbtc");
        coinsList.add("bateth");
        coinsList.add("linketh");
        coinsList.add("oxteth");
        coinsList.add("ampusd");
        coinsList.add("compusd");
        coinsList.add("paxgusd");
        coinsList.add("mkrusd");
        coinsList.add("zrxusd");
        coinsList.add("kncusd");
        coinsList.add("manausd");
        coinsList.add("storjusd");
        coinsList.add("snxusd");
        coinsList.add("crvusd");
        coinsList.add("balusd");
        coinsList.add("uniusd");
        coinsList.add("renusd");
        coinsList.add("umausd");
        coinsList.add("yfiusd");
        coinsList.add("btcdai");
        coinsList.add("ethdai");
        coinsList.add("aaveusd");
        coinsList.add("filusd");

        return coinsList;
    }
        /*
        This part is just for web UI testing not required now...
        If you want to activate you should also activate lines in Driver class
        */


//    public static String getScreenshot(String name) throws IOException {
//        // naming the screenshot with the current date to avoid duplication
//        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        // TakesScreenshot is an interface of selenium that takes the screenshot
//        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        // full path to the screenshot location
//        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
//        File finalDestination = new File(target);
//        // save the screenshot to the path given
//        FileUtils.copyFile(source, finalDestination);
//        return target;
//    }
//    //========Switching Window=====//
//    public static void switchToWindow(String targetTitle) {
//        String origin = Driver.getDriver().getWindowHandle();
//        for (String handle : Driver.getDriver().getWindowHandles()) {
//            Driver.getDriver().switchTo().window(handle);
//            if (Driver.getDriver().getTitle().equals(targetTitle)) {
//                return;
//            }
//        }
//        Driver.getDriver().switchTo().window(origin);
//    }
//    //========Hover Over=====//
//    public static void hover(WebElement element) {
//        Actions actions = new Actions(Driver.getDriver());
//        actions.moveToElement(element).perform();
//    }
//    //==========Return a list of string given a list of Web Element====////
//    public static List<String> getElementsText(List<WebElement> list) {
//        List<String> elemTexts = new ArrayList<>();
//        for (WebElement el : list) {
//            if (!el.getText().isEmpty()) {
//                elemTexts.add(el.getText());
//            }
//        }
//        return elemTexts;
//    }
//    //========Returns the Text of the element given an element locator==//
//    public static List<String> getElementsText(By locator) {
//        List<WebElement> elems = Driver.getDriver().findElements(locator);
//        List<String> elemTexts = new ArrayList<>();
//        for (WebElement el : elems) {
//            if (!el.getText().isEmpty()) {
//                elemTexts.add(el.getText());
//            }
//        }
//        return elemTexts;
//    }
//    //===============Explicit Wait==============//
//    public static void waitFor(int sec) {
//        try {
//            Thread.sleep(sec * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
//        return wait.until(ExpectedConditions.visibilityOf(element));
//    }
//    public static WebElement waitForVisibility(By locator, int timeout) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
//    public static WebElement waitForClickablility(WebElement element, int timeout) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
//        return wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
//    public static WebElement waitForClickablility(By locator, int timeout) {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
//        return wait.until(ExpectedConditions.elementToBeClickable(locator));
//    }
//    public static void waitForPageToLoad(long timeOutInSeconds) {
//        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//            }
//        };
//        try {
//            System.out.println("Waiting for page to load...");
//            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
//            wait.until(expectation);
//        } catch (Throwable error) {
//            System.out.println(
//                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
//        }
//    }
//    //======Fluent Wait====//
//    public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
//        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
//                .withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(timeinsec, TimeUnit.SECONDS)
//                .ignoring(NoSuchElementException.class);
//        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                return webElement;
//            }
//        });
//        return element;
//    }
//
//    public static void executeJScript(String script){
//        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
//        jse.executeScript(script);
//    }
//
//    public static void openNewTab(){
//        executeJScript("window.open()");
//    }

}
