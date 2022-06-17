package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage extends BasePage {

    private By fullNameField = By.xpath("//*[@id=\"userName\"]");
    private By emailField = By.xpath("//*[@id=\"userEmail\"]");
    private By currentAddress = By.xpath("//*[@id=\"currentAddress\"]");
    private By permanentAddress = By.xpath("//*[@id=\"permanentAddress\"]");
    private By submitButton = By.xpath("//*[@id=\"submit\"]");

    private By resultsName = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[1]");
    private By resultsEmail = By.id("email");
    private By resultsCAddress = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]");
    private By resultsPAddress = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]");

    public TextBoxPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getFullNameField() {
        return getDriver().findElement(fullNameField);
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getCurrentAddress() {
        return getDriver().findElement(currentAddress);
    }

    public WebElement getPermanentAddress() {
        return getDriver().findElement(permanentAddress);
    }

    public WebElement getSubmitButton() {
        return getDriver().findElement(submitButton);
    }

    /**
     *Metoda za unosenje imena na osnovu prosledjenog parametra
     * @param name
     */
    public void enterFullName(String name){
        clearField(this.fullNameField);
        getFullNameField().sendKeys(name);
    }

    /**
     * Metoda za unosenje imejl adrese na osnovu prosledjenog parametra
     */
    public void enterEmail(String email){
        clearField(this.emailField);
        getEmailField().sendKeys(email);
    }

    /**
     * Metoda za unosenje sadasnje adrese na osnovu prosledjenog parametra
     */
    public void enterCurrentAddress(String currentAddress){
        clearField(this.currentAddress);
        getCurrentAddress().sendKeys(currentAddress);
    }

    /**
     * Metoda za unosenje trajne adrese na osnovu prosledjenog parametra
     */
    public void enterPermanentAddress(String permanentAddress){
        clearField(this.permanentAddress);
        getPermanentAddress().sendKeys(permanentAddress);
    }

    /**
     * Klik na submit button
     */
    public void clickSubmit(){
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", getSubmitButton());
        getDriverWait().until(ExpectedConditions.elementToBeClickable(getSubmitButton())).click();
    }

    /**
     * Metoda koja obuhvata sve korake neophodne za opounjavanje formulara na osnovu prosledjenih parametara
     */
    public void completeForm(String name, String email, String currentAddress, String permanentAddress){
        enterFullName(name);
        enterEmail(email);
        enterCurrentAddress(currentAddress);
        enterPermanentAddress(permanentAddress);
        clickSubmit();
    }

    public WebElement getResultsName() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(resultsName));
        return getDriver().findElement(resultsName);
    }

    public WebElement getResultsEmail() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(resultsEmail));
        return getDriver().findElement(resultsEmail);
    }

    public WebElement getResultsCAddress() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(resultsCAddress));
        return getDriver().findElement(resultsCAddress);
    }

    public WebElement getResultsPAddress() {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(resultsPAddress));
        return getDriver().findElement(resultsPAddress);
    }
}
