package testscripts;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class T001LoginTest extends BaseTest {

    LoginPage loginPage;
    private String expectedString = "Guru99 Bank Manager HomePage";

    @Test(priority=1)
    public void t001LoginTest_With_Valid_Username_And_Valid_PassWord() throws InterruptedException {

        logger.info("Test: t001LoginTest_With_Valid_Username_And_Valid_PassWord : has started");

        wdriver.get("https://demo.guru99.com/V4/");
        loginPage = new LoginPage(wdriver);
        loginPage.submitUsername(txtUsername);
        loginPage.submitPassword(txtPassword);
        Thread.sleep(2000);
        loginPage.submitLogin();

        String actualString = wdriver.getTitle();

        Assert.assertEquals(actualString,expectedString,"Test has Passed");
        Thread.sleep(3000);

        logger.info("Test: t001LoginTest_With_Valid_Username_And_Valid_PassWord : has completed");
    }

    @Test(priority=2)
    public void t001LoginTest_With_Valid_Username_And_InValid_PassWord() throws InterruptedException{

        logger.info("Test: t001LoginTest_With_Valid_Username_And_InValid_PassWord : has started");

        wdriver.get("https://demo.guru99.com/V4/");
        loginPage = new LoginPage(wdriver);
        loginPage.submitUsername(txtUsername);
        loginPage.submitPassword(txtPassword+"1");
        Thread.sleep(3000);
        loginPage.submitLogin();

        String actualString = wdriver.getTitle() ;

        Assert.assertEquals(actualString,expectedString,"Test has Passed");
        Thread.sleep(3000);

        logger.info("Test: t001LoginTest_With_Valid_Username_And_InValid_PassWord : has completed");
    }

    @Test(priority=3)
    public void t001LoginTest_With_InValid_Username_And_Valid_PassWord() throws InterruptedException{

        logger.info("Test: t001LoginTest_With_InValid_Username_And_Valid_PassWord : has started");

        wdriver.get("https://demo.guru99.com/V4/");
        loginPage = new LoginPage(wdriver);
        loginPage.submitUsername("Q"+txtUsername1+"Q");
        Thread.sleep(3000);
        loginPage.submitPassword(txtPassword);
        loginPage.submitLogin();

        String actualString = wdriver.getTitle() ;

        Assert.assertEquals(actualString,expectedString,"Test has Passed");
        Thread.sleep(3000);

        logger.info("Test: t001LoginTest_With_InValid_Username_And_Valid_PassWord : has completed");
    }

    @Test(priority=4)
    public void t001LoginTest_With_INValid_Username_And_INValid_PassWord() throws InterruptedException{

        logger.info("Test: t001LoginTest_With_INValid_Username_And_INValid_PassWord : has started");

        wdriver.get("https://demo.guru99.com/V4/");
        loginPage = new LoginPage(wdriver);
        loginPage.submitUsername(txtUsername+"Q");
        loginPage.submitPassword(txtPassword+"1");
        Thread.sleep(3000);
        loginPage.submitLogin();

        String actualString = wdriver.getTitle() ;

        Assert.assertEquals(actualString,expectedString,"Test has Passed");
        Thread.sleep(3000);

        logger.info("Test: t001LoginTest_With_INValid_Username_And_INValid_PassWord : has completed");
    }

    @Test(priority=5)
    public void t001LoginTest_With_No_Username_And_No_PassWord() throws InterruptedException{

        logger.info("Test: t001LoginTest_With_No_Username_And_No_PassWordd : has started");

        wdriver.get("https://demo.guru99.com/V4/");
        loginPage = new LoginPage(wdriver);
        loginPage.submitUsername(emptyString);
        loginPage.submitPassword(emptyString);
        Thread.sleep(3000);
        loginPage.submitLogin();

        String actualString = wdriver.getTitle() ;

        Assert.assertEquals(actualString,expectedString,"Test has Passed");
        Thread.sleep(3000);

        logger.info("Test: t001LoginTest_With_No_Username_And_No_PassWordd : has completed");
    }
}
