package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PHPAgency {
    WebDriver driver;
    HomePage homePage;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://dev-oneworld.thephpagency.com/agent/signin");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    @Test
    public void HomePageUITest(){
        homePage = new HomePage(driver);
        homePage.logocheck();
        homePage.loginPHPAgency("735490","Php2021!");
    }

    @AfterTest
    public void tearDown()throws InterruptedException{
        Thread.sleep(5000);

        driver.quit();
    }
}
