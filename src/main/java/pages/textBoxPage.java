package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class textBoxPage extends basePage{

    private By fullNameField = By.xpath("//*[@id=\"userName\"]");
    private By emailField = By.xpath("//*[@id=\"userEmail\"]");
    private By currentAddress = By.xpath("//*[@id=\"currentAddress\"]");
    private By permanentAddress = By.xpath("//*[@id=\"permanentAddress\"]");
    private By submitButton = By.xpath("//*[@id=\"submit\"]");

    private By resultsName = By.id("name");
    private By resultsEmail = By.id("email");
    private By resultsCAddress = By.id("currentAddress");
    private By resultsPAddress = By.id("permanentAddress");


    public textBoxPage(WebDriver driver, WebDriverWait driverWait) {
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

    public void enterFullName(String name){
        clearField(this.fullNameField);
        getFullNameField().sendKeys(name);
    }

    public void enterEmail(String email){
        clearField(this.emailField);
        getEmailField().sendKeys(email);
    }

    public void enterCurrentAddress(String currentAddress){
        clearField(this.currentAddress);
        getCurrentAddress().sendKeys(currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress){
        clearField(this.permanentAddress);
        getPermanentAddress().sendKeys(permanentAddress);
    }


    public void clickSubmit(){
        Actions actions = new Actions(getDriver());
        actions.scrollToElement(getSubmitButton()).click();
    }

    public void completeForm(String name, String email, String currentAddress, String permanentAddress){
        enterFullName(name);
        enterEmail(email);
        enterCurrentAddress(currentAddress);
        enterPermanentAddress(permanentAddress);
        clickSubmit();
    }

    public WebElement getResultsName() throws InterruptedException {
        Thread.sleep(5000);
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
