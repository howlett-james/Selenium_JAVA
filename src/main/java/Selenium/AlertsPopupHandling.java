package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class AlertsPopupHandling {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.findElement(By.xpath(("//input[@value='Sign in']"))).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        String alertmsg = alert.getText();
        if(alertmsg.equals("Please enter a valid user name")){
            System.out.println("Correct Alert Message");
        }else{
            System.out.println("Incorrect Alert Message");
        }
        alert.accept();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.quit();

    }
}
