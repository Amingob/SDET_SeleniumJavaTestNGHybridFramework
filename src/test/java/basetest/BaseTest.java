package basetest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;



public class BaseTest {

    public WebDriver wdriver;

    public String txtUsername = "mngr568917";
    public String txtUsername1 = "mngr568917T";
    public String txtPassword = "YnArYrU";
    public String emptyString = "";

    public Logger logger;


    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
        wdriver = new EdgeDriver();
        wdriver.manage().window().maximize();
        wdriver.manage().deleteAllCookies();
        wdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        logger = Logger.getLogger("BaseTest");
        PropertyConfigurator.configure("Log4j.properties");

        logger.info("Test: Login Test : has started");

    }

    @AfterMethod
    public void tearDown(){

        logger.info("Test: Login Test : has completed");
        wdriver.quit();
    }

}
