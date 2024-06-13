package basetest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utilities.ReadConfig;

import java.io.File;
import java.util.concurrent.TimeUnit;



public class BaseTest {

    public WebDriver wdriver;

    ReadConfig readconfig = new ReadConfig();

    public String applicationURL = readconfig.getApplicationURL();
    public String txtUsername = readconfig.getUserName();
    public String txtUsername1 = readconfig.getUserName1();
    public String txtPassword = readconfig.getPassword();
    public String emptyString = readconfig.getEmptyString();


    public Logger logger;


    @Parameters("browser")
    @BeforeMethod
    public void setUp(String strBrowser){

        if(strBrowser.equalsIgnoreCase("edge")) {

            System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
            wdriver = new EdgeDriver();
        }else if(strBrowser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
            wdriver = new ChromeDriver();

        }else if(strBrowser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
            File pathToBinary = new File(readconfig.getFireFoxPath());
            FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
            FirefoxProfile firefoxProfile = new FirefoxProfile();
             wdriver = new FirefoxDriver();

        }

        wdriver.manage().window().maximize();
        wdriver.manage().deleteAllCookies();
        wdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        logger = Logger.getLogger("BaseTest");
        PropertyConfigurator.configure("ConfigurationFiles/Log4j.properties");

        logger.info("Test: Login Test : has started");

    }

    @AfterMethod
    public void tearDown(){

        logger.info("Test: Login Test : has completed");
        wdriver.quit();
    }

}
