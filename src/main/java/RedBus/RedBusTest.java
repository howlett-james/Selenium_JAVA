package RedBus;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RedBusTest {
    static WebDriver driver;
    static Properties prop;
    static FileInputStream ip;
    @BeforeTest
    public void getUrl() throws IOException {
        prop = new Properties();
        ip = new FileInputStream("C:\\Users\\yokes\\IdeaProjects\\Selenium.JAVA\\src\\main\\java\\RedBus\\config.properties");
        prop.load(ip);
        String url = prop.getProperty("URL");
        String browserName = prop.getProperty("browser");
        if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
            driver = new ChromeDriver();
        }else {
            System.setProperty("webdriver.edge.driver","./Driver/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    }

    @Test
    public void searchBus() throws IOException, InterruptedException {
        prop.load(ip);
        driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Coimbatore", Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Chennai", Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='src']")).click();
        Thread.sleep(2500);
        driver.findElement(By.xpath("//td[@class='next']")).click();
        driver.findElement(By.xpath("//td[text()='8']")).click();
        driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
    }
    @AfterTest
    public void TestDown()throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
}
