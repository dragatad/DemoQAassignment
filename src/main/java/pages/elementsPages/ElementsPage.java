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
    private By radioButton = By.xpath("//*[@id=\"item-2\"]");

    public ElementsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getTextBox() {
        return getDriver().findElement(textBox);
    }

    public WebElement getButtons(){
        return getDriver().findElement(buttons);
    }

    public WebElement getRadioButton(){
        return getDriver().findElement(radioButton);
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

    /**
     * Metoda za navigaciju ka Radio Button opciji u Elements meniju
     */

    public void navigateToRadioButton(){
        getRadioButton().click();
    }



}
