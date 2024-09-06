package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrganizationPage extends BasePage {
	
    private WebDriver driver;

    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    // Locators
    private By expandCollapseButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/ul/li/ul/li[1]/div/div[4]/button/div"); 
    private By addOrganizationButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/ul/li/ul/li[1]/div/div[3]/button[1]"); 
    private By updateOrganizationButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/ul/li/ul/li[1]/div/div[3]/button[2]");
    private By expandCollapseButton1 = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/ul/li/ul/li[4]/div/div[4]/button/div");
    private By expandCollapseButton2 = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/ul/li/ul/li[4]/ul/li/div/div[4]/button/div");
    private By deleteOrganizationButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/ul/li/ul/li[4]/ul/li/ul/li/div/div[3]/button[3]"); 
    private By homePageLink = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[1]/nav/ol/li[1]/a");

    
    public OrganizationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }
    
    public void clickExpandCollapseButton() {
        driver.findElement(expandCollapseButton).click();
    }

    public boolean isAddOrganizationButtonVisible() {
        return driver.findElement(addOrganizationButton).isDisplayed();
    }

    public void clickAddOrganizationButton() {
        driver.findElement(addOrganizationButton).click();
    }

    public boolean isUpdateOrganizationButtonVisible() {
        return driver.findElement(updateOrganizationButton).isDisplayed();
    }
    
    public void clickExpandCollapseButton1() {
    	driver.findElement(expandCollapseButton1).click();
    }
    
    public void clickExpandCollapseButton2() {
    	driver.findElement(expandCollapseButton2).click();
    }

    public void clickUpdateOrganizationButton() {
        driver.findElement(updateOrganizationButton).click();
    }

    public boolean isDeleteOrganizationButtonVisible() {
        return driver.findElement(deleteOrganizationButton).isDisplayed();
    }

    public void clickDeleteOrganizationButton() {
        driver.findElement(deleteOrganizationButton).click();
    }

    public void navigateToHomePage() {
        driver.findElement(homePageLink).click();
    }

    public boolean isOrganizationPageDisplayed() {
        return driver.getCurrentUrl().contains("dashboard");
    }

}
