package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementsPage extends basePage {

    private By textBox = By.xpath("//*[@id=\"item-0\"]");

    public elementsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getTextBox() {
        return getDriver().findElement(textBox);
    }

    public void navigateToTextBox(){
        getTextBox().click();
    }



}
