package com.Optiomax.pageObjetcs;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssetRequisitionPage {

    private WebDriver driver;

    public AssetRequisitionPage (WebDriver driver) {
        this.driver = driver;
    }
    
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    private By assetRequisitionCards = By.cssSelector("div[class='grid gap-4 2xl:grid-cols-3 min-[1200px]:grid-cols-2 min-[768px]:grid-cols-2 min-[640px]:grid-cols-1 mb-1 rounded bg-white dark:bg-[#121212]']");
    private By addNewAssetRequisitionButton = By.xpath("//button[normalize-space()='Add new Asset Requisition']");
    private By searchInput = By.xpath("//input[@id='simple-search']");
    //private By noResultsMessage = By.cssSelector("");
    private By moreDetailsButtons = By.xpath("//button[contains(text(),'More details')]");
    private By searchBox = By.xpath("//input[@id='simple-search']");
    private By approvalStatus = By.xpath("(//p[contains(text(),'Approvel Pending')])[1]");
    private By closeAssetRequisitionPopup = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[1]/a");
    //private By requestId = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]");
    //private By requestDate = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div[1]/div[1]/div[2]/div[2]");
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    public boolean isPageLoaded() {
    	return driver.getPageSource().contains("asset_requisitions");
    }

    public int getAssetRequisitionCardCount() {
        List<WebElement> cards = driver.findElements(assetRequisitionCards);
        return cards.size();
    }

    public void clickAddNewAssetRequisition() {
        driver.findElement(addNewAssetRequisitionButton).click();
    }
    
    public void clickCloseAssetRequisition() {
    	driver.findElement(closeAssetRequisitionPopup).click();
    }

//    public void clickUpdateAssetRequisitionButton() {
//        driver.findElements(editAssetRequisitionButton).get(0).click(); 
//    }
//
//    public void clickDeleteAssetRequisitionButton() {
//        driver.findElements(deleteAssetRequisitionButton).get(0).click(); 
//    }

    public void searchAssetRequisition(String query) {
        driver.findElement(searchInput).sendKeys(query);
    }

//    public boolean isNoResultsMessageDisplayed() {
//        return driver.findElement(noResultsMessage).isDisplayed();
//    }

    public boolean isAssetRequisitionPresent(String name) {
        List<WebElement> cards = driver.findElements(assetRequisitionCards);
        for (WebElement card : cards) {
            if (card.getText().contains(name)) {
                return true;
            }
        }
        return false;
    }

    public void clickMoreDetails(int index) {
        driver.findElements(moreDetailsButtons).get(index).click();
    }

    public void searchByRequestId(String requestId) {
        WebElement searchBoxElement = driver.findElement(searchBox);
        searchBoxElement.clear();
        searchBoxElement.sendKeys(requestId);
        searchBoxElement.submit();
    }

    public boolean isApprovalStatusDisplayed() {
        return !driver.findElements(approvalStatus).isEmpty();
    }

    public WebElement getCardDetail(int index, By locator) {
        return driver.findElements(assetRequisitionCards).get(index).findElement(locator);
    }
    
}
