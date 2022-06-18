package pages.elementsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.commonPages.BasePage;

public class RadioButtonPage extends BasePage {
    private By yesButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label");
    private By impressiveButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label");
    private By noButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[4]/label");
    private By confirmationMessage = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p");


    public RadioButtonPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getYesButton() {
        return getDriver().findElement(yesButton);
    }

    public WebElement getImpressiveButton(){
        return getDriver().findElement(impressiveButton);
    }

    public WebElement getConfirmationMessage(){
        return getDriver().findElement(confirmationMessage);
    }

    public WebElement getNoButton(){
        return getDriver().findElement(noButton);
    }

    /**
     * Metoda za odabir Yes opcije
     */
    public void yesButtonClick(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(yesButton));
        getYesButton().click();
    }

    /**
     * Metoda za odabir Impressive opcije
     */
    public void impressiveButtonClick(){
        getImpressiveButton().click();
    }

    /**
     * Metoda za provjeru selekcije Yes opcije
     */
    public boolean isYesButtonSelected(){
        return getYesButton().isSelected();
    }

    /**
     * Metoda za provjeru selekcije Impressive opcije
     */
    public boolean isImpressiveButtonSelected(){
        return getYesButton().isSelected();
    }

    /**
     * Metoda za preuzimanje poruke nakon selekcije odredjene opcije
     */
    public String getConfirmationMessageText(){
        return getConfirmationMessage().getText();
    }




}
