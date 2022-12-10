package Bai26Parallel.Testcase;

import common.BaseTestNew;
import dataprovider.DataProviderManager;
import salary.com.Helper.CaptureHelpers;
import org.testng.annotations.Test;

public class LearnScreenshot extends BaseTestNew {

    @Test(priority = 0, dataProvider = "data_provider_login", dataProviderClass = DataProviderManager.class)
    public void LoginSalaryProvider(String username, String password) {
        CaptureHelpers.startRecord("LoginSalaryProvider");
        getPageSignin().Login(username, password);
        Logout();
    }
    @Test(priority = 1, dataProvider = "data_provider_login", dataProviderClass = DataProviderManager.class)
    public void LoginSalaryProvider1(String username, String password) {
        getPageSignin().Login(username, password);
        Logout();
    }
}
