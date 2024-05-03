package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver wdriver;
    @BeforeClass
    public void setUp(){

        System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
        wdriver = new EdgeDriver();
        wdriver.get("https://demo.guru99.com/V4/");
    }

    @AfterClass
    public void tearDown(){
        wdriver.quit();
    }

}
