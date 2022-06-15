package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public @Getter
class basePage {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private static final String PROFILE_URL = "https://demoqa.com/profile";


    public basePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public basePage() {
    }

    /**
     * Metoda za brisanje polja za unos
     */
    public void clearField(By locator) {
        getDriver().findElement(locator).clear();
    }

    public void openProfilePage(){
        driver.navigate().to(PROFILE_URL);
    }

}
