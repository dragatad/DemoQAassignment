package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class profilePage extends basePage{

    private By logoutButton = By.className("btn-primary");
    private By searchBox = By.id("searchBox");
    private By goToStoreButton = By.id("gotoStore");
    private By deleteButton = By.id("submit");
    private By deleteAllButton = By.id("gotoStore");


    public profilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLogoutButton() {
        return getDriver().findElement(logoutButton);
    }

    public WebElement getSearchBox() {
        return getDriver().findElement(searchBox);
    }

    public WebElement getGoToStoreButton() {
        return getDriver().findElement(goToStoreButton);
    }

    public WebElement getDeleteButton() {
        return getDriver().findElement(deleteButton);
    }

    public WebElement getDeleteAllButton() {
        return getDriver().findElement(deleteAllButton);
    }


    public boolean isLogoutButtonPresent(){
        return getLogoutButton().isDisplayed();
    }

    public void clickLogoutButton(){
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(logoutButton));
        getLogoutButton().click();
    }

    public void clickGoToStoreButton(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getGoToStoreButton()).click().perform();
    }

    public boolean isBookAdded(){
        List<WebElement> list = getDriver().findElements(By.className("action-buttons"));
        for(WebElement element : list){
            if(list.contains("Speaking JavaScript")){
                return true;
            }
        }
        return false;
    }


}
