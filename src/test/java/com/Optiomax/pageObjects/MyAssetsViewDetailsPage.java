package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MyAssetsViewDetailsPage extends BasePage {
	private WebDriver driver;

	public MyAssetsViewDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailField = By.xpath("");
	private By passwordField = By.xpath("");
	private By rememberMeCheckbox = By.xpath("");
	private By signInButton = By.xpath("");

	private By viewDetailsBtn = By.xpath("");
	private By overviewTab = By.xpath("");
	private By specifications = By.xpath("");
	private By classifications = By.xpath("");
	private By documents = By.xpath("");
	private By purchaseInfo = By.xpath("");

	
	public void login(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(rememberMeCheckbox).click();
		driver.findElement(signInButton).click();
	}

    public boolean isPageLoaded() {
    	return driver.getPageSource().contains("users_asset_items");
    }
	
	public int getMyAssetsCardCount() {
		List<WebElement> cards = driver.findElements(myAssetsCards);
		return cards.size();
	}
	
	public void ViewAssetsItemsDetails() {
		driver.findElement(viewDetailsBtn).click();
	}
	
	public void clickOverviewTab() {
		driver.findElement(overviewTab).click();
	}
	
	public void clickSpecififcatinTab() {
		driver.findElement(specifications).click();
	}
	
	public void clickClassifications() {
		
	}

	public void addNewReadingsforItems() {
		driver.findElement(assetItemDetailspopup).isDisplayed();
	}
	
	public boolean isMyAssetsPresent(String assetName) {
		List<WebElement> cards = driver.findElements(myAssetsCards);
		for (WebElement card : cards) {
			if (card.getText().contains(assetName)) {
				return true;
			}
		}
		return false;
	}

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
    

    
}


