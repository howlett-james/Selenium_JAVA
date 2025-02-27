package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameHandling {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://letcode.in/");
        driver.findElement(By.xpath("//a[@id='testing']")).click();
        driver.findElement(By.xpath("//a[text()='Inner HTML']")).click();
        driver.switchTo().frame("firstFr");
        driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("james");
        driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("howlett");
        WebElement innerframe = driver.findElement(By.xpath("//iframe[@src='innerFrame']"));
        driver.switchTo().frame(innerframe);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jameshowlett@gmail.com");
    }
}