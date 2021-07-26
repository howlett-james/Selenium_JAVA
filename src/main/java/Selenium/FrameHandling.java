package Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameHandling {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://letcode.in/");
        driver.findElementByXPath("//a[@id='testing']").click();
        driver.findElementByXPath("//a[text()='Inner HTML']").click();
        driver.switchTo().frame("firstFr");
        driver.findElementByXPath("//input[@name='fname']").sendKeys("james");
        driver.findElementByXPath("//input[@name='lname']").sendKeys("howlett");
        WebElement innerframe = driver.findElementByXPath("//iframe[@src='innerFrame']");
        driver.switchTo().frame(innerframe);
        driver.findElementByXPath("//input[@name='email']").sendKeys("jameshowlett@gmail.com");
    }
}