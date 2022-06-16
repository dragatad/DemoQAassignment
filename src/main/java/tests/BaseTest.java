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
class BaseTest {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private Actions actions;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private ProfilePage profilePage;
    private BookstorePage bookstorePage;
    private AlertsPage alertsPage;
    private ElementsPage elementsPage;
    private TextBoxPage textBoxPage;



    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\chromedriver.exe");
        driver = new ChromeDriver();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver, driverWait);
        registerPage = new RegisterPage(driver,driverWait);
        homePage = new HomePage(driver, driverWait);
        alertsPage = new AlertsPage(driver,driverWait);
        profilePage = new ProfilePage(driver, driverWait);
        bookstorePage = new BookstorePage(driver, driverWait);
        elementsPage = new ElementsPage(driver,driverWait);
        textBoxPage = new TextBoxPage(driver, driverWait);

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }







}
