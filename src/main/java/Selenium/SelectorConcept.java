package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectorConcept {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://signup.ebay.com/pa/crte");
        //8 Types of Selectors
        //1.XPath -- 2
        //only relative xpath should be used
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("James", Keys.TAB);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Howlett",Keys.TAB);

        //2.ID -- 1
        driver.findElement(By.id("firstname")).sendKeys("James");
        driver.findElement(By.id("lastname")).sendKeys("Howlett");

        //3. Name -- 3
        driver.findElement(By.name("firstname")).sendKeys("James");
        driver.findElement(By.name("lastname")).sendKeys("Howlett");

        //4. LinkText : this is only for links
        driver.findElement(By.linkText("User Agreement")).click();

        //5. PartialLinkText -- not useful
        driver.findElement(By.partialLinkText("User Privacy")).click();

        //6. CSSSelector -- 2
        //if id is there ---- (#id)
        //if class is there ---- (.class)
        driver.findElement(By.cssSelector("#Email")).sendKeys("jameshowlett@gmail.com");

        //7. ClassName -- 4
        driver.findElement(By.className("")).sendKeys("");
        
        //
    }
}
