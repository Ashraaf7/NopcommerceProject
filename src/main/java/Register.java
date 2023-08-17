import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Register {
    private WebDriver driver ;
    private By genderMale = By.id("gender-male") ;
    private By genderFemale = By.id("gender-female") ;
    private By firstName = By.id("FirstName") ;
    private By lastName = By.id("LastName") ;
    private By day = By.xpath("//select[@name='DateOfBirthDay']") ;
    private By month = By.xpath("//select[@name='DateOfBirthMonth']") ;
    private By year = By.xpath("//select[@name='DateOfBirthYear']") ;
     Select select ;
    private By email = By.id("Email") ;
    private By password = By.id("Password") ;
    private By re_password = By.id("ConfirmPassword") ;
    private By registerButton = By.id("register-button") ;
    private WebDriverWait w ;

    public Register(WebDriver driver)
    {
        this.driver = driver ;
    }


    public void ChooseGender ()
    {

        driver.findElement(genderMale).click();
    }
    public void EnterFirstName (String f)
    {
        driver.findElement(firstName).sendKeys(f);
    }
    public void EnterLastName (String l)
    {

        driver.findElement(lastName).sendKeys(l);
    }
    public void ChooseDate (String d, String m , String y)
    {
        WebElement dayElement = driver.findElement(day);
        WebElement monthElement = driver.findElement(month);
        WebElement yearElement = driver.findElement(year);
        select = new Select(dayElement);
        select.selectByVisibleText(d);
        select = new Select(monthElement);
        select.selectByVisibleText(m);
        select = new Select(yearElement);
        select.selectByVisibleText(y);
    }
    public void EnterEmail(String e)
    {
        driver.findElement(email).sendKeys(e);
    }
    public void EnterPassword (String pass)
    {
        driver.findElement(password).sendKeys(pass);
    }
    public void EnterRePassword (String repass)
    {
        driver.findElement(re_password).sendKeys(repass);
    }
    public HomePage ClickOnRegisterButton ()
    {
        driver.findElement(registerButton).click();
        return new HomePage(driver);
    }
}
