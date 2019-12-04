package testpackage;

import com.sun.deploy.util.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.ExecutionException;

public class SignUpPage {
    private WebDriver driver;
    public SignUpPage (WebDriver driver){
        this.driver = driver;
    }
    private By numberField = By.xpath("//input[@name= 'emailOrPhone']");
    private By fullNameField = By.xpath("//input[@name= 'fullName']");
    private By usernameField = By.xpath("//input[@name= 'username']");
    private By passwordField = By.xpath("//input[@name= 'password']");
    private By signUpButton = By.xpath("//button[text() = 'Sign up']");
    private By errorMessage = By.xpath("//*[@id='ssfErrorAlert']");
    private By logInLink = By.xpath("//p[@class = 'izU2O']/a");
    private By loginWithFacebookButton = By.xpath("//button[text() = 'Log in with Facebook']");



    public SignUpPage open(){
        driver.get("https://www.instagram.com/?hl=en");
        return this;
    }


    public SignUpPage typeNumber(String number){
        driver.findElement(numberField).sendKeys(number);
        return this;
    }

    public SignUpPage typeName(String name){
        driver.findElement(fullNameField).sendKeys(name);
        return this;
    }

    public SignUpPage typeUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public SignUpPage typePassword(String password){
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage clickSignUpButton(){
        driver.findElement(signUpButton).click();
        return this;
    }

    public SignUpPage clickLoginWithFacebookButton(){
        driver.findElement(loginWithFacebookButton).click();
        return this;
    }

    public SignUpPage clickLogIn(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(logInLink));
        driver.findElement(logInLink).click();
        return this;
    }


    public boolean isErrorVisible(){
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).isDisplayed();
    }

}
