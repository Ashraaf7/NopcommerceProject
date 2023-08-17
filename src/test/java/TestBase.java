import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase {
    private WebDriver driver ;
    private HomePage homePage ;
    private Register register;
    private Login login ;
    @BeforeTest
    public  void setup()
    {
        driver = new EdgeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }
    @Test(priority = 0)
    public void RegisterWithValidData()
    {
        register = homePage.ClickOnRegisterButton();
        register.ChooseGender();
        register.EnterFirstName("Ahmed");
        register.EnterLastName("Ashraf");
        register.ChooseDate("12","May","1990");
        register.EnterEmail("testtest8800089@gmail.com");
        register.EnterPassword("1234567");
        register.EnterRePassword("1234567");
        homePage =register.ClickOnRegisterButton();
        //homePage.ClickOnContinueButton();
        Assert.assertEquals(homePage.ShowRegisterMessage(),"Your registration completed");
    }

    @Test (priority = 1)
    public void LoginWithValidData()
    {
        login = homePage.ClickOnLoginButton();
        login.EnterEmail();
    }



    @AfterTest
    public  void close()
    {
        driver.quit();
    }
}
