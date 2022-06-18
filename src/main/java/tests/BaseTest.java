package tests;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.alertsPages.AlertsPage;
import pages.bookstoreApplicationPages.BookstorePage;
import pages.bookstoreApplicationPages.LoginPage;
import pages.bookstoreApplicationPages.ProfilePage;
import pages.bookstoreApplicationPages.RegisterPage;
import pages.commonPages.HomePage;
import pages.elementsPages.ButtonsPage;
import pages.elementsPages.ElementsPage;
import pages.elementsPages.RadioButtonPage;
import pages.elementsPages.TextBoxPage;

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
    private ButtonsPage buttonsPage;
    private RadioButtonPage radioButtonPage;



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
        buttonsPage = new ButtonsPage(driver, driverWait);
        radioButtonPage = new RadioButtonPage(driver, driverWait);

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }







}
