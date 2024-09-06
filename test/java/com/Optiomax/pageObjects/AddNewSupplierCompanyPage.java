package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddNewSupplierCompanyPage extends BasePage {
	private WebDriver driver;

	public AddNewSupplierCompanyPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
	private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
	private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
	private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

	private By addNewSupplierButton = By.xpath("");
	private By companyToggle = By.xpath("");
	private By nameField = By.xpath("");
	private By addressField = By.xpath("");
	private By assetClassDropdown = By.xpath("");
	private By supplierRating = By.xpath("");
	private By contactNoField = By.xpath("");
	private By addContactNo = By.xpath("");
	private By businessNameField = By.xpath("");
	private By businessRegistrationField = By.xpath("");
	private By primaryEmailField = By.xpath("");
	private By secondaryEmailField = By.xpath("");
	private By brAttachmentUpload = By.xpath("");
	private By websiteField = By.xpath("");
	private By telephoneField = By.xpath("");
	private By mobileField = By.xpath("");
	private By faxField = By.xpath("");
	private By cityField = By.xpath("");
	private By latitudeField = By.xpath("");
	private By longitudeField = By.xpath("");
	private By loginUsername = By.xpath("");
	private By loginemail = By.xpath("");
	private By submitButton = By.xpath("");

	public void login(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(rememberMeCheckbox).click();
		driver.findElement(signInButton).click();
	}

	public void clickAddNewSupplierButton() {
		driver.findElement(addNewSupplierButton).click();
	}

	public void selectCompanyToggle() {
		driver.findElement(companyToggle).click();
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

	public void enterBusinessName(String businessName) {
		driver.findElement(businessNameField).sendKeys(businessName);
	}

	public void enterBusinessRegistration(String businessRegistration) {
		driver.findElement(businessRegistrationField).sendKeys(businessRegistration);
	}

	public void enterPrimaryEmail(String primaryEmail) {
		driver.findElement(primaryEmailField).sendKeys(primaryEmail);
	}

	public void enterSecondaryEmail(String secondaryEmail) {
		driver.findElement(secondaryEmailField).sendKeys(secondaryEmail);
	}

	public void uploadBRAttachment(String filePath) {
		driver.findElement(brAttachmentUpload).sendKeys(filePath);
	}

	public void enterWebsite(String website) {
		driver.findElement(websiteField).sendKeys(website);
	}

	public void enterTelephone(String telephone) {
		driver.findElement(telephoneField).sendKeys(telephone);
	}

	public void enterMobile(String mobile) {
		driver.findElement(mobileField).sendKeys(mobile);
	}

	public void enterFax(String fax) {
		driver.findElement(faxField).sendKeys(fax);
	}

	public void enterCity(String city) {
		driver.findElement(cityField).sendKeys(city);
	}

	public void enterLatitude(String latitude) {
		driver.findElement(latitudeField).sendKeys(latitude);
	}

	public void enterLongitude(String longitude) {
		driver.findElement(longitudeField).sendKeys(longitude);
	}

	public void enterLoginUsername(String username) {
		driver.findElement(loginUsername).sendKeys(username);
	}

	public void enterLoginEmail(String email) {
		driver.findElement(loginemail).sendKeys(email);
	}

	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}

}
