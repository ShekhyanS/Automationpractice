package listener;

import driver.DriverSingletone;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SuiteListener  extends TestListenerAdapter  {

    private static Logger logger = Logger.getLogger(SuiteListener.class);
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Taking a screenshot");

        try {
            takeScreenshot(iTestResult);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        logger.info("********************************************************************");
        logger.info("Failed ---> " + iTestResult.getName());
        logger.info("********************************************************************");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("********************************************************************");
        logger.info("STARTED ---> " + iTestResult.getName());
        logger.info("********************************************************************");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("********************************************************************");
        logger.info("FINISHED ---> " + iTestResult.getName());
        logger.info("********************************************************************");
    }

    private void takeScreenshot(ITestResult iTestResult) throws MalformedURLException {
        File scrFile = ((TakesScreenshot) DriverSingletone.getDriver()).getScreenshotAs(OutputType.FILE);

        Date date = new Date();

        File screenShotName = new File("target\\test-results\\screenshots\\" + date.getTime() + iTestResult.getName()+ ".png"
        );

        try {
            FileUtils.copyFile(scrFile, screenShotName);
        } catch (IOException e) {
            logger.info("Issue with screenshot file -> " + screenShotName.toString());
            e.printStackTrace();
        }
    }
}
