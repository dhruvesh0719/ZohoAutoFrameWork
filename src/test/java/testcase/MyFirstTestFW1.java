package testcase;


import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ReadXLSdata;

public class MyFirstTestFW1 extends BaseTest
{
    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "LoginData")
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


}

