package pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.commonPages.BasePage;

public class ElementsPage extends BasePage {

    private By textBox = By.xpath("//*[@id=\"item-0\"]");
    private By buttons = By.xpath("//*[@id=\"item-4\"]");

    public ElementsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getTextBox() {
        return getDriver().findElement(textBox);
    }

    public WebElement getButtons(){
        return getDriver().findElement(buttons);
    }

    /**
     * Metoda za navigaciju ka TextBox opciju u Elements meniju
     */
    public void navigateToTextBox(){
        getTextBox().click();
    }


    /**
     * Metoda za navigaciju ka Buttons opciji u Elements meniju
     */
    public void navigateToButtons(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        getButtons().click();}



}
