package Selenium;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CustomXPath {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
        driver.get("https:https://www.ebay.com/");
        driver.findElementByXPath("//input[@aria-label='Search for anything']").sendKeys("java");
        driver.findElementByXPath("//input[@placeholder='Search for anything']").sendKeys("python");
        driver.findElementByXPath("//input[@type='text']").sendKeys("javascript");
        driver.findElementByXPath("//input[contains(@type,'text')]").sendKeys("R");
        //when ID is dynamically changing -- id = text__541,text__112,... or 121__text,135__text,...
        driver.findElementByXPath("//input[contains(@id,'text_')]").sendKeys("sample");
        //starts-with --- id = text__654, text__488,...
        driver.findElementByXPath("//input[starts-with(@id,'text')]").sendKeys("sample");
        //ends-with --- id = 649__text, 549__text,...
        driver.findElementByXPath("//input[ends-with(@id,'text')]").sendKeys("sample");
        //When Class is dynamically changing
        driver.findElementByXPath("//input[contains(@class,'classname_')]").sendKeys("sample");
        //for links: custom xpath
        //all links are represented by <a> tag
        driver.findElementByXPath("//a[contains(text(),'My Account')]").click();

    }
}
