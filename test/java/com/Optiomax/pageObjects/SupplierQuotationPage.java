package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SupplierQuotationPage extends BasePage {
    private WebDriver driver;

    public SupplierQuotationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");
    
    private By supplierQuotationCards = By.cssSelector("div[class='grid gap-4 2xl:grid-cols-3 min-[1200px]:grid-cols-2 min-[768px]:grid-cols-2 min-[640px]:grid-cols-1 mb-1 rounded bg-white dark:bg-[#121212]']");
    private By viewSupplierQuotationDetails = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div[2]/a");
    private By viewSupplierQuotationClose = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[1]/a");
    private By searchInput = By.xpath("//input[@id='simple-search']");
    //private By noResultsMessage = By.xpath("//p[normalize-space()='No data available']");
    private By exportCSVButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/button[1]");
    private By filterButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/button[2]");
    private By listViewToggle = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/div[2]/button[2]");
    private By gridViewToggle = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/div[2]/button[1]");
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }
    
    public boolean isPageLoaded() {
    	return driver.getPageSource().contains("staff");
    }

    public int getSupplierQuotationCardCount() {
        List<WebElement> cards = driver.findElements(supplierQuotationCards);
        return cards.size();
    }
    
    public void viewSupplierQuotation() {
    	driver.findElement(viewSupplierQuotationDetails).click();
    }
    
    public void viewSupplierQuotationClose() {
    	driver.findElement(viewSupplierQuotationClose).click();
    }

    public void searchSupplierQuotation(String query) {
        driver.findElement(searchInput).sendKeys(query);
    }

//    public boolean isNoResultsMessageDisplayed() {
//        return driver.findElement(noResultsMessage).isDisplayed();
//    }

    public boolean isSupplierQuotationPresent(String name) {
        List<WebElement> cards = driver.findElements(supplierQuotationCards);
        for (WebElement card : cards) {
            if (card.getText().contains(name)) {
                return true;
            }
        }
        return false;
    }
    
    public void clickExportCSV() {
        driver.findElement(exportCSVButton).click();
    }

    public void clickFilterButton() {
        driver.findElement(filterButton).click();
    }

    public void toggleListView() {
        driver.findElement(listViewToggle).click();
    }

    public void toggleGridView() {
        driver.findElement(gridViewToggle).click();
    }
    
    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
    
}

