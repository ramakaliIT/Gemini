package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){               }

    /* ----------------- This page deactivated since there is no Web Compponent at  the moment --------------------------
        If you want to activate you should also activate lines in Driver class
    */

//    static WebDriver driver;
//
//    public static WebDriver getDriver(){
//
//        if (driver==null){
//
//            switch (ConfigReader.getProperty("browser")){
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driver=new ChromeDriver();
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver=new FirefoxDriver();
//                    break;
//                case "ie":
//                    WebDriverManager.iedriver().setup();
//                    driver = new InternetExplorerDriver();
//                    break;
//                case "safari":
//                    WebDriverManager.getInstance(SafariDriver.class).setup();
//                    driver = new SafariDriver();
//                    break;
//                case "chrome-headless":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
//                    break;
//            }
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.manage().window().maximize();
//        }
//        return driver;
//    }

//    public static void closeDriver(){
//        driver.close();
//        driver.quit();
//        driver=null;
//    }
}
