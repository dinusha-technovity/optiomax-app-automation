package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class AddNewSupplierCompanyPage extends BasePage {
	private WebDriver driver;

	public AddNewSupplierCompanyPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
	private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
	private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
	private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

	private By addNewSupplierButton = By.xpath("//button[normalize-space()='Add New Supplier']");
	private By companyToggle = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[3]/form/div[1]/div/div/div/div/div/div/label[1]");
	private By nameField = By.xpath("//input[@id='name']");
	private By addressField = By.xpath("//input[@id='address']");
	private By assetClassDropdown = By.xpath("//div[@class='ant-select-selection-overflow']");
	private By supplierRating = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[3]/form/div[2]/div[3]/div[2]/div/div/div/div/div/ul/li[4]/div/div[1]/span");
	private By contactNoField = By.xpath("//input[@id='contact_no 1']");
	private By addContactNo = By.xpath("//span[@aria-label='plus']");
	private By businessNameField = By.xpath("//input[@id='business_name']");
	private By businessRegistrationField = By.xpath("//input[@id='business_registration']");
	private By primaryEmailField = By.xpath("//input[@id='primary_email']");
	private By secondaryEmailField = By.xpath("//input[@id='secondary_email']");
	private By brAttachmentUpload = By.xpath("//span[@aria-label='upload']");
	private By websiteField = By.xpath("//input[@id='website']");
	private By telephoneField = By.xpath("//input[@id='tel_no']");
	private By mobileField = By.xpath("//input[@id='mobile']");
	private By faxField = By.xpath("//input[@id='fax']");
	private By cityField = By.xpath("//input[@id='city']");
	private By latitudeField = By.xpath("");   // Add Latitude 
	private By longitudeField = By.xpath("");  // Add Longitude
	private By loginUsername = By.xpath("//input[@id='supplier_username']");
	private By loginemail = By.xpath("//input[@id='supplier_email']");
	private By submitButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[3]/form/div[5]/div/div/div/div/button");

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
	
	public void clickUsername() {
		driver.findElement(loginUsername).click();
	}
	
    public void scrollToElementAndClick() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        ((WebElement) submitButton).click();
    }

}
