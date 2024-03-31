package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest
{
    public static WebDriver driver;
    public static FileReader fr;
    public static FileReader fr1;
    public static Properties prop = new Properties();;
    public static Properties loc = new Properties();

    @BeforeMethod
    public void setup() throws IOException
    {
            if(driver==null)
            {
                fr = new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\configfiles\\config.properties");
                prop.load(fr);

                fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\configfiles\\locators.properties");
                loc.load(fr1);
            }

        if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("testurl"));
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("testurl"));
        }

    }

    @AfterMethod
    public void tearDown()
    {
        driver.close();

    }

}
