package pages.alertsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.commonPages.BasePage;

public class AlertsPage extends BasePage {

    private By alertsSubMenu = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]");

    private By clickMeAlertButton = By.id("alertButton");
    private By clickMeTimerButton = By.id("timerAlertButton");
    private By clickMeConfirmButton = By.id("confirmButton");
    private By clickMePromptButton = By.id("promtButton");

    public AlertsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getClickMeAlertButton() {
        return getDriver().findElement(clickMeAlertButton);
    }

    public WebElement getClickMeTimerButton() { return getDriver().findElement(clickMeTimerButton);}

    public WebElement getClickMeConfirmButton() {
        return getDriver().findElement(clickMeConfirmButton);
    }

    public WebElement getClickMePromptButton() {
        return getDriver().findElement(clickMePromptButton);
    }

    public void clickAlertButton() {
        getClickMeAlertButton().click();
    }

    public void clickTimerButton() {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated((clickMeTimerButton)));
        getClickMeTimerButton().click();
    }

    public void clickConfirmButton() {
        getClickMeConfirmButton().click();
    }

    public void clickPromptButton() {
        getClickMePromptButton().click();
    }

    /**
     * Preuzimanje poruke ispisane u alert-u
     */
    public String getAlertText() {
        getDriverWait().until(ExpectedConditions.alertIsPresent());
        return getDriver().switchTo().alert().getText();
    }

    /**
     * Ukucavanje imena u prompt box
     */
    public void enterNamePromptBox() {
        getDriver().switchTo().alert().sendKeys("John");
    }

    /**
     * Zatvaranje alert-a
     */
    public void closeAlert() {
        getDriver().switchTo().alert().accept();
    }

    public WebElement getAlertsSubMenu() {
        return getDriver().findElement(alertsSubMenu);
    }

    public void navigateToAlerts() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getAlertsSubMenu());
        getDriverWait().until(ExpectedConditions.elementToBeClickable(getAlertsSubMenu())).click();
    }

    /**
     * Provjera da li se alert prikazao za dozvoljeno vrijeme wait-era
     */
    public boolean alertIsPresent() {
        if (getDriverWait().until(ExpectedConditions.alertIsPresent()) == null)
            return false;
        return true;
    }
}
