package common;

import Bai26Parallel.Pages.CommonPage;
import listener.Testlistener;
import salary.com.Driver.DriverManager;
import salary.com.Helper.CaptureHelpers;
import salary.com.Helper.PropertiesHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
@Listeners(Testlistener.class)

public class BaseTestNew extends CommonPage {
    public BaseTestNew(){
        PropertiesHelper.loadAllFiles();
    }

    @BeforeSuite
    public void setupAutomation(){
        System.out.println("Load file config ");
    }
    @BeforeMethod
    @Parameters({"browser"})
    public static void createDriver(@Optional("chrome")String browserName, ITestResult result){
        WebDriver driver = setupDriver(browserName);
        DriverManager.setDriver(driver);
        //DriverManager.setDriver(setupDriver(browserName)); viết ngắn gọn nè
        CaptureHelpers.startRecord(result.getName());
    }
    //Hàm trung gian để lựa chọn browser
    public static WebDriver setupDriver(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }
    //Viết hàm khởi tạo cho từng browser
    private static WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(DriverManager.getDriver()!=null){
            DriverManager.quit();
        }
    }
    @AfterSuite
    public void setupCloseAutomation(){
        System.out.println("close automation test");
    }
}
