package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterPage extends BasePage {
    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By userName = By.id("userName");
    private By password = By.id("password");
    private By registerButton = By.id("register");
    private By goToLoginButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[4]/div[1]/button");


    public RegisterPage(WebDriver driver, WebDriverWait driverWait) {
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

    /**
     * Metoda za unosenje imena na osnovu prosledjenog parametra
     */
    public void enterFirstName(String firstName) {
        clearField(this.firstName);
        getFirstName().sendKeys(firstName);
    }

    /**
     * Metoda za unosenje prezimena na osnovu prosledjenog parametra
     */
    public void enterLastName(String lastName) {
        clearField(this.lastName);
        getLastName().sendKeys(lastName);
    }

    /**
     * Metoda za unosenje korisnickog imena na osnovu prosledjenog parametra
     */
    public void enterUsername(String username) {
        clearField(this.userName);
        getUserName().sendKeys(username);
    }

    /**
     * Metoda za unosenje sifre na osnovu prosledjenog parametra
     */
    public void enterPassword(String password) {
        clearField(this.password);
        getPassword().sendKeys(password);
    }

    /**
     * Klik na register button
     */
    public void registerButtonClick(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(registerButton));
        getRegisterButton().click();
    }

    /**
     * Metoda koja obuhvata sve korake neophodne za registraciju na osnovu prosledjenih parametara
     */
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

    /**
     * Metoda za preuzimanje poruke koja je ispisnaa u alert-u
     */
    public String getAlertText() {
        getDriverWait().until(ExpectedConditions.alertIsPresent());
        return getDriver().switchTo().alert().getText();
    }



}
