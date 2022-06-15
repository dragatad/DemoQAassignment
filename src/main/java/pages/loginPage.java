package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends basePage{

    private By username = By.id("userName");
    private By password = By.id("password");
    private By loginButton = By.id("login");
    private By newUserButton = By.id("newUser");

    public loginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getUsername() {
        return getDriver().findElement(username);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public WebElement getNewUserButton() {
        return getDriver().findElement(newUserButton);
    }

    public void createNewUserClick() throws InterruptedException {
        //getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(newUserButton));
        Thread.sleep(5000);
        getNewUserButton().click();
    }

    public void enterUsername(String username) {
        clearField(this.username);
        getUsername().sendKeys(username);
    }

    public void enterPassword(String password) {
        clearField(this.password);
        getPassword().sendKeys(password);
    }

    public void clickLoginButton(){
        getLoginButton().click();
    }

    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
