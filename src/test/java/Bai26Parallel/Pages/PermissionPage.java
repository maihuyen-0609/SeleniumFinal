package Bai26Parallel.Pages;

import salary.com.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PermissionPage {
    private By buttonAdd = By.xpath("//button[@class='p-button p-component p-button-success mr-4']");
    private By inputName = By.xpath("//div[@role='dialog']//div[1]//span[1]//input[1]");
    private By inputPermissionName = By.xpath("//div[2]/div[2]/span/input");
    private By inputRemark = By.xpath("//div[2]/div[3]/span/input");
    private By buttonSubmit = By.xpath("//button[@class='p-button p-component']");
    private By textSuccess = By.xpath("//*[normalize-space()='Success']");
    private By search = By.xpath("//th[@class='is-tooltip name']//span[@class='pi pi-filter-icon pi-filter']");
    private By inputsearch = By.xpath("//input[@placeholder='Name']");
    private By buttonApply = By.xpath("//button[@class='p-button p-component p-button-sm']");
    private By selectPermission = By.xpath("(//td[contains(.,'Mina1')])[1]");
    private By buttonMore = By.xpath("//button[@class='p-button p-component p-button-icon-only p-button-rounded p-button-help mr-2']");
    private By buttonDelete = By.xpath("//div[@id='overlay_menu']//li[2]//div[1]");
    private By popupConfirm = By.xpath("//div[@role='dialog']");
    private By buttonYes = By.xpath("//button[.='Yes']");


    public void AddPermission(String name, String permissionname, String remark, String searchper) {
        WebUI.clickElement(buttonAdd);
        WebUI.setText(inputName, name);
        WebUI.setText(inputPermissionName, permissionname);
        WebUI.setText(inputRemark, remark);
        WebUI.clickElement(buttonSubmit);
        WebUI.getElementText(textSuccess);
        Assert.assertEquals(WebUI.getElementText(textSuccess).trim(), "Success123", "Text sai");
        WebUI.clickElement(search);
        WebUI.setText(inputsearch, searchper);
        WebUI.clickElement(buttonApply);
        WebUI.sleep(10);
    }

    public void DeletePermission() {
        WebUI.clickElement(selectPermission);
        WebUI.clickElement(buttonMore);
        WebUI.clickElement(buttonDelete);
        WebUI.getElementText(popupConfirm);
        Assert.assertEquals(WebUI.getElementText(popupConfirm).trim(), "Confirmation!\n" +
                "Are you sure you want to proceed?\n" +
                "No\n" +
                "Yes", "Textsai");
        WebUI.clickElement(buttonYes);
        WebUI.sleep(10);
    }
}
