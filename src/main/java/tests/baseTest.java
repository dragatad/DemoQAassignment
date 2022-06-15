package tests;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.time.Duration;

public @Getter
class baseTest {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private Actions actions;
    private homePage homePage;
    private loginPage loginPage;
    private registerPage registerPage;
    private profilePage profilePage;
    private bookstorePage bookstorePage;
    private alertsPage alertsPage;
    private elementsPage elementsPage;
    private textBoxPage textBoxPage;



    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\chromedriver.exe");
        driver = new ChromeDriver();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();

        loginPage = new loginPage(driver, driverWait);
        registerPage = new registerPage(driver,driverWait);
        homePage = new homePage(driver, driverWait);
        alertsPage = new alertsPage(driver,driverWait);
        profilePage = new profilePage(driver, driverWait);
        bookstorePage = new bookstorePage(driver, driverWait);
        elementsPage = new elementsPage(driver,driverWait);
        textBoxPage = new textBoxPage(driver, driverWait);

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }







}
