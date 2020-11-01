package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before(order = 1)
    public void setUp(){
        //Nothing required at the moment;
    }


    @After
    public void tearDown(Scenario scenario){
        //Nothing required at the moment;
//        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//        if (scenario.isFailed()) {
//            scenario.attach(screenshot, "image/png","fail");
//        }
//        Driver.closeDriver();
    }

}
