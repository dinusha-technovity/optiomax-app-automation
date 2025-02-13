package com.Optiomax.testCases;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.WebLoginPage;

public class WebLoginTest extends BasePage {
    
	private WebLoginPage webLoginPage;
	
//    @BeforeMethod
//    public void setupTest() {
//        //setUp();
//        driver.get("");
//        webLoginPage = new WebLoginPage(driver);
//    }
	
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/home/breadscrums/eclipse-workspace/OptiomaxAppAutomation");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/home/breadscrums/eclipse-workspace/OptiomaxAppAutomation");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "/home/breadscrums/eclipse-workspace/OptiomaxAppAutomation");
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.get("http://optiomax.com/");
    }

    @AfterMethod
    public void tearDownTest() {
        //tearDown();
    }

    @Test(priority = 1, description = "Test login with valid credentials")
    public void testLoginWithValidCredentials() {
    	webLoginPage.enterEmail("validuser@example.com");
    	webLoginPage.enterPassword("validpassword");
    	webLoginPage.clickSignInButton();

        // Assert successful login
        String expectedUrl = "";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User is not redirected to the homepage");
    }

    @Test(priority = 2, description = "Test login with invalid credentials")
    public void testLoginWithInvalidCredentials() {
    	webLoginPage.enterEmail("invaliduser@example.com");
    	webLoginPage.enterPassword("wrongpassword");
    	webLoginPage.clickSignInButton();

        // Assert error message
        String expectedErrorMessage = "Invalid credentials";
        Assert.assertEquals(webLoginPage.getErrorMessage(), expectedErrorMessage, "Error message is not as expected");
    }

    @Test(priority = 3, description = "Test login with empty fields")
    public void testLoginWithEmptyFields() {
    	webLoginPage.enterEmail("");
    	webLoginPage.enterPassword("");
    	webLoginPage.clickSignInButton();

        // Assert error message
        Assert.assertTrue(webLoginPage.isErrorMessageDisplayed(), "Error message is not displayed for empty fields");
    }

    @Test(priority = 4, description = "Test login with invalid email format")
    public void testLoginWithInvalidEmailFormat() {
    	webLoginPage.enterEmail("invalidemailformat");
    	webLoginPage.enterPassword("validpassword");
    	webLoginPage.clickSignInButton();

        // Assert error message
        Assert.assertTrue(webLoginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid email format");
    }

    @Test(priority = 5, description = "Test login with only email entered")
    public void testLoginWithOnlyEmail() {
    	webLoginPage.enterEmail("validuser@example.com");
    	webLoginPage.enterPassword("");
    	webLoginPage.clickSignInButton();

        // Assert error message
        Assert.assertTrue(webLoginPage.isErrorMessageDisplayed(), "Error message is not displayed when password is empty");
    }

    @Test(priority = 6, description = "Test login with only password entered")
    public void testLoginWithOnlyPassword() {
    	webLoginPage.enterEmail("");
    	webLoginPage.enterPassword("validpassword");
    	webLoginPage.clickSignInButton();

        // Assert error message
        Assert.assertTrue(webLoginPage.isErrorMessageDisplayed(), "Error message is not displayed when email is empty");
    }

    @Test(priority = 7, description = "Test login with special characters in email")
    public void testLoginWithSpecialCharactersInEmail() {
    	webLoginPage.enterEmail("!#$%&'*+/=?^_`{|}~@example.com");
    	webLoginPage.enterPassword("validpassword");
    	webLoginPage.clickSignInButton();

        // Assert error message
        Assert.assertTrue(webLoginPage.isErrorMessageDisplayed(), "Error message is not displayed for special characters in email");
        
    }

    @Test(priority = 8, description = "Test login with a very long password")
    public void testLoginWithVeryLongPassword() {
        String longPassword = "a".repeat(500);
        webLoginPage.enterEmail("validuser@example.com");
        webLoginPage.enterPassword(longPassword);
        webLoginPage.clickSignInButton();

        // Assert error message
        Assert.assertTrue(webLoginPage.isErrorMessageDisplayed(), "Error message is not displayed for very long password");
    }
    
    @Test(priority = 9,description="")
    public void testLongEmail() {
    	String longEmail = "test".repeat(200);
    	webLoginPage.enterEmail(longEmail);
    	webLoginPage.enterPassword("validPassword");
    	webLoginPage.clickSignInButton();
    	
    	// Assert error message
    	Assert.assertTrue(webLoginPage.isErrorMessageDisplayed(), "Error message is not displayed for very long email");
    	
    }

    @Test(priority=10,description= "keep me logged in")
    public void keepMeLoggedIn() throws InterruptedException {
        // Perform login	
    	webLoginPage.enterEmail("validuser@example.com");
    	webLoginPage.enterPassword("validpassword");
    	webLoginPage.toggleKeepMeLoggedIn();
    	webLoginPage.clickSignInButton();

    	Thread.sleep(3000);

        // Store session cookies
        Set<Cookie> cookiesBeforeClose = webLoginPage.getCookies();

        // Close and reopen browser
        driver.quit();
        //setUp(); 
        driver.get("");

        // Load stored cookies
        webLoginPage = new WebLoginPage(driver);
        webLoginPage.addCookies(cookiesBeforeClose);
        driver.navigate().refresh();
        
        Thread.sleep(3000);

        // Verify if user is still logged in
        webLoginPage = new WebLoginPage(driver);
        Assert.assertTrue(webLoginPage.isUserLoggedIn(), "User should be logged in after browser restart");
        
    }
    
    
    @Test(priority = 11, description="keep me logged in")
    public void keepMe() throws InterruptedException {
    	webLoginPage.enterEmail("ruvinyafernando@gmail.com");
    	webLoginPage.enterPassword("Password@1234#");
    	webLoginPage.toggleKeepMeLoggedIn();
    	
    	driver.manage().window().maximize();
    	driver.quit();
    	Thread.sleep(3000);
    	driver.get("");
    	
    	Set<Cookie> cookiesAfterClose = webLoginPage.getCookies();
    	
    	webLoginPage = new WebLoginPage(driver);
    	webLoginPage.addCookies(cookiesAfterClose);
    	
    	webLoginPage = new WebLoginPage(driver);
    	Assert.assertTrue(webLoginPage.isUserLoggedIn(), "User should be logged in after browser restart");  	
    	
    }
    
    
    
    
    
    
}

