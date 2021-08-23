package DEMO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class TestCase01 {

    WebDriver driver;
    @Parameters("browser")
    @BeforeMethod
    public void getBaseUrl(String browser) {
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",
                    ".\\Driver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else
        {
            System.setProperty("webdriver.gecko.driver",
                    ".\\Driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @Test
    public void sigin(){
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//a[@class = 'login']")).click();
        driver.findElement(By.id("email_create")).sendKeys("apj1@gmail.com");
        driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
        String errorText = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        if(errorText.contains("There are 8 errors")) {
            System.out.println("Error msg is displayed");
        }
        else {
            System.out.println("Error msg is not displayed");
        }

    }
    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
}