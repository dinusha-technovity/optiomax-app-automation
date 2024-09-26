package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewSupplierIndividualPage extends BasePage {

	public AddNewSupplierIndividualPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
	private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
	private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
	private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

	private By addNewSupplierButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/button");
	private By individualToggle = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[3]/form/div[1]/div/div/div/div/div/div/label[2]");
	private By nameField = By.xpath("//input[@id='name']");
	private By addressField = By.xpath("//input[@id='address']");
	//private By assetClassDropdown = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[3]/form/div[2]/div[3]/div[1]/div/div/div/div/div/div/div/div");							
	private By clickAssetClass = By.xpath("//div[@class='ant-select-selector']");
	private By selectAssetClass = By.xpath("//div[contains(text(),'Tangible assets')]");
	private By clickAssetClass2 = By.xpath("");
	private By selectAssetClass2 = By.xpath("");
	private By supplierRating = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[3]/form/div[2]/div[3]/div[2]/div/div/div/div/div/ul/li[2]/div/div[2]/span");
	private By contactNoField = By.xpath("//input[@id='contact_no 1']");
	private By addContactNo = By.xpath("//span[@aria-label='plus']//*[name()='svg']");
	private By loginUsername = By.xpath("//input[@id='supplier_username']");
	private By loginemail = By.xpath("//input[@id='supplier_email']");
	private By submitButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[3]/form/div[4]/div/div/div/div/button");
	//private By emptySubmit = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[3]/form/div[5]/div/div/div/div/button");
	private By closeButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[1]/a");
	
	//private By selectWorkflow = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[3]/div[2]/button");
	private By workflowClick = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[1]/div/div/div[1]/div[2]");
	private By workflowSelect = By.xpath("//div[@class=' css-19bb58m']");
	private By workflowSubmit = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/button");
	private By reason = By.xpath("//*[@id=\"comment\"]");
	private By reject = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/div[4]/div/button[1]");
	private By approve = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/div[4]/div/button[2]");

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

//	public void selectAssetClass(String assetClass) {
//		Select assetSelect = new Select(driver.findElement(assetClassDropdown));
//		assetSelect.selectByVisibleText(assetClass);
//	}
	
    public void clickAssetClasses() {
    	driver.findElement(clickAssetClass).click();
    }
    
    public void selectAssetClasses() {
    	driver.findElement(selectAssetClass).click();
    }
    
    public void clickNewAssetClasses() {
    	driver.findElement(clickAssetClass2).click();
    }
    
    public void selectNewAssetClasses() {
    	driver.findElement(selectAssetClass2).click();
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
	
//	public void selectWorkflow(String workflow) {
//	Select assignWorkflow = new Select(driver.findElement(selectWorkflow));
//	assignWorkflow.selectByVisibleText(workflow);
//	}
	
    public void clickWorkflow() {
    	driver.findElement(workflowClick).click();
    }
    
    public void selectWorkflow() {
    	driver.findElement(workflowSelect).click();
    }
	
	public void submitWorkflow() {
		driver.findElement(workflowSubmit).click();
	}
	
	public void enterReason(String reasons) {
		driver.findElement(reason).sendKeys(reasons);
	}	
	
	public void clickReject() {
		driver.findElement(reject).click();
	}
	
	public void clickApprove() {
		driver.findElement(approve).click();
	}
	
//	public void SubmitEmpty() {
//		driver.findElement(emptySubmit).click();
//	}
}
