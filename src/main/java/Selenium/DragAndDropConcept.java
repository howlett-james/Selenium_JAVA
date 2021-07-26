package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']")))
                .moveToElement(driver.findElement(By.xpath("//div[@id='droppable']"))).release().build().perform();


    }
}
