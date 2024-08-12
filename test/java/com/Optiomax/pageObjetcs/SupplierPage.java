package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;	

public class SupplierPage extends BasePage {
    private WebDriver driver;

    public SupplierPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");
    
    private By supplierCards = By.cssSelector("");
    private By addNewSupplierButton = By.xpath("");
    private By editButton = By.cssSelector("");
    private By deleteButton = By.cssSelector("");
    private By searchInput = By.cssSelector("");
    private By searchButton = By.cssSelector("");
    private By noResultsMessage = By.cssSelector("");
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("Supplier");
    }

    public int getSupplierCardCount() {
        List<WebElement> cards = driver.findElements(supplierCards);
        return cards.size();
    }

    public void clickAddNewSupplier() {
        driver.findElement(addNewSupplierButton).click();
    }

    public void clickEditButton() {
        driver.findElements(editButton).get(0).click(); 
    }

    public void clickDeleteButton() {
        driver.findElements(deleteButton).get(0).click(); 
    }

    public void searchStaff(String query) {
        driver.findElement(searchInput).sendKeys(query);
        driver.findElement(searchButton).click();
    }

    public boolean isNoResultsMessageDisplayed() {
        return driver.findElement(noResultsMessage).isDisplayed();
    }

    public boolean isStaffPresent(String name) {
        List<WebElement> cards = driver.findElements(supplierCards);
        for (WebElement card : cards) {
            if (card.getText().contains(name)) {
                return true;
            }
        }
        return false;
    }
    
}
