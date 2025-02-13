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
    
    private By emailField = By.xpath("");
    private By passwordField = By.xpath("");
    private By rememberMeCheckbox = By.xpath("");
    private By signInButton = By.xpath("");

    private By assetManagementCards = By.cssSelector("div[class='grid gap-2 2xl:grid-cols-5 min-[1200px]:grid-cols-3 min-[768px]:grid-cols-2 min-[640px]:grid-cols-1 mb-1 rounded bg-white dark:bg-[#121212]']");
    private By assetRecordRegisterBtn = By.xpath("//button[normalize-space()='Assets Record & Register']");
    private By searchInput = By.xpath("//input[@id='simple-search']");
    private By closeAssetRecordRegisterPopup = By.xpath("//a[@type='button']");
    private By viewAssetManagementBtn = By.xpath("//button[@class='text-yellow-400 hover:text-yellow-500 transition-transform transform hover:scale-110 text-2xl']");
    private By tagAssetManagementBtn = By.xpath("//button[@class='text-red-400 hover:text-red-500 transition-transform transform hover:scale-110 text-2xl']");
    private By updateAssetManagementBtn = By.xpath("//button[@class='text-yellow-400 hover:text-yellow-500 transition-transform transform hover:scale-110 text-2xl']");
    private By deleteAssetManagementBtn = By.xpath("//button[@class='text-red-400 hover:text-red-500 transition-transform transform hover:scale-110 text-2xl']");
    private By gridView = By.xpath("//div[@role='group']//button[1]");
    private By listView = By.xpath("//div[@role='group']//button[2]");   
    private By next = By.xpath("//button[normalize-space()='Next']");
    private By previous = By.xpath("//button[normalize-space()='Previous']");
    private By noResultsMessage = By.xpath("");
        
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    public boolean isPageLoaded() {
    	return driver.getPageSource().contains("asset_management");
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
    
    public void clickTagAssetManagement() {
    	driver.findElements(tagAssetManagementBtn).get(0).click();
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

    public boolean isAssetManagementPresent(String name) {
        List<WebElement> cards = driver.findElements(assetManagementCards);
        for (WebElement card : cards) {
            if (card.getText().contains(name)) {
                return true;
            }
        }
        return false;
    }

//    public void searchBySerialNumber(String serialNumber) {
//        WebElement searchBoxElement = driver.findElement(searchInput);
//        searchBoxElement.clear();
//        searchBoxElement.sendKeys(serialNumber);
//        searchBoxElement.submit();
//    }

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
    
    public boolean isNoResultsMessagePresent(By message) {
    	return !driver.findElements(message).isEmpty();
    }
    
    public void clickNext() {
    	driver.findElement(next).click();
    }
    
    public void clickPrevious() {
    	driver.findElement(previous).click();
    }
    
}   
