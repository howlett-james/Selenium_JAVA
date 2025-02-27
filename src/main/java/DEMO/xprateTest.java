package DEMO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class xprateTest {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.findElement(By.xpath(("//input[@name='q']"))).sendKeys("xprate", Keys.ENTER);
        driver.findElement(By.xpath(("//a[@href=\"https://www.xprate.com/\"]"))).click();
        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
        driver.findElement(By.xpath(("//b[text()='Sign up / Sign in']"))).click();
        System.out.println(driver.findElement(By.xpath(("//b[text()='Sign up / Sign in']"))).getText());
        driver.findElement(By.xpath(("//span[text()=\"Create Account / Sign In\"]"))).click();
        driver.findElement(By.xpath(("//input[@id=\"email\"]"))).sendKeys("yokeshwararao@hotmail.com",Keys.TAB);
        driver.findElement(By.xpath(("//input[@id='name']"))).sendKeys("YOKESH",Keys.TAB);
        driver.findElement(By.xpath(("//input[@id='password']"))).sendKeys("Yokesh@2108");
        driver.findElement(By.xpath(("//span[text()='Start To Peek']"))).click();
        Thread.sleep(5000);
        driver.quit();
    }
}