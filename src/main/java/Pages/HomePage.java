package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By logo = By.xpath("//img[@src='assets/images/php/logo-red.svg']");
    By Header = By.xpath("//div[contains(text(),'Welcome Back')]");
    By SubHeader = By.xpath("//p[contains(text(),'Use your assigned PHP Code to sign into your account')]");
    By PHPCodeLabel = By.xpath("//span[text()='PHP Code']");
    By PHPCodeInput = By.xpath("//input[@placeholder='11111']");
    By PasswordLabel = By.xpath("//span[text()='Password']");
    By PasswordInput = By.xpath("//input[@type='password']");
    By ForgotPassword = By.xpath("//div[text()=' Forgot Password? ']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void logocheck(){
        System.out.println(driver.findElement(logo).isDisplayed());
    }

    public void setPHPCode(String phpCode){
        driver.findElement(PHPCodeInput).sendKeys(phpCode);
    }

    public void setPassword(String password){
        driver.findElement(PasswordInput).sendKeys(password);
    }
    public void loginPHPAgency(String phpCode,String password){
        this.setPHPCode(phpCode);
        this.setPassword(password);
    }
}