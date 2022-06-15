package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStoreApplicationTests extends baseTest {

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
        getRegisterPage().clickGoToLoginButton();
        getLoginPage().login("john123", "Johnson12@");
        Assert.assertTrue(getProfilePage().isLogoutButtonPresent());
    }

    @Test(priority = 3)
    public void verifyAddBookToCollection(){

        getProfilePage().clickGoToStoreButton();
        getBookstorePage().addBook("Speaking JavaScript");
        getBookstorePage().openProfilePage();
        Assert.assertTrue(getProfilePage().isBookAdded());
    }






    @Test (priority = 4)
    public void verifySuccessfulLogout() {
        getProfilePage().clickLogoutButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/login");
    }


    }
