package testcase;


import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyFirstTestFW extends BaseTest
{
    @Test(dataProvider = "testdata")
    public static void LoginTest(String username, String password) throws InterruptedException
    {

        driver.manage().window().maximize();

        driver.findElement(By.xpath(loc.getProperty("signin_link"))).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath(loc.getProperty("email_field"))).sendKeys(username);
        driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys(password);
        driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
    }

    @DataProvider(name = "testdata")
    public Object[][] tData()
    {
        return new Object[][]
                {
                        {"dhruvesh_@yahoo.co.in", "Dpd282905"},
                        {"dhresh_chand@yahoo.co.in", "Dpd2905"},
                        {"dhruvesh_chand@yahoo", "Dpd282905"},
                        {"dhruvesh_chand@yahoo.co.in", "Dpd282905"}
                };
    }
}
