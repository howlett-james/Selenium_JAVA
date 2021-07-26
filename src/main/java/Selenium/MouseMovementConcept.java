package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseMovementConcept {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        /*actions.moveToElement(driver.findElement(By.xpath("//a[text()='Add-Ons']"))).build().perform();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Seat + Meal Combo")).click();*/
        actions.moveToElement(driver.findElement(By.linkText("Login / Signup")))
                .moveToElement(driver.findElement(By.linkText("SpiceClub Members")))
                .moveToElement(driver.findElement(By.linkText("Sign up"))).click().build().perform();
    }
}
