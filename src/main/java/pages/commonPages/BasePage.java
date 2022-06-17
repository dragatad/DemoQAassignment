package pages.commonPages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public @Getter
class BasePage {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private static final String PROFILE_URL = "https://demoqa.com/profile";


    public BasePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public BasePage() {
    }

    /**
     * Metoda za brisanje polja za unos
     */
    public void clearField(By locator) {
        getDriver().findElement(locator).clear();
    }

    /**
     * Metoda za navigaciju na profilnu stranicu
     */

    public void openProfilePage(){
        driver.navigate().to(PROFILE_URL);
    }

}
