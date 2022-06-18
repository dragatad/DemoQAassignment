package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsTests extends BaseTest {

    @Test
    public void verifyTextBoxSubmission() {
        getHomePage().navigateToElements();
        getElementsPage().navigateToTextBox();
        getTextBoxPage().completeForm("John", "john12@gmail.com","New Road","Old Road");
        Assert.assertEquals(getTextBoxPage().getResultsName().getText(),"Name:John");
        Assert.assertEquals(getTextBoxPage().getResultsEmail().getText(),"Email:john12@gmail.com");
        Assert.assertEquals(getTextBoxPage().getResultsCAddress().getText(),"Current Address :New Road");
        Assert.assertEquals(getTextBoxPage().getResultsPAddress().getText(),"Permananet Address :Old Road");
    }

    @Test
    public void verifyDoubleClick(){
        //getHomePage().navigateToElements();
        //getElementsPage().navigateToButtons();
        getButtonsPage().doubleClick();
        Assert.assertEquals(getButtonsPage().getConfirmationMessageDoubleClick(),"You have done a double click");
    }

    @Test
    public void verifyRightClick(){
        //getHomePage().navigateToElements();
        //getElementsPage().navigateToButtons();
        getButtonsPage().rightClick();
        Assert.assertEquals(getButtonsPage().getConfirmationMessageRightClick(),"You have done a right click");
    }

    @Test
    public void verifyDynamicClick(){
        //getHomePage().navigateToElements();
        //getElementsPage().navigateToButtons();
        getButtonsPage().dynamicClick();
        Assert.assertEquals(getButtonsPage().getConfirmationMessageDynamicClick(),"You have done a dynamic click");

    }

    @Test
    public void verifyYesRadioButtonSelection(){
        //getHomePage().navigateToElements();
        //getElementsPage().navigateToRadioButton();
        getRadioButtonPage().yesButtonClick();
        Assert.assertEquals(getRadioButtonPage().getConfirmationMessageText(),"You have selected Yes");
        Assert.assertFalse(getRadioButtonPage().isImpressiveButtonSelected());
    }

    @Test
    public void verifyImpressiveRadioButtonSelection(){
        //getHomePage().navigateToElements();
        //getElementsPage().navigateToRadioButton();
        getRadioButtonPage().impressiveButtonClick();
        Assert.assertEquals(getRadioButtonPage().getConfirmationMessageText(),"You have selected Impressive");
        Assert.assertFalse(getRadioButtonPage().isYesButtonSelected());

    }




}
