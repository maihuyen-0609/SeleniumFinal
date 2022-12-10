package Bai26Parallel.Pages;

import salary.com.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RolePage extends CommonPage {
    private By buttonAdd = By.xpath("//span[normalize-space()='Add']");
    private By inputName = By.xpath("(//input[@modelmodifiers='[object Object]'])[1]");
    private By inputRoleName = By.xpath("(//input[@modelmodifiers='[object Object]'])[2]");
    private By inputRemark = By.xpath("(//input[@modelmodifiers='[object Object]'])[3]");
    private By buttonSubmit = By.xpath("//button[@class='p-button p-component']");
    private By alertSuccess = By.xpath("//div[@class='p-toast p-component p-toast-top-right']//div");
    private By buttonFilter = By.xpath("//th[@class='is-tooltip name']//span[@class='pi pi-filter-icon pi-filter']");
    private By inputnamesearch = By.xpath("//input[@placeholder='Name']");
    private By buttonApply = By.xpath("//button[@class='p-button p-component p-button-sm']");
    private By role = By.xpath("//td[@class='is-tooltip name']");
    private By buttonMore = By.xpath("//span[@class='pi pi-ellipsis-h p-button-icon']");
    private By buttonDelete = By.xpath("//div[.='Delete']");
    private By popupConfirm = By.xpath("//div[@role='dialog']");
    private By buttonYes = By.xpath("//button[.='Yes']");
    private By buttonClear=By.xpath("//button[contains(.,'Clear')]");



    public PageDashboard AddRole(String name, String rolename, String remark, String search) {
        WebUI.clickElement(buttonAdd);
        WebUI.setText(inputName, name);
        WebUI.setText(inputRoleName, rolename);
        WebUI.setText(inputRemark, remark);
        WebUI.clickElement(buttonSubmit);
        WebUI.waitForElementVisible(alertSuccess);
        boolean checkAlertError = WebUI.checkElementExist(alertSuccess);
        Assert.assertTrue(checkAlertError, "Error not display");
        WebUI.verifyEquals(WebUI.getElementText(alertSuccess), "Success\n" +
                "Added successfully!", "hic");
        WebUI.clickElement(buttonFilter);
        WebUI.clickElement(inputnamesearch);
        WebUI.setText(inputnamesearch, search);
        WebUI.clickElement(buttonApply);
        WebUI.sleep(5);
        WebUI.clickElement(buttonClear);
        return new PageDashboard();
    }

    public PageDashboard DeleteRole(String search) {
        WebUI.clickElement(buttonFilter);
        WebUI.clickElement(inputnamesearch);
        WebUI.setText(inputnamesearch, search);
        WebUI.clickElement(buttonApply);
        WebUI.sleep(5);
        WebUI.clickElement(role);
        WebUI.clickElement(buttonMore);
        WebUI.clickElement(buttonDelete);
        WebUI.getElementText(popupConfirm);
        Assert.assertEquals(WebUI.getElementText(popupConfirm).trim(), "Confirmation!\n" +
                "Are you sure you want to proceed?\n" +
                "No\n" +
                "Yes", "Textsai");
        WebUI.clickElement(buttonYes);
        WebUI.sleep(10);
return new PageDashboard();
    }

}
