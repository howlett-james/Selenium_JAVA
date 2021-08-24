package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FindElementsConcept {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.ebay.com/");
        List <WebElement> LinkList= driver.findElements(By.tagName("a"));
        //size of linked list
        System.out.println(LinkList.size());
        for (WebElement webElement : LinkList) {
            System.out.println(webElement.getText());
        }
    }
}