package Bai26Parallel.Pages;

import salary.com.utils.WebUI;
import org.openqa.selenium.By;

public class CommonPage {
    //class chung
    private PageSignin pageSignin;
    private PageDashboard pageDashboard;
    private PermissionPage permissionPage;
    //object chung
    public By buttonAccount= By.xpath("//div[@class='p-avatar p-component p-avatar-circle cursor-pointer avatar']");
    public By buttonEditPassword=By.xpath("//div[@id='overlay_menu']//li[1]//a[1]");
    public By buttonLogout=By.xpath("//span[normalize-space()='Log out']");
    public By buttonLanguage=By.xpath("//span[@class='flag f-gb-eng normal-flag language-select']");
    public By buttonChinese=By.xpath("//span[@class='flag f-gb-eng normal-flag language-select']");
    public By buttonEnglish=By.xpath("//div[@id='overlay_menu']//li[2]//div[1]");
    public By buttonTiengviet=By.xpath("//div[@id='overlay_menu']//li[3]//div[1]");
    public By buttonHome=By.xpath("//a[contains(.,'Salary system')]");
    //hàm chung để get khởi tạo của các trang khai báo trên và các hàm xử lí chung

    public PageSignin Logout(){
        WebUI.clickElement(buttonAccount);
        WebUI.clickElement(buttonLogout);
        return new PageSignin();
    }
    public PageSignin getPageSignin(){
        if(pageSignin==null){
            pageSignin=new PageSignin();
        }
        return pageSignin;
    }
    public PageDashboard getPageDashboard(){
        if(pageDashboard==null){
            pageDashboard=new PageDashboard();
        }
        return pageDashboard;
    }
    public PermissionPage getPermissionPage(){
        if(permissionPage==null){
            permissionPage=new PermissionPage();
        }
        return permissionPage;
    }

}
