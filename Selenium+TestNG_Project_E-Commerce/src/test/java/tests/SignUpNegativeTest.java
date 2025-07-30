package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SignUpPage;
import utils.RandomDataGenerator;


public class SignUpNegativeTest {
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

    @Test(priority = 2)
    public void testWeakPassword() {
        String firstName = RandomDataGenerator.generateFirstName();
        String lastName = RandomDataGenerator.generateLastName();
        String email = RandomDataGenerator.generateEmail();
        String phone = RandomDataGenerator.generatePhone();
        String password = RandomDataGenerator.getWeakPassword();  // weak password

        signUpPage.selectCountryCode("94");
        signUpPage.fillSignUpForm(firstName, lastName, email, phone, password);
        signUpPage.submitForm();

        Assert.assertEquals(signUpPage.getPasswordErrorMessage(), "The password must be at least 12 characters.");
    }


    @Test(priority = 3)
    public void testInvalidEmailFormat() {
        String firstName = RandomDataGenerator.generateFirstName();
        String lastName = RandomDataGenerator.generateLastName();
        String email = RandomDataGenerator.getInvalidEmail();
        String phone = RandomDataGenerator.generatePhone();
        String password = RandomDataGenerator.generateStrongPassword();

        signUpPage.selectCountryCode("94");
        signUpPage.fillSignUpForm(firstName, lastName, email, phone, password);
        signUpPage.submitForm();

        Assert.assertEquals(signUpPage.getEmailErrorMessage(), "The email must be a valid email address.");
    }


    @Test(priority = 4)
    public void testInvalidPhoneNumber() {
        String firstName = RandomDataGenerator.generateFirstName();
        String lastName = RandomDataGenerator.generateLastName();
        String email = RandomDataGenerator.generateEmail();
        String phone = RandomDataGenerator.getInvalidPhoneNumber();  // invalid phone
        String password = RandomDataGenerator.generateStrongPassword();

        signUpPage.fillSignUpForm(firstName, lastName, email, phone, password);
        signUpPage.submitForm();

        Assert.assertEquals(signUpPage.getPhoneErrorMessage(), "Invalid mobile number.");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

