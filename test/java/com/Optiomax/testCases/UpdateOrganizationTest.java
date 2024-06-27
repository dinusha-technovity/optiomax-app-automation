package com.Optiomax.testCases;

import com.Optiomax.pageObjetcs.BasePage;
import com.Optiomax.pageObjetcs.UpdateOrganizationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UpdateOrganizationTest extends BasePage {
    
	UpdateOrganizationPage updateOrganizationPage;

    @BeforeClass
    public void setUpTest() throws InterruptedException {
        updateOrganizationPage = new UpdateOrganizationPage(driver);
        updateOrganizationPage = PageFactory.initElements(driver, UpdateOrganizationPage.class);
        updateOrganizationPage.login("chamoddushyantha2017@gmail.com", "UMwI4u3w");
        Thread.sleep(5000);
        driver.get("http://app.optiomax.com/dashboard/organization");
        Thread.sleep(5000);
    } 

    @Test(priority = 1)
    public void verifyUpdatingExistingOrganizationEntity() throws InterruptedException {

    	Thread.sleep(5000);
    	
    	updateOrganizationPage.setAddButton();
    	
    	Thread.sleep(3000);
        updateOrganizationPage.setOrganizationName("Updated Organization Name");
        updateOrganizationPage.setOrganizationDescription("Updated Description");
        updateOrganizationPage.setTelephoneNumber("0117878989");
        updateOrganizationPage.setAddress("345 Street, Maharagama");
        updateOrganizationPage.setEmail("updated@example.com");
        updateOrganizationPage.setWebsite("http://updatedwebsite.com");
        
        Thread.sleep(4000);
        updateOrganizationPage.clickSave();
        
        Thread.sleep(4000);
        // Add assertions to verify successful update
        
    }

    @Test(priority = 2)
    public void verifyMandatoryFieldValidationOnUpdate() {
        updateOrganizationPage.setOrganizationName("");
        updateOrganizationPage.clickSave();
        Assert.assertEquals(updateOrganizationPage.getErrorMessage(), "Organization Name is required");
    }

    @Test(priority = 3)
    public void verifyErrorHandlingWhenUpdatingToDuplicateData() {
        updateOrganizationPage.setOrganizationName("Duplicate Name");
        updateOrganizationPage.clickSave();
        Assert.assertEquals(updateOrganizationPage.getErrorMessage(), "Organization Name already exists");
        
    }

    @Test(priority = 4)
    public void verifyErrorHandlingWhenRequiredFieldsAreCleared() {
        updateOrganizationPage.setOrganizationName("");
        updateOrganizationPage.clickSave();
        Assert.assertEquals(updateOrganizationPage.getErrorMessage(), "Organization Name is required");
    }

    @Test(priority = 5)
    public void verifySuccessfulUpdateOfOptionalFields() {
        updateOrganizationPage.setOrganizationDescription("Updated Optional Description");
        updateOrganizationPage.setAddress("Updated Optional Address");
        updateOrganizationPage.setWebsite("http://updatedoptionalwebsite.com");
        updateOrganizationPage.clickSave();
        // Add assertions to verify successful update of optional fields
        
    }

    @Test(priority = 6)
    public void verifyUpdateWithInvalidEmailFormat() {
        updateOrganizationPage.setEmail("invalid-email-format");
        updateOrganizationPage.clickSave();
        Assert.assertEquals(updateOrganizationPage.getErrorMessage(), "Invalid email format");
    }

    @Test(priority = 7)
    public void verifyErrorHandlingForIncorrectTelephoneNumberFormat() {
        updateOrganizationPage.setTelephoneNumber("abc123");
        updateOrganizationPage.clickSave();
        Assert.assertEquals(updateOrganizationPage.getErrorMessage(), "Invalid telephone number format");
    }
    
    @Test(priority = 8)
    public void verifyEmailAddressFormat() {
        updateOrganizationPage.setEmail("invalidemail");
        updateOrganizationPage.clickSave();
        Assert.assertEquals(updateOrganizationPage.getErrorMessage(), "Invalid email address format.");
    }
    
    @Test(priority=9)
    public void verifyWebsiteFormat() {
        updateOrganizationPage.setEmail("invalidwebsite");
        updateOrganizationPage.clickSave();
        Assert.assertEquals(updateOrganizationPage.getErrorMessage(), "Invalid website format");
    }
    
}

