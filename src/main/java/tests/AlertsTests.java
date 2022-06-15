package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTests extends baseTest{


    @Test
    public void verifyAlert(){
        getHomePage().navigateToAlertsMenu();
        getAlertsPage().navigateToAlerts();
        getAlertsPage().clickAlertButton();
        Assert.assertEquals(getAlertsPage().getAlertText(),"You clicked a button");
        getAlertsPage().closeAlert();
    }











}
