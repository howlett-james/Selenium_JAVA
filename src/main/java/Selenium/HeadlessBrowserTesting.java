package Selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessBrowserTesting {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless=new");
        FirefoxDriver driver = new FirefoxDriver(options);
        driver.get("http://facebook.com");
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
        driver.quit();
    }
}
