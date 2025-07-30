package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SignUpPage;
import utils.RandomDataGenerator;

public class SignUpTest {

    WebDriver driver;
    SignUpPage signUpPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        signUpPage = new SignUpPage(driver);

        signUpPage.openHomePage();
        signUpPage.clickSignUp();
        signUpPage.clickSignUpWithEmail();
    }

    @Test(priority = 1)
    public void testValidSignUp() {
        String firstName = RandomDataGenerator.generateFirstName();
        String lastName = RandomDataGenerator.generateLastName();
        String email = RandomDataGenerator.generateEmail();
        String phone = RandomDataGenerator.generatePhone();
        String password = RandomDataGenerator.generateStrongPassword();

        signUpPage.selectCountryCode("94");
        signUpPage.fillSignUpForm(firstName, lastName, email, phone, password);
        signUpPage.submitForm();

        Assert.assertTrue(signUpPage.isSignUpSuccessful(), "Sign up should be successful.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

