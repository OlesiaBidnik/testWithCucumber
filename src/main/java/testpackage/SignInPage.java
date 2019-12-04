package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.tools.tree.NewArrayExpression;

import java.util.concurrent.TimeUnit;

public class SignInPage {
    private WebDriver driver;
    public SignInPage (WebDriver driver){
        this.driver = driver;
    }
    private By emailField = By.xpath("//input[@aria-label = 'Phone number, username, or email']");  //("//input[@name = 'username']");
    private By passField = By.xpath("//input[@name = 'password']");
    private By showPasswordButton = By.xpath("//div[@class = 'i24fI']/div/button"); //("//button[text() = 'Show']");
    private By logInButton = By.xpath("//button/div[text() = 'Log In']");
    private By loginWithFacebookButton = By.xpath("//span[text() = 'Log in with Facebook']");
    private By forgotPasswordLink = By.xpath("//a[text() = 'Forgot password?']");
    private By alert = By.xpath("//p[@id = 'slfErrorAlert']");
    private By signUpLink = By.xpath("//span[text() = 'Sign up']");

    public SignInPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignInPage waitpage(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'rgFsT']")));
        return this;
    }

    public SignInPage typePass(String password){
        driver.findElement(passField).sendKeys(password);
        return this;
    }

    public SignInPage clickShowPasswordButton(){
        driver.findElement(showPasswordButton).click();
        return this;
    }

    public SignInPage clickLoginButton(){
        driver.findElement(logInButton).submit();
        return this;
    }

    public SignInPage clickLoginWithFacebookButton(){
        driver.findElement(loginWithFacebookButton).click();
        return this;
    }

    public SignInPage clickForgotPasswordLink(){
        driver.findElement(forgotPasswordLink).click();
        return this;
    }

    public SignInPage clickSignUpLink(){
        driver.findElement(signUpLink).click();
        return this;
    }

    public boolean isAlertVisible(){
        return driver.findElement(alert).isDisplayed();
    }

    public boolean isLoginButtonDisabled(){
        return driver.findElement(logInButton).isEnabled();
    }



}
