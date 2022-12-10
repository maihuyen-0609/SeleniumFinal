package Bai26Parallel.Testcase;

import Bai26Parallel.Pages.PageDashboard;
import Bai26Parallel.Pages.PageSignin;
import Bai26Parallel.Pages.PermissionPage;
import common.BaseTestNew;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import salary.com.utils.Log;

public class TestcasePermission extends BaseTestNew{
    private PageSignin pageLogin;
    private PageDashboard pageDashboard;
    private PermissionPage permissionPage;

    @BeforeMethod
    public void setupTest() {
        //lúc nào nó cũng khởi tạo trước
        //vì login luôn là hành động đầu tiên
        pageLogin = new PageSignin();
    }

    @Test
    @Parameters({"username","password"})
    public void testAddPermission(String username,String password) {
        pageDashboard=pageLogin.Login(username, password);
        permissionPage = pageDashboard.openPermissionpage();
        permissionPage.AddPermission("Mina1", "Mina1", "Mina", "Mina1");
        Log.info(username+password);
    }
    @Test
    @Parameters({"username","password"})
    public void testDeletePermission(String username,String password){
        pageDashboard = pageLogin.Login(username, password);
        permissionPage = pageDashboard.openPermissionpage();
        permissionPage.DeletePermission();
        Log.info(username+password);
    }

}
