package com.Optiomax.testCases;

import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.BasePage;
import com.Optiomax.pageObjetcs.SignInPage;

public class SignInTest extends BasePage {

    @Test
    public void testValidEmailAndPassword() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("chamoddushyantha2017@gmail.com", "UMwI4u3w", false);
        
		// Assert successful login
//      WebElement dashboard = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[1]/a/img")); 
//      Assert.assertTrue(dashboard.isDisplayed());
        
    }

    @Test
    public void testCorrectEmailIncorrectPassword() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("chamoddushyantha2017@gmail.com", "InCorrect123", false);
        
		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testIncorrectEmailCorrectPassword() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("invalid.email@domain.com", "UMwI4u3w", false);
        
		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testCorrectEmailEmptyPassword() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("chamoddushyantha2017@gmail.com", "", false);
        
		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testCorrectPasswordEmptyEmail() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("", "chamoddushyantha2017@gmail.com", false);

		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testEmptyEmailEmptyPassword() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("", "", false);

        // Add assertions for error message or failure
        // WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        // Assert.assertTrue(errorMessage.isDisplayed());
    }
 
    @Test
    public void testInvalidEmailFormat() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("testuser@optimax", "UMwI4u3w", false);

        // Add assertions for error message or failure
        // WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        // Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testUnregisteredEmail() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("unregistered.email@domain.com", "UMwI4u3w", false);

        // Add assertions for error message or failure
        // WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        // Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testRememberMeFunctionality() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("chamoddushyantha2017@gmail.com", "UMwI4u3w", true);
        
		// Perform assertions for "Remember me" functionality
		// This may require logging out and then navigating back to the sign-in page to
		// check if the email is prefilled
    }

    @Test
    public void testSpecialCharactersInEmail() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("special!char@domain.com", "ValidPassword123!", false);

        // Add assertions for error message or failure
        // WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        // Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testLeadingTrailingSpacesInEmail() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("  valid.email@domain.com  ", "UMwI4u3w", false);

        // Add assertions for error message or failure
        // WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        // Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testLeadingTrailingSpacesInPassword() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("chamoddushyantha2017@gmail.com", "  UMwI4u3w  ", false);

        // Add assertions for error message or failure
        // WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        // Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testInvalidCharactersInEmail() throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("invalid@chars*domain.com", "UMwI4u3w", false);

        // Add assertions for error message or failure
        // WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        // Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testExceedingMaxLengthInEmail() throws InterruptedException {
        // Generate a long email string
        String longEmail = "longemail".repeat(20) + "@domain.com";
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(longEmail, "ValidPassword123!", false);

        // Add assertions for error message or failure
        // WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        // Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testExceedingMaxLengthInPassword() throws InterruptedException {
        // Generate a long password string
        String longPassword = "longpassword".repeat(10);
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("valid.email@domain.com", longPassword, false);

        // Add assertions for error message or failure
        // WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        // Assert.assertTrue(errorMessage.isDisplayed());
    }
}
