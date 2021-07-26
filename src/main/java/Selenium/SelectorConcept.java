package Selenium;

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
        driver.findElementByXPath("//input[@name='firstname']").sendKeys("James", Keys.TAB);
        driver.findElementByXPath("//input[@name='lastname']").sendKeys("Howlett",Keys.TAB);

        //2.ID -- 1
        driver.findElementById("firstname").sendKeys("James");
        driver.findElementById("lastname").sendKeys("Howlett");

        //3. Name -- 3
        driver.findElementByName("firstname").sendKeys("James");
        driver.findElementByName("lastname").sendKeys("Howlett");

        //4. LinkText : this is only for links
        driver.findElementByLinkText("User Agreement").click();

        //5. PartialLinkText -- not useful
        driver.findElementByPartialLinkText("User Privacy").click();

        //6. CSSSelector -- 2
        //if id is there ---- (#id)
        //if class is there ---- (.class)
        driver.findElementByCssSelector("#Email").sendKeys("jameshowlett@gmail.com");

        //7. ClassName -- 4
        driver.findElementByClassName("").sendKeys("");
        
        //
    }
}
