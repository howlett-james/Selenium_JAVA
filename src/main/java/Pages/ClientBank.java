package Pages;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClientBank extends Pages.DateUtil {
    WebDriver driver;

    @BeforeTest
    public void loadRedBus() {
        System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://salesdemo.habiletechnologies.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }

    @Test
    public void login() {
        driver.findElement(By.name("username")).sendKeys("qatest@habile.in");
        driver.findElement(By.name("password")).sendKeys("Qatest123$");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//a[@href='#/createclient']")).click();
    }

    @Test
    @SneakyThrows
    public void client() {
        driver.findElement(By.xpath("//a[@href='#/createclient']")).click();
//        Select select = new Select(driver.findElement());

    }

}
