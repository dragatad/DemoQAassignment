package pages.bookstoreApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.commonPages.BasePage;

public class LoginPage extends BasePage {

    private By username = By.id("userName");
    private By password = By.id("password");
    private By loginButton = By.id("login");
    private By newUserButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[4]/div[2]/button");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
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


    /**
     *Metoda za klik za kreiranje novog korisnika
     */
    public void createNewUserClick() throws InterruptedException {
        Thread.sleep(5000);
        getNewUserButton().click();
    }

    /**
     *Metoda za unosenje korisnickog imena
     */
    public void enterUsername(String username) {
        clearField(this.username);
        getUsername().sendKeys(username);
    }

    /**
     * Metoda za unosenje sifre
     */
    public void enterPassword(String password) {
        clearField(this.password);
        getPassword().sendKeys(password);
    }

    /**
     * Klikn na login button
     */
    public void clickLoginButton(){
        getLoginButton().click();
    }

    /**
     * Metoda za login koja obuhvata sve korake neophodne za izvrsenje ove radnje na osnovu prosledjenih parametara
     */
    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
