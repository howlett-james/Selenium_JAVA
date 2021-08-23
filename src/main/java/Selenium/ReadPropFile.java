package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ReadPropFile {
    static WebDriver driver;
    static Properties prop;
    static FileInputStream ip;
    @BeforeTest
    public void getUrl() throws IOException {
        prop = new Properties();
        ip = new FileInputStream("C:\\Users\\yokes\\IdeaProjects\\Selenium.JAVA\\src\\main\\resources\\config.properties");
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
        driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
    }
    @Test
    public void createAccount() throws IOException {
        prop.load(ip);
        driver.findElement(By.xpath(prop.getProperty("CreateAccount_Xpath"))).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("Firstname"));
        driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("Lastname"));
        driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("Email"));
        driver.findElement(By.xpath(prop.getProperty("confirmEmail_xpath"))).sendKeys(prop.getProperty("Email"));
        driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("Password"));
        driver.findElement(By.xpath(prop.getProperty("Escape"))).click();
    }
    @Test(priority = 1)
    public void SignIn()throws IOException{
        prop.load(ip);
        driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(prop.getProperty("Email"));
        driver.findElement(By.xpath(prop.getProperty("pass"))).sendKeys(prop.getProperty("Password"),Keys.ENTER);
    }
}
