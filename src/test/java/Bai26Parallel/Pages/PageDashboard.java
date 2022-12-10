package Bai26Parallel.Pages;

import salary.com.utils.WebUI;
import org.openqa.selenium.By;

public class PageDashboard {
    public By menuPermission = By.xpath("//a[@aria-label='menu.adminTool.permission']");
    private By menuRole=By.xpath("//a[@aria-label='menu.adminTool.role']");
    private By menuRoute=By.xpath("//a[@aria-label='menu.adminTool.route']");
    public PermissionPage openPermissionpage() {
        WebUI.clickElement(menuPermission);
        return new PermissionPage();
    }
    public RolePage openRolepage() {
        WebUI.clickElement(menuRole);
        return new RolePage();
    }
}
