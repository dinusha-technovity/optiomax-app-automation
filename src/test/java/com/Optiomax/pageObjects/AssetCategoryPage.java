package com.Optiomax.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssetCategoryPage {

    private WebDriver driver;

    public AssetCategoryPage (WebDriver driver) {
        this.driver = driver;
    }
    
    private By emailField = By.xpath("");
    private By passwordField = By.xpath("");
    private By rememberMeCheckbox = By.xpath("");
    private By signInButton = By.xpath("");

    private By assetCategoryCards = By.xpath("");
    private By assetSearch = By.xpath("//input[@id='simple-search']");
    private By addNewAssetCategoryBtn = By.xpath("//button[normalize-space()='Add New Asset Category']");
    private By addNewAssetcategoryCloseBtn = By.xpath("//a[@type='button']");
    private By viewDetailsBtn = By.xpath("//button[@class='p-2 rounded-lg bg-gray-100 hover:bg-gray-200 dark:bg-gray-800 dark:hover:bg-gray-700 transition duration-200']");
    private By editDetailsBtn = By.xpath("//button[@class='p-2 rounded-lg bg-yellow-100 hover:bg-yellow-200 dark:bg-yellow-800 dark:hover:bg-yellow-700 transition duration-200']");
    private By updateReadingParametersBtn = By.xpath("//button[@class='p-2 rounded-lg bg-blue-100 hover:bg-blue-200 dark:bg-blue-800 dark:hover:bg-blue-700 transition duration-200']");
    private By deleteBtn = By.xpath("//button[@class='p-2 rounded-lg bg-red-100 hover:bg-red-200 dark:bg-red-800 dark:hover:bg-red-700 transition duration-200']");
    private By listView = By.xpath("//div[@role='group']//button[2]");
    private By gridView = By.xpath("//div[@role='group']//button[1]");
    private By nextBtn = By.xpath("//button[normalize-space()='Next']");
    private By previousBtn = By.xpath("//button[normalize-space()='Previous']");
    
       
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    public boolean isPageLoaded() {
    	return driver.getPageSource().contains("asset_categories");
    }

    public int getAssetCategoriesCardCount() {
        List<WebElement> cards = driver.findElements(assetCategoryCards);
        return cards.size();
    }

    public void clickAssetCategory() {
    	driver.findElement(addNewAssetCategoryBtn).click();
    }
    
    public void clickAssetCategoryClose() {
    	driver.findElement(addNewAssetcategoryCloseBtn).click();
    }
    
    public void clickViewAssetCategory() {
        driver.findElements(viewDetailsBtn).get(0).click(); 
    }
    
    public void clickEditAssetCategory() {
    	driver.findElements(editDetailsBtn).get(0).click();
    }

    public void clickUpdateReadingParameters() {
    	driver.findElements(updateReadingParametersBtn).get(0).click();
    }
    
    public void clickDeleteAssetCategory() {
    	driver.findElements(deleteBtn).get(0).click();
    }

    public void searchAssetManagement(String query) {
        driver.findElement(assetSearch).sendKeys(query);
    }

    public boolean isAssetCategoryPresent(String name) {
        List<WebElement> cards = driver.findElements(assetCategoryCards);
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
        return driver.findElements(assetCategoryCards).get(index).findElement(locator);
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
    	driver.findElement(nextBtn).click();
    }
    
    public void clickPrevious() {
    	driver.findElement(previousBtn).click();
    }
    
}   

