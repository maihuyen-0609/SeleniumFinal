package listener;

import com.aventstack.extentreports.Status;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import salary.com.Driver.DriverManager;
import salary.com.Helper.CaptureHelpers;
import salary.com.reports.ExtentReportManager;
import salary.com.reports.ExtentTestManager;
import salary.com.utils.Log;

public class Testlistener implements ITestListener {
    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName()
                : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }
    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info(result.getName()+"is skipped");
        ExtentTestManager.logMessage(Status.SKIP, result.getName()+"is skipped");

    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.saveToReport(result.getName(),"");


    }
    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(result.getName()+"is passed");
        ExtentTestManager.logMessage(Status.PASS, result.getName()+"is passed");

    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName()+"is failed");
        CaptureHelpers.takescreenshot(result);
        Log.error(result.getName()+"is failed");
        //Extent report
        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL,result.getName()+"is failed");
        //Allure report
        saveTextLog(result.getName());
        saveScreenshotPNG();

    }
    @Override
    public void onFinish(ITestContext result) {
        Log.info("Finish suite: "+result.getEndDate());
        //Kết thúc và thực thi Extents Report
        ExtentReportManager.getExtentReports().flush();
        //Gọi hàm stopRecord video trong CaptureHelpers class
        CaptureHelpers.stopRecord();

    }

    @Override
    public void onStart(ITestContext result) {
        Log.info("Start suite: "+result.getStartDate());
        CaptureHelpers.startRecord(result.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }



}
