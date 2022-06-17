package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookstorePage extends BasePage {

    private By loginSubMenu = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]");
    private By bookstoreSubMenu = By.xpath("//*[@id=\"item-2\"]");
    private By profileSubMenu = By.xpath("//*[@id=\"item-3\"]");
    private By searchBoxBookStore = By.id("searchBox");
    private By addToCollectionButton = By.className("btn-primary");

    public BookstorePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getSearchBoxBookStore(){
        return getDriver().findElement(searchBoxBookStore);
    }

    public WebElement getAddToCollectionButton() {
        return getDriver().findElement(addToCollectionButton);
    }

    public WebElement getLoginSubMenu() {
        return getDriver().findElement(loginSubMenu);
    }

    public WebElement getBookstoreSubMenu() {
        return getDriver().findElement(bookstoreSubMenu);
    }


    public WebElement getProfileSubMenu() {
        return getDriver().findElement(profileSubMenu);
    }

    /**
     * Metoda za navigaciju ka login meniju
     */
    public void moveToLoginSubMenu(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        getLoginSubMenu().click();
    }

    public void moveToProfileSubMenu(){
        Actions actions = new Actions(getDriver());
        getDriverWait().until(ExpectedConditions.elementToBeClickable(profileSubMenu));
        actions.moveToElement(getProfileSubMenu()).click().perform();
    }

    /**
     * Metoda za unosenje imena knjige za pretragu
     */
    public void enterBookName(String bookName){
        getSearchBoxBookStore().sendKeys(bookName);
    }

    /**
     * Metoda za klik na knjigu i otvaranje stranice te knjige
     */
    public void clickBook(){
        List<WebElement> list = getDriver().findElements(By.className("action-buttons"));
        for(WebElement element : list){
            if(list.contains("Speaking JavaScript")){
                element.click();
            }
        }
    }

    /**
     * Metoda za dodavanje knjige u kolekciju korisnika
     */
    public void clickAddToCollection(){
        Actions actions = new Actions(getDriver());
        actions.scrollToElement(getAddToCollectionButton()).click().perform();
    }

    public void closeAlert(){
        getDriver().switchTo().alert().accept();
    }

    /**
     * Metoda koja obuhvata sve korake neophodne za izvrsenje radnje dodvanja knjige u kolekciju
     */
    public void addBook(String bookName){
        enterBookName(bookName);
        clickBook();
        clickAddToCollection();
        //closeAlert();
    }












}
