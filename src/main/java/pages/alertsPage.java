package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class alertsPage extends basePage {

    private By alertsSubMenu = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]");

    private By clickMeAlertButton = By.id("alertButton");
    private By clickMeConfirmButton = By.id("confirmButton");
    private By clickMePromptButton = By.id("promtButton");

    public alertsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getClickMeAlertButton() {
        return getDriver().findElement(clickMeAlertButton);
    }

    public WebElement getClickMeConfirmButton() {
        return getDriver().findElement(clickMeConfirmButton);
    }

    public WebElement getClickMePromptButton() {
        return getDriver().findElement(clickMePromptButton);
    }

    public void clickAlertButton(){
        getClickMeAlertButton().click();
    }

    public void clickConfirmButton(){
        getClickMeConfirmButton().click();
    }

    public void clickPromptButton(){
        getClickMePromptButton().click();
    }

    public String getAlertText(){
        return getDriver().switchTo().alert().getText();
    }

    public void closeAlert(){
        getDriver().switchTo().alert().accept();
    }

    public WebElement getAlertsSubMenu() {
        return getDriver().findElement(alertsSubMenu);
    }

    public void navigateToAlerts(){
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", getAlertsSubMenu());
        getDriverWait().until(ExpectedConditions.elementToBeClickable(getAlertsSubMenu())).click();
    }
}
