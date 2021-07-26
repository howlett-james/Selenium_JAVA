package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class HandleDropBox{
    public static void main(String[] args){
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//a[text()='English (UK)']").click();
        driver.findElementByXPath("//a[@data-testid='open-registration-form-button']").click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Select s = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        s.selectByVisibleText("21");
        /*s.selectByIndex(21);
        s.selectByValue("21");*/
        Select s1 =  new Select(driver.findElementByXPath("//select[@id='month']"));
        s1.selectByVisibleText("Aug");
        driver.findElementByXPath("//img[@src='https://static.xx.fbcdn.net/rsrc.php/v3/yC/r/Q0G2UVjVQ4_.png']").click();
    }
}