package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsTests extends baseTest{

    @Test
    public void verifyTextBoxSubmission() throws InterruptedException {
        getHomePage().navigateToElements();
        getElementsPage().navigateToTextBox();
        getTextBoxPage().completeForm("John", "john12@gmail.com","New Road","Old Road");
        Thread.sleep(5000);
        Assert.assertEquals(getTextBoxPage().getResultsName().getText(),"John");
        Assert.assertEquals(getTextBoxPage().getResultsEmail().getText(),"john12@gmail.com");
        Assert.assertEquals(getTextBoxPage().getResultsCAddress(),"New Road");
        Assert.assertEquals(getTextBoxPage().getResultsPAddress(),"Old Road");
    }
}
