package Bai26Parallel.Testcase;

import Bai26Parallel.Pages.PageDashboard;
import Bai26Parallel.Pages.PageSignin;
import Bai26Parallel.Pages.RolePage;
import salary.com.Helper.PropertiesHelper;
import common.BaseTestNew;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestcaseRole extends BaseTestNew{
    private PageSignin pageSignin;
    private PageDashboard pageDashboard;
    private RolePage rolePage;

    @BeforeMethod
    public void SetupTest(){
        pageSignin =new PageSignin();
        PropertiesHelper.setFile("src/test/resources/role.properties");
    }
    @Test
    @Parameters({"username","password"})
    public void AddRole(String username, String password){
        pageDashboard=pageSignin.Login(username,password);
        rolePage=pageDashboard.openRolepage();
        rolePage.AddRole(PropertiesHelper.getValue("name"),PropertiesHelper.getValue("rolename"),PropertiesHelper.getValue("remark"), PropertiesHelper.getValue("search"));
    }
    @Test
   @Parameters({"username","password"})
    public void DeleteRole(String username, String password){
        pageDashboard=pageSignin.Login(username,password);
        rolePage=pageDashboard.openRolepage();
        rolePage.DeleteRole(PropertiesHelper.getValue("search"));
    }
}
