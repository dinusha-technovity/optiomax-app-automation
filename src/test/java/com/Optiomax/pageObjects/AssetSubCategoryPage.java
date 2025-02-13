package com.Optiomax.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssetSubCategoryPage {

    private WebDriver driver;

    public AssetSubCategoryPage (WebDriver driver) {
        this.driver = driver;
    }
    
    private By emailField = By.xpath("");
    private By passwordField = By.xpath("");
    private By rememberMeCheckbox = By.xpath("");
    private By signInButton = By.xpath("");

    private By assetSubCategoryCards = By.xpath("");
    private By assetSearch = By.xpath("//input[@id='simple-search']");
    private By addNewAssetSubCategoryBtn = By.xpath("//button[normalize-space()='Add New Asset Categories']");
    private By addNewAssetSubCategoryCloseBtn = By.xpath("//a[@type='button']");
    private By viewDetailsBtn = By.xpath("//button[@class='p-2 rounded-lg bg-gray-100 hover:bg-gray-200 dark:bg-gray-800 dark:hover:bg-gray-700 transition duration-200 ease-in-out']");
    private By updateDetailsBtn = By.xpath("//button[@class='p-2 rounded-lg bg-yellow-100 hover:bg-yellow-200 dark:bg-yellow-800 dark:hover:bg-yellow-700 transition duration-200 ease-in-out']");
    private By updateReadingParametersBtn = By.xpath("//button[@class='p-2 rounded-lg bg-blue-100 hover:bg-blue-200 dark:bg-blue-800 dark:hover:bg-blue-700 transition duration-200 ease-in-out']");
    private By deleteBtn = By.xpath("//button[@class='p-2 rounded-lg bg-red-100 hover:bg-red-200 dark:bg-red-800 dark:hover:bg-red-700 transition duration-200 ease-in-out']");
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
    	return driver.getPageSource().contains("sub_asset_categories");
    }

    public int getAssetSubCategoriesCardCount() {
        List<WebElement> cards = driver.findElements(assetSubCategoryCards);
        return cards.size();
    }

    public void clickAssetSubCategory() {
    	driver.findElement(addNewAssetSubCategoryBtn).click();
    }
    
    public void clickAssetSubCategoryClose() {
    	driver.findElement(addNewAssetSubCategoryCloseBtn).click();
    }
    
    public void clickViewAssetSubCategory() {
        driver.findElements(viewDetailsBtn).get(0).click(); 
    }
    
    public void clickUpdateAssetCategory() {
    	driver.findElements(updateDetailsBtn).get(0).click();
    }

    public void clickUpdateReadingParameters() {
    	driver.findElements(updateReadingParametersBtn).get(0).click();
    }
    
    public void clickDeleteAssetCategory() {
    	driver.findElements(deleteBtn).get(0).click();
    }

    public void searchAssetItems(String query) {
        driver.findElement(assetSearch).sendKeys(query);
    }

    public boolean isAssetSubCategoryPresent(String name) {
        List<WebElement> cards = driver.findElements(assetSubCategoryCards);
        for (WebElement card : cards) {
            if (card.getText().contains(name)) {
                return true;
            }
        }
        return false;
    }

    public void searchByAssetSubCategory(String subCategory) {
        WebElement searchBoxElement = driver.findElement(assetSearch);
        searchBoxElement.clear();
        searchBoxElement.sendKeys(subCategory);
        searchBoxElement.submit();
    }

    public WebElement getCardDetail(int index, By locator) {
        return driver.findElements(assetSubCategoryCards).get(index).findElement(locator);
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


