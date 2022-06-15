package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTests extends baseTest{


    @Test (priority = 1)
    public void verifyAlert(){
        getHomePage().navigateToAlertsMenu();
        getAlertsPage().navigateToAlerts();
        getAlertsPage().clickAlertButton();
        Assert.assertEquals(getAlertsPage().getAlertText(),"You clicked a button");
        getAlertsPage().closeAlert();
    }

    @Test (priority = 2)
    public void verifyConfirmBox(){
        getAlertsPage().clickConfirmButton();
        Assert.assertEquals(getAlertsPage().getAlertText(), "Do you confirm action?");
        getAlertsPage().closeAlert();
    }

    @Test (priority = 3)
    public void verifyPromptBox(){
        getAlertsPage().clickPromptButton();
        Assert.assertEquals(getAlertsPage().getAlertText(),"Please enter your name");
        getAlertsPage().enterNamePromptBox();
        getAlertsPage().closeAlert();
    }













}
