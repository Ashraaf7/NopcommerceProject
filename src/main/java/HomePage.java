import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver ;
    private By registerButton = By.className("ico-register");
    private By loginButton = By.className("ico-login");
    private By continueButton = By.className("register-continue-button");
    private By registedMessage = By.xpath("//div /div[@class='result']");

    public HomePage(WebDriver driver)
    {
        this.driver = driver ;
    }
    public Register ClickOnRegisterButton ()
    {
        driver.findElement(registerButton).click();
        return new Register(driver);
    }
    public Login ClickOnLoginButton ()
    {
        driver.findElement(loginButton).click();
        return new Login(driver);
    }
    public void ClickOnContinueButton ()
    {
        driver.findElement(continueButton).click();
    }
    public String ShowRegisterMessage ()
    {
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(registedMessage)));*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       return driver.findElement(registedMessage).getText();
    }


}
