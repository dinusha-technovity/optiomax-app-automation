package com.Optiomax.pageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebLoginPage {
    private WebDriver driver;

    // Locators
    private By emailField = By.id("user_email");
    private By passwordField = By.id("password");
    private By signInButton = By.id("sign_in_button");
    private By keepMeLoggedInCheckbox = By.id("keep_me_logged_in");
    private By forgotPasswordLink = By.id("forgot_password");
    private By errorMessage = By.id("error_message");
    private By logoutButton = By.id("");

    // Constructor
    public WebLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with elements
    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void clickForgotPassword() {
        driver.findElement(forgotPasswordLink).click();
    }

    public void toggleKeepMeLoggedIn() {
        WebElement checkbox = driver.findElement(keepMeLoggedInCheckbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
    
    public Set<Cookie> getCookies() {
        return driver.manage().getCookies();
    }

    public void addCookies(Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
    
    // Method to verify if the user is logged in
    public boolean isUserLoggedIn() {
        return driver.findElements(logoutButton).size() > 0;
    }
    
}

