package pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.commonPages.BasePage;

public class ButtonsPage extends BasePage {

    private By doubleClick = By.id("doubleClickBtn");
    private By doubleClickMessage = By.id("doubleClickMessage");
    private By rightClick = By.id("rightClickBtn");
    private By rightClickMessage = By.id("rightClickMessage");
    private By dynamicClick = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button");
    private By dynamicClickMessage = By.id("dynamicClickMessage");


    public ButtonsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getDoubleClick() {
        return getDriver().findElement(doubleClick);
    }

    public WebElement getRightClick() {
        return getDriver().findElement(rightClick);
    }

    public WebElement getDynamicClick() {
        return getDriver().findElement(dynamicClick);
    }

    /**
     * Metoda za dupli klik
     */
    public void doubleClick() {
        Actions actions = new Actions(getDriver());
        actions.doubleClick(getDoubleClick()).perform();
    }

    /**
     * Metoda za desni klik
     */

    public void rightClick() {
        Actions actions = new Actions(getDriver());
        actions.contextClick(getRightClick()).perform();
    }

    /**
     * Metoda za dinamicki klik
     */
    public void dynamicClick() {
        getDynamicClick().click();
    }

    /**
     * Metoda za preuzimanje poruke nakon duplog klika
     */
    public String getConfirmationMessageDoubleClick() {
        return getDriver().findElement(doubleClickMessage).getText();
    }

    /**
     * Metoda za preuzimanje poruke nakon desnog klika
     */

    public String getConfirmationMessageRightClick() {
        return getDriver().findElement(rightClickMessage).getText();
    }

    /**
     *Metoda za preuzimanje poruke nakon dinamickog klika
     */

    public String getConfirmationMessageDynamicClick() {
        return getDriver().findElement(dynamicClickMessage).getText();
    }


}
