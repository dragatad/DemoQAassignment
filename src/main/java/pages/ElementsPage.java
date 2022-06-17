package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsPage extends BasePage {

    private By textBox = By.xpath("//*[@id=\"item-0\"]");

    public ElementsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getTextBox() {
        return getDriver().findElement(textBox);
    }

    /**
     * Metoda za navigaciju ka textBox opciju u Elements meniju
     */
    public void navigateToTextBox(){
        getTextBox().click();
    }



}
