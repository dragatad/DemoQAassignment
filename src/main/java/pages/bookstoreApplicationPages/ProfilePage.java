package pages.bookstoreApplicationPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.commonPages.BasePage;

import java.util.List;

public class ProfilePage extends BasePage {

    private By logoutButton = By.className("btn-primary");
    private By searchBox = By.id("searchBox");
    private By goToStoreButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/button");
    private By deleteAccountButton = By.id("submit");

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLogoutButton() {
        return getDriver().findElement(logoutButton);
    }

    public WebElement getSearchBox() {
        return getDriver().findElement(searchBox);
    }


    /**
     * Metoda za pretrazivanje biblioteke na osnovu prosledjenog imena knjige
     */
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

    /**
     *Provjera da li je logout button prikazan
     */
    public boolean isLogoutButtonPresent(){ return getLogoutButton().isDisplayed();}

    /**
     * Klik na logout button
     */
    public void clickLogoutButton(){
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(logoutButton));
        getLogoutButton().click();
    }

    public void clickGoToStoreButton(){
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", getGoToStoreButton());
    }

    /**
     * Provjera da li se knjiga pod prosledjenim imenom nalazi u kolekciji
     */
    public boolean isBookAdded(String bookName){
        List<WebElement> list = getDriver().findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]"));
        for(WebElement element : list){
            if(element.getText().contains(bookName)){
                return true;
            }
        }
        return false;
    }

    /**
     *Metoda za brisanje knjige iz kolekcije
     */
    public void deleteBookFromTable(String bookName){
        List<WebElement> list = getDriver().findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]"));
        for(WebElement element : list){
            if(element.getText().contains(bookName)){
                element.findElement(By.id("delete-record-undefined"));
            }
        }
    }

    public void closeAlert(){
        getDriverWait().until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
    }



}
