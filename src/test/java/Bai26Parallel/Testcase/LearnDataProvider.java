package Bai26Parallel.Testcase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.bouncycastle.cms.RecipientId.password;

public class LearnDataProvider {
    @DataProvider(name = "data_login",parallel  = false)
    public Object[][] dataLogin() {
        return new Object[][]{{"user1", "password1", 1}, {"user2", "password2", 2},{"user3", "password3", 3}};
    }
        @Test(dataProvider = "data_login")
                public void testLoginDataProvider(String user, String password, int position){
            System.out.println(user + "-"+password+"-"+position);
        }
    @DataProvider (name = "data-provider")
    public Object[][] dpMethod (Method m){
        switch (m.getName()) {
            case "Sum":
                return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
            case "Diff":
                return new Object[][] {{2, 3, -1}, {5, 7, -2}};
        }
        return null;
    }


    @Test(dataProvider = "data-provider")
    public void Sum(int a, int b, int result) {
        int sum = a + b;
        Assert.assertEquals(result, sum);
    }

    @Test(dataProvider = "data-provider")
    public void Diff(int a, int b, int result) {
        int diff = a - b;
        Assert.assertEquals(result, diff);
    }
    }

