package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddProcurementStaffPage extends BasePage {
	private WebDriver driver;

	public AddProcurementStaffPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
	private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
	private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
	private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

	private By addNewMember = By.xpath("//button[normalize-space()='Add New Member']");
	private By usersDropdown = By.xpath("//input[@id='user']");
	private By assetClassesDropdown = By.xpath("//input[@id='assets_classes']");
	private By submitButton = By.xpath("//span[normalize-space()='Submit']");
	private By closeButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[1]/a");
	private By userErrorMessage = By.xpath("//div[@id='user_help']//div[contains(@class,'ant-form-item-explain-error')]");
	private By assetClassErrorMessage = By.xpath("//div[@id='assets_classes_help']//div[contains(@class,'ant-form-item-explain-error')]");
	private By successMessage = By.xpath("");


	public void login(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(rememberMeCheckbox).click();
		driver.findElement(signInButton).click();
	}
	
	public void clickAddNewMember() {
		driver.findElement(addNewMember).click();
	}

	public void selectUser(String user) {
		WebElement userDropdown = driver.findElement(usersDropdown);
		Select selectUser = new Select(userDropdown);
		selectUser.selectByVisibleText(user);
	}

	public void selectAssetClass(String assetClass) {
		WebElement assetClassDropdown = driver.findElement(assetClassesDropdown);
		Select selectAssetClass = new Select(assetClassDropdown);
		selectAssetClass.selectByVisibleText(assetClass);
	}

	public void clickSubmit() {
		driver.findElement(submitButton).click();
	}

	public void clickCloseButton() {
		driver.findElement(closeButton).click();
	}

	public boolean isUserErrorMessageDisplayed() {
		return driver.findElement(userErrorMessage).isDisplayed();
	}
	
	public boolean isAssetClassErrorMessageDisplayed() {
		return driver.findElement(assetClassErrorMessage).isDisplayed();
	}

	public boolean isSuccessMessageDisplayed() {
		return driver.findElement(successMessage).isDisplayed();
	}

	public boolean isPopupClosed() {
		return driver.findElements(usersDropdown).isEmpty();
	}
	
}
