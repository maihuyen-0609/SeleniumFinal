package Bai26Parallel.Testcase;

import common.BaseTestNew;
import io.github.bonigarcia.wdm.WebDriverManager;
import listener.Testlistener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.SkipException;
import salary.com.Driver.DriverManager;

@Listeners(Testlistener.class)
    public class LearnTestListener  {

        WebDriver driver;

        @BeforeClass
        public void setupDriver() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            DriverManager.setDriver(driver);
        }

        @Test(priority = 1) //Success Test
        public void gotoPage() {
            driver.get("https://anhtester.com");
        }

        @Test(priority = 2) //Failed Test
        public void checkTitle() {
            String expectedTitle = "Anh Tester";
            String originalTitle = driver.getTitle();
            Assert.assertEquals(originalTitle, expectedTitle, "Title of the website do not match");
        }

        @Test(priority = 3)  //Skip Test
        public void skipTest() {
            throw new SkipException("Skipping The Test Method ");
        }
        @Test(priority = 2) //Failed Test
        public void checkUrl() {
            String expectedTitle = "Anh Tester";
            String originalTitle = driver.getCurrentUrl();
            Assert.assertEquals(originalTitle, expectedTitle, "Title of the website do not match");
        }

        @AfterClass
        public void closeDriver() {
            driver.quit();
        }
    }


