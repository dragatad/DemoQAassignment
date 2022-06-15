package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class registerPage extends basePage{
    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By userName = By.id("userName");
    private By password = By.id("password");
    private By registerButton = By.id("register");
    private By goToLoginButton = By.xpath("//*[@id=\"gotologin\"]");


    public registerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getFirstName() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(firstName));
        return getDriver().findElement(firstName);
    }

    public WebElement getLastName() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(lastName));
        return getDriver().findElement(lastName);
    }

    public WebElement getUserName() {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(userName));
        return getDriver().findElement(userName);
    }

    public WebElement getPassword() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(password));
        return getDriver().findElement(password);
    }


    public WebElement getRegisterButton() {
        return getDriver().findElement(registerButton);
    }

    public WebElement getGoToLoginButton(){
        return getDriver().findElement(goToLoginButton);
    }

    public void clickGoToLoginButton(){
        getGoToLoginButton().click();
    }

    public void enterFirstName(String firstName) {
        clearField(this.firstName);
        getFirstName().sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        clearField(this.lastName);
        getLastName().sendKeys(lastName);
    }


    public void enterUsername(String username) {
        clearField(this.userName);
        getUserName().sendKeys(username);
    }

    public void enterPassword(String password) {
        clearField(this.password);
        getPassword().sendKeys(password);
    }


    public void registerButtonClick(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(registerButton));
        getRegisterButton().click();
    }

    public void register(String firstName, String lastName, String username, String password) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterUsername(username);
        enterPassword(password);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //kliknuti na captcha manuelno

        registerButtonClick();
    }

    public String getAlertText() {
        getDriverWait().until(ExpectedConditions.alertIsPresent());
        return getDriver().switchTo().alert().getText();
    }







}