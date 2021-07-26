package DEMO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FlipkartTestng {
    WebDriver driver;
    @BeforeMethod
    public void getBaseUrl(){
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.freecrm.com");
    }

    @Test
    public void verifyPageTitle(){
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"#1 Free CRM customer relationship management software cloud");
    }
    @Test
    public void verifyLogoTitle(){
        String LogoTitle=driver.findElement(By.xpath("//a//following::span[text() = \"your business cloud partner \"]")).getText();
        Assert.assertEquals(LogoTitle,"your business cloud partner ");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
