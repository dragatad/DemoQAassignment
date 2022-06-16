package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStoreApplicationTests extends BaseTest {

    @Test (priority = 1)
    public void verifyNewUserRegistration() throws InterruptedException {
        getHomePage().navigateToBookstoreMenu();
        getBookstorePage().moveToLoginSubMenu();
        getLoginPage().createNewUserClick();
        //captcha
        getRegisterPage().register("John", "Johnson","john123","Johnson12@");
        Assert.assertEquals(getRegisterPage().getAlertText(),"User Registered Successfully.");
    }

    @Test(priority = 2)
    public void verifySuccessfulLogin() {
        getHomePage().navigateToBookstoreMenu();
        getBookstorePage().moveToLoginSubMenu();
        getRegisterPage().clickGoToLoginButton();
        getLoginPage().login("john123", "Johnson12@");
        Assert.assertTrue(getProfilePage().isLogoutButtonPresent());
    }

    @Test(priority = 3)
    public void verifyAddBookToCollection() throws InterruptedException {
        getProfilePage().clickGoToStoreButton();
        getBookstorePage().addBook("Speaking JavaScript");
        Thread.sleep(150000);
        getBookstorePage().openProfilePage();
        Assert.assertTrue(getProfilePage().isBookAdded("Speaking JavaScript"));
    }

    @Test (priority = 4)
    public void verifyDeleteBook(){
        getProfilePage().searchBook("Speaking JavaScript");
        getProfilePage().deleteBookFromTable("Speaking JavaScript");
        //getProfilePage().alertIsPresent();
        //getProfilePage().closeAlert();
        Assert.assertTrue(getProfilePage().isBookAdded("Speaking JavaScript"));
    }

    @Test (priority = 5)
    public void verifySuccessfulLogout() {
        getProfilePage().clickLogoutButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/login");
    }

}
