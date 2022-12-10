package Bai26Parallel.Pages;

import salary.com.Driver.DriverManager;
import salary.com.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PageSignin extends CommonPage {
    public PageSignin(){

    }

    private By inputAccount = By.xpath("//input[@placeholder='Account']");
    private By inputPassword=By.xpath("//input[@placeholder='Password']");
    private By buttonLogin=By.xpath("//button[@type='button']");
    private By buttonOAAccount=By.xpath("//span[@class='ml-2 font-bold text-blue-800']");
    private By inputIDNumber = By.xpath("//input[@placeholder='ID number']");
    private By inputPasswordOA=By.xpath("//input[@placeholder='Password']");
    private By buttonLoginOA=By.xpath("//button[@class='el-button login-button el-button--primary el-button--medium']");
    private By textPage=By.xpath("//h1[@class='text-center font-bold text-white text-6xl']");
    private By textPageOA=By.xpath("//div[@class='title-container']");
    private By alertMessage=By.xpath("//div[@class='p-toast p-component p-toast-top-right']");
    private By alertMessageOA=By.xpath("//div[@role='alert']");
    private By textWelcome=By.xpath("//h1[normalize-space()='Welcome, admin!']");
    private By textWelcome1=By.xpath("//h1[normalize-space()='Welcome, IT-Mina!']");
    public PageDashboard Login(String account, String password) {
        WebUI.openURL("http://172.18.0.246:9292/#/login");
        WebUI.checkElementExist(textPage);
        WebUI.setText(inputAccount,account);
        WebUI.setText(inputPassword,password);
        WebUI.clickElement(buttonLogin);
        WebUI.sleep(10);
       // WebUI.waitForElementVisible(textWelcome);
        return new PageDashboard();
    }

    public PageDashboard Loginwrongusername(String account, String password) {
        WebUI.openURL("http://172.18.0.246:9292/#/login");
        WebUI.checkElementExist(textPage);
        WebUI.setText(inputAccount,account);
        WebUI.setText(inputPassword,password);
        WebUI.clickElement(buttonLogin);
        WebUI.waitForElementVisible(alertMessage);
        boolean checkAlertError=WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertError,"Error not display");
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), "-1000002\n" +
                "user not allowed to log in345.","hic");
        return new PageDashboard();
    }
    public PageDashboard Loginwrongpassword(String account, String password) {
        WebUI.openURL("http://172.18.0.246:9292/#/login");
        WebUI.checkElementExist(textPage);
        WebUI.setText(inputAccount,account);
        WebUI.setText(inputPassword,password);
        WebUI.clickElement(buttonLogin);
        WebUI.waitForElementVisible(alertMessage);
        boolean checkAlertError=WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertError,"Error not display");
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), "-1000001\n" +
                "username or password is incorrect","hic");
        return new PageDashboard();
    }
    public PageDashboard LoginOASuccess(String accountOA, String passwordOA) {
        WebUI.openURL("http://172.18.0.246:9292/#/login");
        WebUI.clickElement(buttonOAAccount);
        DriverManager.getDriver().switchTo().frame(0);
        WebUI.getElementText(textPageOA);
        WebUI.verifyEquals(WebUI.getElementText(textPageOA).trim(),"Office management system");
        WebUI.setText(inputIDNumber,accountOA);
        WebUI.setText(inputPasswordOA,passwordOA);
        WebUI.clickElement(buttonLoginOA);
        WebUI.sleep(10);
        WebUI.waitForElementVisible(textWelcome1);
        return new PageDashboard();
    }
    public PageDashboard LoginOAfail(String accountOA, String passwordOA) {
        WebUI.openURL("http://172.18.0.246:9292/#/login");
        WebUI.clickElement(buttonOAAccount);
        DriverManager.getDriver().switchTo().frame(0);
        WebUI.getElementText(textPageOA);
        WebUI.verifyEquals(WebUI.getElementText(textPageOA).trim(),"Office management system");
        WebUI.setText(inputIDNumber,accountOA);
        WebUI.setText(inputPasswordOA,passwordOA);
        WebUI.clickElement(buttonLoginOA);
        WebUI.sleep(10);
        WebUI.waitForElementVisible(alertMessageOA);
        boolean checkAlertError=WebUI.checkElementExist(alertMessageOA);
        Assert.assertTrue(checkAlertError,"Error not display");
        WebUI.verifyEquals(WebUI.getElementText(alertMessageOA), "-1000001\n" +
                "username or password is incorrect","hic");
        return new PageDashboard();
    }
}