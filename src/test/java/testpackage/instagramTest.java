package testpackage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class instagramTest {
    WebDriver driver;
    SignUpPage signUpP;
    SignInPage signInP;


    @cucumber.api.java.Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/users/OlesiaBidnik/downloads/chromedriver");
        driver = new ChromeDriver();
        signUpP = new SignUpPage(driver);
        signInP = new SignInPage(driver);
        driver.get("https://www.instagram.com/?hl=en");
    }

    @After
    public void tearDown(){
        driver.quit();
    }



    @Given("^I am on sign up page$")
    public void iamOnSignUpPage(){
        String urlSignUp = driver.getCurrentUrl();
        Assert.assertEquals("https://www.instagram.com/?hl=en", urlSignUp);
    }

    @When("^I click signup$")
    public void click(){signUpP.clickSignUpButton();}

    @When("^I type username \"([^\"]*)\"$")
    public void typeUserName(String value){
        signUpP.typeUsername(value);
    }

    @When("^I type password \"([^\"]*)\"$")
    public void typePassword(String value){
        signUpP.typePassword(value);
    }

    @When("^I type phone \"([^\"]*)\"$")
    public void typePhone(String number){
        signUpP.typeNumber(number);
    }

    @When("^I type name \"([^\"]*)\"$")
    public void typeName(String value){
        signUpP.typeName(value);
    }

    @When("^I click sign up with facebook$")
    public void ckickFacebook(){
        signUpP.clickLoginWithFacebookButton();
    }

    @When("^I click log in link$")
    public void clickLogin(){
        signUpP.clickLogIn();
    }

    @When("^I wait until page load$")
    public void waitPage(){
        signInP.waitpage();
    }

    @When("^I click log in button$")
    public void clicklogin(){
        signInP.clickLoginButton();
    }

    @When("^I type email \"([^\"]*)\"$")
    public void typeEmail(String email){
        signInP.typeEmail(email);
    }

    @When("^I type pass \"([^\"]*)\"$")
    public void typePass(String password){
        signInP.typePass(password);
    }

    @When ("^I click Show button$")
    public void clickShowButton(){
        signInP.clickShowPasswordButton();
    }

    @When("^I click log in with Facebook button$")
    public void clickLoginwithFb(){
        signInP.clickLoginWithFacebookButton();
    }

    @When("^I click Forgot Password link$")
    public void clickForgotPassword(){
        signInP.clickForgotPasswordLink();
    }

    @When("^I click sign up link$")
    public void clickSigUp(){
        signInP.clickSignUpLink();
    }



    @Then("^I see error$")
    public void isErrorVisible(){signUpP.isErrorVisible();}

    @Then("^facebook page opens$")
    public void facebookOpening(){
        String pageURL = driver.getCurrentUrl();
        Assert.assertTrue(pageURL.contains("https://www.facebook.com/login"));
    }

    @Then("^login page opens$")
    public void loginOpenning(){
        String pageURLl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.instagram.com/accounts/login/?hl=en&source=auth_switcher", pageURLl);
    }

    @Then("^sign up page opens$")
    public void signupPageOpenning(){
        String pageURL = driver.getCurrentUrl();
        Assert.assertEquals("https://www.instagram.com/accounts/emailsignup/?hl=en", pageURL);
    }

    @Then("^reset password page opens$")
    public void resetPasswordPageOpenning(){
        String pageURL = driver.getCurrentUrl();
        Assert.assertEquals("https://www.instagram.com/accounts/password/reset/?hl=en", pageURL);
    }

    @Then("^log in button is disabled$")
    public void isLoginButtonDisabled(){
        WebElement loginButton = driver.findElement(By.xpath("//button/div[text() = 'Log In']"));
        Assert.assertFalse(loginButton.isEnabled());
    }

    @Then("^I see alert$")
    public void isAlertVisible(){
        signInP.isAlertVisible();
    }

    @Then("^I see password \"([^\"]*)\"$")
    public void checkPassword(String enteredPassword){
        String displayedPassword = driver.findElement(By.xpath("//input[@name = 'password']")).getAttribute("value");
        Assert.assertEquals(enteredPassword, displayedPassword);
    }


}
