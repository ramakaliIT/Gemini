package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;
    protected static ExtentHtmlReporter extentHtmlReporter;

    public void setExtentReports() {
        extentReports = new ExtentReports();//1. create object to set the location of the report
        String filePath = System.getProperty("user.dir") + "/test-output/myprojectreport.html";//create a custom report in the current project.
        //Folder name = test-output, File name = report.html
        //String filePath = System.getProperty("user.dir") + "\\test-output\\report.html";//THIS IS FOR WINDOWS USER
        extentHtmlReporter = new ExtentHtmlReporter(filePath);//2. creating the report with the path we created
        extentReports.attachReporter(extentHtmlReporter);//3. attaching the html report to our custom report
        //WE CAN ADD CUSTOM INFO. NOT NECESSARY. JUST TO GIVE MORE INFORMATION TO THE USER OR TEAM
        extentReports.setSystemInfo("Environment", "Environment Name");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("Automation Engineer", "ENGINEER INFORMATION");
        extentHtmlReporter.config().setDocumentTitle("Gemini Reports");
        extentHtmlReporter.config().setReportName("Gemini Automation Reports");

    }
}
