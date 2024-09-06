package com.Optiomax.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.AddOrganizationPage;
import com.Optiomax.pageObjects.BasePage;

public class AddOrganizationTest extends BasePage {

    private AddOrganizationPage addOrganizationPage;

    @BeforeMethod
    public void setUpTest() throws InterruptedException {
        addOrganizationPage = new AddOrganizationPage(driver);
        addOrganizationPage = PageFactory.initElements(driver, AddOrganizationPage.class);
        addOrganizationPage.login("chamoddushyantha2017@gmail.com", "chamod1234");
        Thread.sleep(5000);
        driver.get("http://app.optiomax.com/dashboard/organization");
        Thread.sleep(5000);
    }
 
    @Test(priority = 1)
    public void testAddNewOrganization() {

        addOrganizationPage.setOrganizationName("New Organization");
        addOrganizationPage.setOrganizationDescription("New Organization Description");
        addOrganizationPage.setTelephoneNumber("0112347973");
        addOrganizationPage.setEmail("neworganization@gmail.com");
        addOrganizationPage.setAddress("123 New Street,Maharagama");
        addOrganizationPage.setWebsite("http://neworganization.com");
        addOrganizationPage.clickSave();
        // Add assertion to verify successful addition
    }

//    @Test(priority = 2)
//    public void testMandatoryFieldValidation() {
//        addOrganizationPage.clickSave();
//        Assert.assertTrue(addOrganizationPage.isErrorMessageDisplayed());
//    }

    @Test(priority = 3)
    public void testDuplicateOrganization() {
    	
        addOrganizationPage.setOrganizationName("New Organization");
        addOrganizationPage.setOrganizationDescription("New Organization Description");
        addOrganizationPage.setTelephoneNumber("0112347973");
        addOrganizationPage.setEmail("neworganization@gmail.com");
        addOrganizationPage.setAddress("123 New Street,Maharagama");
        addOrganizationPage.setWebsite("http://neworganization.com");
        addOrganizationPage.clickSave();
        // Add assertion to verify error for duplicate
        Assert.assertTrue(addOrganizationPage.isErrorMessageDisplayed());
    }

    @Test(priority = 4)
    public void testMissingRequiredFields() {
        addOrganizationPage.setOrganizationLevel("2");
        addOrganizationPage.clickSave();
        // Add assertion to verify error for missing required fields
        Assert.assertTrue(addOrganizationPage.isErrorMessageDisplayed());
    }

    @Test(priority = 5)
    public void testMaxFieldLengths() {

        addOrganizationPage.setOrganizationName("A".repeat(255));
        addOrganizationPage.setOrganizationDescription("B".repeat(255));
        addOrganizationPage.setTelephoneNumber("0115734871");
        addOrganizationPage.setEmail("maxoraganization@example.com");
        addOrganizationPage.setAddress("C".repeat(255));
        addOrganizationPage.setWebsite("http://organization.com");
        addOrganizationPage.clickSave();
        // Add assertion to verify successful addition
    }

    @Test(priority = 6)
    public void testSpecialCharacters() {

        addOrganizationPage.setOrganizationName("@New!Org#");
        addOrganizationPage.setOrganizationDescription("Special@Characters#Description!");
        addOrganizationPage.setTelephoneNumber("0769234899");
        addOrganizationPage.setEmail("specialchar@example.com");
        addOrganizationPage.setAddress("123# Spe&&cial Street@!, Maharagama");
        addOrganizationPage.setWebsite("http://specialcharacters.com");
        addOrganizationPage.clickSave();
        // Add assertion to verify successful addition
    }

    @Test(priority = 7)
    public void testIncorrectTelephoneNumberFormat() {

        addOrganizationPage.setOrganizationName("Test Organization");
        addOrganizationPage.setOrganizationDescription("Test Description");
        addOrganizationPage.setTelephoneNumber("abcd1234");
        addOrganizationPage.setEmail("testorg@example.com");
        addOrganizationPage.setAddress("123 Test Street,Maharagama");
        addOrganizationPage.setWebsite("http://testorganization.com");
        addOrganizationPage.clickSave();
        // Add assertion to verify to error message
        Assert.assertTrue(addOrganizationPage.isErrorMessageDisplayed());
    }

    @Test(priority = 8)
    public void testInvalidEmailFormat() {

        addOrganizationPage.setOrganizationName("Test Org");
        addOrganizationPage.setOrganizationDescription("Test Description");
        addOrganizationPage.setTelephoneNumber("0114568790");
        addOrganizationPage.setEmail("invalidemail");
        addOrganizationPage.setAddress("123 Test Street, Maharagama");
        addOrganizationPage.setWebsite("http://testorganization.com");
        addOrganizationPage.clickSave();
        // Add assertion to verify to error message
        Assert.assertTrue(addOrganizationPage.isErrorMessageDisplayed());
    } 
    
    
   
}

