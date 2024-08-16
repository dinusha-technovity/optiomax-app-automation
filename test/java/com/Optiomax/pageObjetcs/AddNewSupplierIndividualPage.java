package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddNewSupplierIndividualPage extends BasePage {

	public AddNewSupplierIndividualPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
	private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
	private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
	private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

	private By addNewSupplierButton = By.xpath("");
	private By individualToggle = By.xpath("");
	private By nameField = By.xpath("");
	private By addressField = By.xpath("");
	private By assetClassDropdown = By.xpath("");
	private By supplierRating = By.xpath("");
	private By contactNoField = By.xpath("");
	private By addContactNo = By.xpath("");
	private By loginUsername = By.xpath("");
	private By loginemail = By.xpath("");
	private By submitButton = By.xpath("");
	private By closeButton = By.xpath("");

	public void login(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(rememberMeCheckbox).click();
		driver.findElement(signInButton).click();
	}

	public void clickAddNewSupplierButton() {
		driver.findElement(addNewSupplierButton).click();
	}

	public void selectIndividualToggle() {
		driver.findElement(individualToggle).click();
	}

	public void enterName(String name) {
		driver.findElement(nameField).sendKeys(name);
	}

	public void enterAddress(String address) {
		driver.findElement(addressField).sendKeys(address);
	}

	public void selectAssetClass(String assetClass) {
		Select assetSelect = new Select(driver.findElement(assetClassDropdown));
		assetSelect.selectByVisibleText(assetClass);
	}

	public void addSupplierRatings() {
		driver.findElement(supplierRating).click();
	}

	public void enterContactNo(String contactNo) {
		driver.findElement(contactNoField).sendKeys(contactNo);
	}

	public void addContactNo() {
		driver.findElement(addContactNo).click();
	}

	public void enterLoginUsername(String username) {
		driver.findElement(loginUsername).sendKeys(username);
	}

	public void enterLoginEmail(String email) {
		driver.findElement(loginemail).sendKeys(email);
	}

	public void submitForm() {
		driver.findElement(submitButton).click();
	}

	public void closeForm() {
		driver.findElement(closeButton).click();
	}

	public String getEmailErrorMessage() {
		return driver.findElement(By.xpath("")).getText();
	}

	public String getRequiredFieldErrorMessage(String fieldName) {
		return driver.findElement(By.id(fieldName + "Error")).getText();
	}

}
