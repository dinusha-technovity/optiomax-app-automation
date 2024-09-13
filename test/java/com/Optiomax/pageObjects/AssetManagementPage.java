package com.Optiomax.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssetManagementPage {

    private WebDriver driver;

    public AssetManagementPage (WebDriver driver) {
        this.driver = driver;
    }
    
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    private By assetManagementCards = By.cssSelector("div[class='grid gap-2 2xl:grid-cols-5 min-[1200px]:grid-cols-3 min-[768px]:grid-cols-2 min-[640px]:grid-cols-1 mb-1 rounded bg-white dark:bg-[#121212]']");
    private By assetRecordRegisterBtn = By.xpath("//button[normalize-space()='Assets Record & Register']");
    private By searchInput = By.xpath("//input[@id='simple-search']");
    private By noResultsMessage = By.xpath(""); 
    private By closeAssetRecordRegisterPopup = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[1]/a");
    private By viewAssetManagementBtn = By.xpath("//body//main//div//div//div//div//div//div//div[1]//div[1]//div[2]//div[1]//div[2]//a[1]//*[name()='svg']");
    private By updateAssetManagementBtn = By.xpath("//body//main//div//div//div//div//div//div//div[1]//div[1]//div[2]//div[1]//div[2]//a[2]//*[name()='svg']");
    private By deleteAssetManagementBtn = By.xpath("//body//main//div//div//div//div//div//div//div[1]//div[1]//div[2]//div[1]//div[2]//a[3]//*[name()='svg']");
    private By listView = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/div[2]/button[2]");
    private By gridView = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/div[2]/button[1]");
    private By next = By.xpath("/html/body/main/div/div/main/div/div/div[3]/nav/ul/li[6]/button");
    private By previous = By.xpath("/html/body/main/div/div/main/div/div/div[3]/nav/ul/li[1]/button");
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    public boolean isPageLoaded() {
    	return driver.getPageSource().contains("assets_management");
    }

    public int getAssetManagementCardCount() {
        List<WebElement> cards = driver.findElements(assetManagementCards);
        return cards.size();
    }

    public void clickAssetRecordRegister() {
        driver.findElement(assetRecordRegisterBtn).click();
    }
    
    public void clickCloseAssetRecordRegister() {
    	driver.findElement(closeAssetRecordRegisterPopup).click();
    }
    
    public void clickViewAssetManagement() {
        driver.findElements(viewAssetManagementBtn).get(0).click(); 
    }

    public void clickUpdateAssetManagement() {
        driver.findElements(updateAssetManagementBtn).get(0).click(); 
    }

    public void clickDeleteAssetManagement() {
        driver.findElements(deleteAssetManagementBtn).get(0).click(); 
    }

    public void searchAssetManagement(String query) {
        driver.findElement(searchInput).sendKeys(query);
    }

    public boolean isNoResultsMessageDisplayed() {
        return driver.findElement(noResultsMessage).isDisplayed();
    }

    public boolean isAssetManagementPresent(String name) {
        List<WebElement> cards = driver.findElements(assetManagementCards);
        for (WebElement card : cards) {
            if (card.getText().contains(name)) {
                return true;
            }
        }
        return false;
    }

    public void searchBySerialNumber(String serialNumber) {
        WebElement searchBoxElement = driver.findElement(searchInput);
        searchBoxElement.clear();
        searchBoxElement.sendKeys(serialNumber);
        searchBoxElement.submit();
    }

    public WebElement getCardDetail(int index, By locator) {
        return driver.findElements(assetManagementCards).get(index).findElement(locator);
    }
    
    public void clickListView() {
    	driver.findElement(listView).click();
    }
    
    public void clickGridView() {
    	driver.findElement(gridView).click();
    }
    
    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
    
    public void clickNext() {
    	driver.findElement(next).click();
    }
    
    public void clickPrevious() {
    	driver.findElement(previous).click();
    }
    
}    
