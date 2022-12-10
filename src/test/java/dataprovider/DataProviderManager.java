package dataprovider;
import salary.com.Helper.ExcelHelpers;
import salary.com.Helper.Helpers;
import org.testng.annotations.DataProvider;
public class DataProviderManager {

    @DataProvider(name = "data_provider_login",parallel = true)
    public Object[][] dataLoginSalary() {
        return new Object[][]{{"admin", "123456"}};
    }
    @DataProvider(name = "data_provider_login_excel",parallel = true)
    public Object[][] dataLoginSalaryFromExcel() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getExcelData(Helpers.getCurrentDir() + "datatest/login2field.xlsx", "Sheet1");
        System.out.println("Login Data from Excel: " + data);
        return data;
    }
    @DataProvider(name = "data_provider_login_excel_by_row",parallel = true)
    public Object[][] dataLoginSalaryFromExcelmanyfield() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getExcelDataHashTable(Helpers.getCurrentDir() + "datatest/login.xlsx", "Sheet1",2, 5);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }
    }

