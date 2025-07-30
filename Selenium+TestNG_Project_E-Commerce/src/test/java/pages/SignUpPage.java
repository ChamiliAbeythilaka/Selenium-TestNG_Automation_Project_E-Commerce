package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PageUrl;


public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get(PageUrl.BASE_URL);
    }

    public void clickSignUp() {
        WebElement accountMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Account & orders')]")));
        accountMenu.click();

        WebElement signUpBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Sign up')]")));
        signUpBtn.click();
    }

    public void clickSignUpWithEmail() {
        WebElement signUpWithEmail = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("continue_with_email_signup"))
        );
        signUpWithEmail.click();
    }
    public void selectCountryCode(String dialCode) {
        try {
            // Wait until the country code container is clickable
            WebElement flagDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".iti__flag-container")));
            flagDropdown.click();

            // Wait until the dropdown is fully loaded and then select the country
            WebElement countryOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//li[@data-dial-code='" + dialCode + "']")));
            countryOption.click();

            System.out.println("Country code selected: +" + dialCode);
        } catch (TimeoutException e) {
            System.out.println("Country code dropdown did not appear in time  skipping selection.");
        }
    }

    public void fillSignUpForm(String firstName, String lastName, String email, String phone, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("first_name"))).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("last_name"))).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobileNum"))).sendKeys(phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(password);
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
    }

    public boolean isSignUpSuccessful() {
        try {
            WebElement greeting = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[contains(text(),'Hi,')]")));
            return greeting.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getEmailErrorMessage() {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[contains(text(),'must be a valid email address')]")
            ));
            return error.getText(); // Returns: "The email must be a valid email address."
        } catch (TimeoutException e) {
            return "";
        }
    }

    public String getPhoneErrorMessage() {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[contains(text(),'Invalid mobile number')]")
            ));
            return error.getText(); // Returns: "Invalid mobile number."
        } catch (TimeoutException e) {
            return "";
        }
    }

    public String getPasswordErrorMessage() {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[contains(text(),'at least 12 characters')]")
            ));
            return error.getText(); // Should return: "The password must be at least 12 characters."
        } catch (TimeoutException e) {
            return "";
        }
    }


}
