package Selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Iterator;
import java.util.Set;

public class HandleWindowPopup {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.seleniumeasy.com/");
        driver.findElementByLinkText("Demo Website!").click();
        driver.findElementByLinkText("Alerts & Modals").click();
        driver.findElementByLinkText("Window Popup Modal").click();
//        driver.findElementByXPath("//a[contains(text(),'  Follow On Twitter ')]").click();
        String parent = driver.getWindowHandle();
        /*String parentwindow = it.next();
        System.out.println("Parent Window ID:"+parentwindow);

        String childwindow = it.next();
        System.out.println("Child Window ID:"+childwindow);

        driver.switchTo().window(childwindow);
        Thread.sleep(5000);
        System.out.println("Child Window Title:"+driver.getTitle());

        driver.close();

        driver.switchTo().window(parentwindow);
        System.out.println("Parent Window Title:"+driver.getTitle());*/
        /*driver.findElementByXPath("//a[text()='Follow Twitter & Facebook']").click();
        Set<String> handler = driver.getWindowHandles();
        Iterator<String> it = handler.iterator();
        while (it.hasNext()){
            String ChildWindow = it.next();
            if(!parent.equals(ChildWindow)){
                driver.switchTo().window(ChildWindow);
                Thread.sleep(5000);
                System.out.println(driver.switchTo().window(ChildWindow).getTitle());
                driver.close();
            }
        }*/
        driver.findElementByXPath("//a[text()='Follow Twitter & Facebook']").click();
        Set<String> handler = driver.getWindowHandles();
        for (String ChildWindow : handler) {
            if (!parent.equals(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                Thread.sleep(5000);
                System.out.println(driver.switchTo().window(ChildWindow).getTitle());
                driver.close();
            }
        }
        driver.quit();
    }
}