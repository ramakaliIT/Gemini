package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReUsableMethods;

public class Base64EncodePage {

    public Base64EncodePage(){

    }

    @FindBy(xpath="//form//textarea[@id='input']")
    public WebElement inputTextBox;

    @FindBy(xpath="//form//button[@id='option_text_live']")
    public WebElement liveBtn;

    @FindBy(xpath="//textarea[@id='output']")
    public WebElement outputTextBox;

    @FindBy(xpath="//select[@id='option_text_seperator']")
    public WebElement selectTextCodingTextBox;

}
