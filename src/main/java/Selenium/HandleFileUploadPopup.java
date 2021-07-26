package Selenium;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HandleFileUploadPopup {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://html.com/input-type-file/");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.findElementByXPath("//input[@id='fileupload']").sendKeys("D:\\yokeshwara+rao.pdf");
        Thread.sleep(5000);
        driver.quit();
    }
}
