package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTests extends BaseTest {


    @Test (priority = 1)
    public void verifyAlert(){
        getHomePage().navigateToAlertsMenu();
        getAlertsPage().navigateToAlerts();
        getAlertsPage().clickAlertButton();
        Assert.assertEquals(getAlertsPage().getAlertText(),"You clicked a button");
        getAlertsPage().closeAlert();
    }

    @Test (priority = 2)
    public void verifyTimerAlert() throws InterruptedException {
        getHomePage().navigateToAlertsMenu();
        getAlertsPage().navigateToAlerts();
        getAlertsPage().clickTimerButton();
        Thread.sleep(5000);
        Assert.assertTrue(getAlertsPage().alertIsPresent());
        getAlertsPage().closeAlert();
    }

    @Test (priority = 3)
    public void verifyConfirmBox(){
        getHomePage().navigateToAlertsMenu();
        getAlertsPage().navigateToAlerts();
        getAlertsPage().clickConfirmButton();
        Assert.assertEquals(getAlertsPage().getAlertText(), "Do you confirm action?");
        getAlertsPage().closeAlert();
    }

    @Test (priority = 4)
    public void verifyPromptBox(){
        getHomePage().navigateToAlertsMenu();
        getAlertsPage().navigateToAlerts();
        getAlertsPage().clickPromptButton();
        Assert.assertEquals(getAlertsPage().getAlertText(),"Please enter your name");
        getAlertsPage().enterNamePromptBox();
        getAlertsPage().closeAlert();
    }













}
