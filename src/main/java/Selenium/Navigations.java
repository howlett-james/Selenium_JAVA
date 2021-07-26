package Selenium;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigations {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://google.com");
        driver.navigate().to("https://amazon.com");
        //get() Vs navigate.to() --- both are to launch the site but navigate.to() method is to navigate some external site from current site
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}
