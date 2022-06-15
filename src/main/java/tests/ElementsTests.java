package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsTests extends baseTest{

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

}
