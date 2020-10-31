package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReUsableMethods;

public class FreeFormatterPage {
    public FreeFormatterPage(){

    }
    @FindBy(xpath="//textarea[@id='inputString']")
    public WebElement inputStringTextArea;

    @FindBy(xpath="//input[@id='secretKey']")
    public WebElement inputSecretKey;

    @FindBy(xpath="//form//select[@id='algoritm']")
    public WebElement selectDigestAlgoritm;

    @FindBy(xpath="//div//button[.='COMPUTE HMAC']")
    public WebElement btnComputeHmac;

    @FindBy(xpath="//textarea[@class='output']")
    public WebElement outputTextArea;


}
