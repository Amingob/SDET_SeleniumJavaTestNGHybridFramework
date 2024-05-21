package basetest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ReadConfig;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;



public class BaseTest {

    public WebDriver wdriver;

    ReadConfig readconfig = new ReadConfig();

    public String applicationURL = readconfig.getApplicationURL();
    public String txtUsername = readconfig.getUserName();
    public String txtUsername1 = readconfig.getUserName1();
    public String txtPassword = readconfig.getPassword();
    public String emptyString = readconfig.getEmptyString();
    public String edgePath = readconfig.getEdgePath();

    public Logger logger;



    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.edge.driver",""+edgePath+"");
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
