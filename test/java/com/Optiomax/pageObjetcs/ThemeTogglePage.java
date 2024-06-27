package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThemeTogglePage extends BasePage {

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By rememberMeCheckbox = By.id("remember");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");
    private By toggleButton = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[1]/div");

    public ThemeTogglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) throws InterruptedException {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
        Thread.sleep(5000); 
    }

    public void switchToDarkMode() throws InterruptedException {
        driver.findElement(toggleButton).click();
        Thread.sleep(5000); 
    }

    public void switchToLightMode() throws InterruptedException {
        driver.findElement(toggleButton).click();
        Thread.sleep(5000); 
    }

    public String getBodyBackgroundColor() {
        return driver.findElement(By.tagName("body")).getCssValue("background-color");
    }
}
