package com.Optiomax.pageObjects;

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

	private By supplierCards = By.cssSelector("div[class='grid gap-2 2xl:grid-cols-5 min-[1200px]:grid-cols-4 min-[768px]:grid-cols-3 min-[640px]:grid-cols-2 mb-1 rounded bg-white dark:bg-[#121212]']");
	private By addNewSupplierButton = By.xpath("//button[normalize-space()='Add New Supplier']");
	private By updateButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div[1]/div[2]/div/a[1]");
	private By deleteButton = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div[1]/div[2]/div/a[2]");
	private By searchInput = By.xpath("//input[@id='simple-search']");
	private By noResultsMessage = By.xpath("//p[normalize-space()='No data available']");
    private By exportCSVButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/button[1]");
    private By filterButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/button[2]");
    private By gridViewToggle = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/div[2]/button[1]");
    private By listViewToggle = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/div[2]/button[2]");

	public void login(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(rememberMeCheckbox).click();
		driver.findElement(signInButton).click();
	}

    public boolean isPageLoaded() {
    	return driver.getPageSource().contains("supplier");
    }
	
	public int getSupplierCardCount() {
		List<WebElement> cards = driver.findElements(supplierCards);
		return cards.size();
	}

	public void clickAddNewSupplier() {
		driver.findElement(addNewSupplierButton).click();
	}

	public void clickUpdateButton() {
		//driver.findElements(updateButton).get(0).click();
		driver.findElement(updateButton).click();
	}

	public void clickDeleteButton() {
		driver.findElement(deleteButton).click();
	}

	public void searchStaff(String query) {
		driver.findElement(searchInput).sendKeys(query);
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
