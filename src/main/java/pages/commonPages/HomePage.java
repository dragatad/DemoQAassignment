package pages.commonPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By elementsMenu = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    private By bookstoreMenu = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]");
    private By alertsMenu = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]");



    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getElementsMenu() {
        return getDriver().findElement(elementsMenu);
    }

    public WebElement getBookstoreMenu() {
        return getDriver().findElement(bookstoreMenu);
    }

    public WebElement getAlertsMenu(){
        return getDriver().findElement(alertsMenu);
    }

    public void bookstoreMenuClick(){
        getBookstoreMenu().click();
    }


    /**
     * Metoda za navigaciju ka Elements meniju
     */
    public void navigateToElements(){
        getElementsMenu().click();
    }

    /**
     * Metoda za navigaciju ka Bookstore meniju
     */
    public void navigateToBookstoreMenu(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getBookstoreMenu()).click().perform();
    }

    /**
     * Metoda za navigaciju kao Alerts,Frame & Windows meniju
     */
    public void navigateToAlertsMenu(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getAlertsMenu()).click().perform();
    }


}
