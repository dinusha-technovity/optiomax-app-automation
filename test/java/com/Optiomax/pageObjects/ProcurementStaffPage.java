package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProcurementStaffPage extends BasePage {
    private WebDriver driver;

    public ProcurementStaffPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");
    
    private By staffCards = By.xpath("");
    private By addNewMemberButton = By.xpath("//button[normalize-space()='Add New Member']");
    private By updateButton = By.cssSelector("/html/body/main/div/div/main/div/div/div[2]/div/div[1]/div[2]/div/a[1]/svg/path");
    private By deleteButton = By.cssSelector("/html/body/main/div/div/main/div/div/div[2]/div/div[1]/div[2]/div/a[2]");
    private By searchInput = By.cssSelector("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[1]/div/div/input");
    private By noResultsMessage = By.cssSelector("//p[normalize-space()='No data available']");
  //  private By results = By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[5]/div/div/div");
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("Staff");
    }

    public int getStaffCardCount() {
        List<WebElement> cards = driver.findElements(staffCards);
        return cards.size();
    }

    public void clickAddNewMember() {
        driver.findElement(addNewMemberButton).click();
    }

    public void clickUpdateButton() {
        driver.findElements(updateButton).get(0).click(); 
    }

    public void clickDeleteButton() {
        driver.findElements(deleteButton).get(0).click(); 
    }

    public void searchStaff(String query) {
        driver.findElement(searchInput).sendKeys(query);
    }

    public boolean isNoResultsMessageDisplayed() {
        return driver.findElement(noResultsMessage).isDisplayed();
    }

    public boolean isStaffPresent(String name) {
        List<WebElement> cards = driver.findElements(staffCards);
        for (WebElement card : cards) {
            if (card.getText().contains(name)) {
                return true;
            }
        }
        return false;
    }
}

