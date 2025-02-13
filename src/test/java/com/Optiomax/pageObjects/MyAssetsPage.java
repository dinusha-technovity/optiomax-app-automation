package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MyAssetsPage extends BasePage {
	private WebDriver driver;

	public MyAssetsPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
	private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
	private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
	private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

	private By searchInput = By.xpath("");
	private By myAssetsCards = By.xpath("");
	private By viewDetails = By.xpath("");
	private By addReadings = By.xpath("");
	private By assetItemDetailspopup = By.xpath("");
	private By addNewReadingspopup = By.xpath("");
	private By exportCSVBtn = By.xpath("");
	private By filterBtn = By.xpath("");
	private By listView = By.xpath("");
	private By gridView = By.xpath("");
	
	
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

	public void searchMyAssets(String query) {
		driver.findElement(searchInput).sendKeys(query);
	}

	public void viewDetails() {
		driver.findElement(viewDetails).click();
	}
	
	public void addReadings() {
		driver.findElement(addReadings).click();
	}

	public void assetItemDetailsDisplay() {
		driver.findElement(addNewReadingspopup).isDisplayed();
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
    
    public void clickListView() {
    	driver.findElement(listView).click();
    }
	
    public void clickGridView() {
    	driver.findElement(gridView).click();
    }
    
    public void clickExportCSV() {
    	driver.findElement(exportCSVBtn).click();
    }
    
    public void clickFilter() {
    	driver.findElement(filterBtn).click();
    }
    
    // Implement file download method 
    
}

