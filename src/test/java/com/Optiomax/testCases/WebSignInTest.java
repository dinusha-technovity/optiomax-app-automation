package com.Optiomax.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.WebSignInPage;


public class WebSignInTest extends BasePage {

    private WebSignInPage webSignInPage;

    @BeforeMethod
    public void setupTest() {
        setup();
        driver.get("http://optiomax.com/"); 
        webSignInPage = new WebSignInPage();
    }

    @Test(priority = 1)
    public void testValidSignup() {
    	webSignInPage.monthlySelection();
    	webSignInPage.freePackageSelection();
    	webSignInPage.enterPersonalInfo("John", "Doe", "john@example.com", "john@example.com", "Password123$", "Password123$", "123 Street", "johndoe", "1234567890");
    	webSignInPage.enterBusinessInfo("TechCorp", "contact@techcorp.com", "9876543210", "9876543210", "456 Business Ave", "www.techcorp.com");
    	webSignInPage.inviteUsers("employee1", "employee1@techcorp.com");	

        Assert.assertFalse(webSignInPage.isErrorDisplayed(), "Signup failed unexpectedly!");
    }

    @Test(priority = 2)
    public void testSignupWithMissingFields() throws InterruptedException {
    	webSignInPage.yearlySelection();
    	webSignInPage.enterPersonalInfo("", "", "", "", "", "", "", "", "");
    	Thread.sleep(3000);
    	
		String firstNameError = webSignInPage.getRequiredFieldErrorMessage("fName");
		String lastNameError = webSignInPage.getRequiredFieldErrorMessage("lName");
		String addressError = webSignInPage.getRequiredFieldErrorMessage("addr");
		String emailError = webSignInPage.getRequiredFieldErrorMessage("mail");
		String reEnterError = webSignInPage.getRequiredFieldErrorMessage("reMail");
		String userNameError = webSignInPage.getRequiredFieldErrorMessage("uName");
		String passwordError = webSignInPage.getRequiredFieldErrorMessage("pass");
		String reEnterPasswordError = webSignInPage.getRequiredFieldErrorMessage("rePass");
		String contactNumberError = webSignInPage.getRequiredFieldErrorMessage("contact");

		Assert.assertEquals(firstNameError, "Name is required"); 
		Assert.assertEquals(lastNameError, "Name is required"); 
		Assert.assertEquals(addressError, "Address is required"); 
		Assert.assertEquals(emailError, "Email is required"); 
		Assert.assertEquals(reEnterError, "Please re-enter your email"); 
		Assert.assertEquals(userNameError, "Name is required"); 
		Assert.assertEquals(passwordError, "Password is required"); 
		Assert.assertEquals(reEnterPasswordError, "Please re-enter your password"); 
		Assert.assertEquals(contactNumberError, "Contact number is required"); 
		
        Assert.assertTrue(webSignInPage.isErrorDisplayed(), "Error message not displayed for missing fields!");
    }
    
    
    @Test(priority = 3)
    public void testSignWithMissingBusinessInformation() {
    	webSignInPage.yearlySelection();
    	webSignInPage.enterPersonalInfo("John", "Doe", "john@example.com", "john@example.com", "Password123$", "Password123$", "123 Street", "johndoe", "1234567890");
    	
    	webSignInPage.enterBusinessInfo("", "", "", "", "", "");
    	
		String companyNameError = webSignInPage.getRequiredFieldErrorMessage("fName");
		String companyEmailAddress = webSignInPage.getRequiredFieldErrorMessage("lName");
		String companyContactNumberError = webSignInPage.getRequiredFieldErrorMessage("addr");
		String companyContactPersonNumberError = webSignInPage.getRequiredFieldErrorMessage("mail");
		String companyAddressError = webSignInPage.getRequiredFieldErrorMessage("reMail");
		String companyWebsiteError = webSignInPage.getRequiredFieldErrorMessage("uName");

		Assert.assertEquals(companyNameError, "Company name is required"); 
		Assert.assertEquals(companyEmailAddress, "Company Email is required"); 
		Assert.assertEquals(companyContactNumberError, "Company contact number is required"); 
		Assert.assertEquals(companyContactPersonNumberError, "Company contact person number is required"); 
		Assert.assertEquals(companyAddressError, "Company address is required"); 
		Assert.assertEquals(companyWebsiteError, "Company Website is required"); 
		
		Assert.assertTrue(webSignInPage.isErrorDisplayed(), "Error message not displayed for missing fields!");
    	
    }
    
    @Test(priority = 4)
    public void testInvalidEmailFormat() {
    	webSignInPage.enterPersonalInfo("John", "Doe", "invalidemail", "invalidemail", "Password123!", "Password123!", "123 Street", "johndoe", "1234567890");

    	String invalidEmailError = webSignInPage.getRequiredFieldErrorMessage("mail");
    	Assert.assertEquals(invalidEmailError, "Invalid email");
        Assert.assertTrue(webSignInPage.isErrorDisplayed(), "Error message not displayed for invalid email format!");
    }

    @Test(priority = 5)
    public void testPasswordMismatch() {
    	webSignInPage.enterPersonalInfo("John", "Doe", "john@example.com", "john@example.com", "Password123!", "WrongPassword", "123 Street", "johndoe", "1234567890");
    	
    	String passswordMismatchError = webSignInPage.getRequiredFieldErrorMessage("pass");
    	Assert.assertEquals(passswordMismatchError, "Password must match");
        Assert.assertTrue(webSignInPage.isErrorDisplayed(), "Error message not displayed for password mismatch!");
    }

    @Test(priority = 6)
    public void testWeakPassword() {
    	webSignInPage.enterPersonalInfo("John", "Doe", "john@example.com", "john@example.com", "123", "123", "123 Street", "johndoe", "1234567890");
    	
    	String weakPasswordError = webSignInPage.getRequiredFieldErrorMessage("pass");
    	Assert.assertEquals(weakPasswordError, "Password must be at least 8 characters long");
        Assert.assertTrue(webSignInPage.isErrorDisplayed(), "Error message not displayed for weak password!");
    }

    @Test(priority = 7)
    public void testInvalidPhoneNumber() {
    	webSignInPage.enterPersonalInfo("John", "Doe", "john@example.com", "john@example.com", "Password123!", "Password123!", "123 Street", "johndoe", "abc123");
        Assert.assertTrue(webSignInPage.isErrorDisplayed(), "Error message not displayed for invalid phone number!");
    }
    
    @Test(priority = 8)
    public void testInvalidCompanyEmailFormatBusinessInformation() {
    	webSignInPage.enterPersonalInfo("John", "Doe", "john@example.com", "john@example.com", "Password123!", "Password123!", "123 Street", "johndoe", "abc123");
    	webSignInPage.enterBusinessInfo("ABC Company", "invalid", "0765478902", "0765478989", "456 Business Ave", "www.abc.com");

    	String invalidEmailError = webSignInPage.getRequiredFieldErrorMessage("mail");
    	Assert.assertEquals(invalidEmailError, "Invalid email");
        Assert.assertTrue(webSignInPage.isErrorDisplayed(), "Error message not displayed for invalid email format!");
    }
    
    @Test(priority = 9)
    public void testInvalidPhoneNumberFormatBusinessInformation() throws InterruptedException {
    	webSignInPage.enterPersonalInfo("Peter", "James", "peter@example.com", "peter@example.com", "Password123$", "Password123$", "123 Street Colombo", "peterJames", "test1234");
    	webSignInPage.enterBusinessInfo("Test Company", "test@company.com", "0765348901", "0112348907", "264 Test Ave ", "https://www.test.com");
    	Thread.sleep(3000);
    	
    	String invalidPhoneNumberError = webSignInPage.getRequiredFieldErrorMessage("compNum");
    	Assert.assertEquals(invalidPhoneNumberError, "Invalid Contact Number");
    	Assert.assertEquals(webSignInPage.isErrorDisplayed(), "Error message not displayed for invalid contact number!");
    }
    
    @Test(priority = 10)
    public void testInvalidCompanyWebsiteBusinessInformation() throws InterruptedException {
    	webSignInPage.enterPersonalInfo("Joseph", "david", "test@gmail.com", "test@gmail.com", "Password234&", "Password234&", "234 Street Kandy", "josephDavid", "https://www.test.com");
    	webSignInPage.enterBusinessInfo("Acme Operation", "acme@operation.com", "0765348901", "0112348907", "658 Test Ave ", "test");
    	Thread.sleep(3000);
    	
    	String invalidWebsiteError = webSignInPage.getRequiredFieldErrorMessage("");
    	Assert.assertEquals(invalidWebsiteError, "Invalid Website");
    	Assert.assertEquals(webSignInPage.isErrorDisplayed(), "Error message is not displayed for invalid website");
    }
    
    
    @Test(priority = 11)
    public void testInvalidContactPerson() {
    	webSignInPage.enterPersonalInfo("Joseph", "david", "test@gmail.com", "test@gmail.com", "Password234&", "Password234&", "234 Street Kandy", "josephDavid", "https://www.test.com");
    }
    
    
    @AfterMethod
    public void tearDownTest() {
        //tearDown();
    }
    
}


