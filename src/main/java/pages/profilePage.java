package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class profilePage extends basePage{

    private By logoutButton = By.className("btn-primary");
    private By searchBox = By.id("searchBox");
    private By goToStoreButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/button");
    private By deleteAccountButton = By.id("submit");
    private By deleteBookIcon = By.id("delete-record-undefined");

    public profilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLogoutButton() {
        return getDriver().findElement(logoutButton);
    }

    public WebElement getSearchBox() {
        return getDriver().findElement(searchBox);
    }

    public void searchBook(String bookName){
        getSearchBox().sendKeys(bookName);
        getSearchBox().sendKeys(Keys.ENTER);
    }


    public WebElement getGoToStoreButton() {
        return getDriver().findElement(goToStoreButton);
    }

    public WebElement getDeleteAccountButton() {
        return getDriver().findElement(deleteAccountButton);
    }

    public WebElement getDeleteBookIcon(){
        return getDriver().findElement(deleteBookIcon);
    }

    public boolean isLogoutButtonPresent(){
        return getLogoutButton().isDisplayed();
    }

    public void clickLogoutButton(){
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(logoutButton));
        getLogoutButton().click();
    }

    public void clickGoToStoreButton(){
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", getGoToStoreButton());


        //Actions actions = new Actions(getDriver());
        //actions.moveToElement(getGoToStoreButton()).click().perform();
    }

    public boolean isBookAdded(String bookName){
        List<WebElement> list = getDriver().findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]"));
        for(WebElement element : list){
            if(element.getText().contains(bookName)){
                return true;
            }
        }
        return false;
    }

    public void deleteBookFromTable(String bookName){
        List<WebElement> list = getDriver().findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]"));
        for(WebElement element : list){
            if(element.getText().contains("Speaking JavaScript")){
                element.findElement(By.id("delete-record-undefined"));
            }
        }
    }

    public void closeAlert(){
        getDriverWait().until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
    }

    public String getAlertText(){
        getDriverWait().until(ExpectedConditions.alertIsPresent());
        return getDriver().switchTo().alert().getText();
    }


}
