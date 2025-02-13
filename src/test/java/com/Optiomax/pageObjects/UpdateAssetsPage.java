package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateAssetsPage {
	
	private WebDriver driver;
	
    public UpdateAssetsPage (WebDriver driver) {
        this.driver = driver;
    }
    
    private By emailField = By.xpath("");
    private By passwordField = By.xpath("");
    private By rememberMeCheckbox = By.xpath("");
    private By signInButton = By.xpath("");
    
    private By updateIcon = By.xpath("");
    private By assetNameField = By.xpath("//input[@placeholder='Enter Asset Name']");
    private By assetTypeDropdown = By.xpath("//input[@placeholder='Search and Select Asset Type']");
    private By assetCategoryDropdown = By.xpath("//input[@placeholder='Search and Select Asset Category']");
    private By assetSubCategoryDropdown = By.xpath("//input[@placeholder='Search and Select Asset Sub Category']");
    private By assetValueField = By.xpath("//input[@placeholder='Enter Asset Value']");
    private By averageLifeTimeField = By.xpath("//input[@placeholder='Enter Expected Average Life Time']");
    //private By uploadImageSection = By.xpath("//div[@class='flex flex-col items-center justify-center pt-5 pb-6']");
    //private By addNewBtn = By.xpath("//button[normalize-space()='Add New']");
    private By detailtypeField = By.xpath("//input[@placeholder='Enter detail type']");
    private By detailsField = By.xpath("//input[@placeholder='Enter details']");
    private By addIcon = By.xpath("");
    //private By saveBtn = By.xpath("//button[@type='button'][.='Save'] ");
    //private By updateBtn = By.xpath("//button[@type='button'][.='Edit']");
    //private By deleteBtn = By.xpath("//button[@type='button'][.='Delete']"); 
    //private By fake = By.xpath("//input[@placeholder='Search and Select Asset Category'][last()]");
    private By assetDescriptionTextarea = By.xpath("//textarea[@id='role_description']");
    private By clickUpdateBtn = By.xpath("//label[normalize-space()='Tangible assets'][contains(.,'Tangible assets')]");
    private By closeImage = By.xpath("");
    private By cancelImage = By.xpath("");
    
    public void login(String email, String password) {
    	driver.findElement(emailField).sendKeys(email);
    	driver.findElement(passwordField).sendKeys(password);
    	driver.findElement(rememberMeCheckbox).click();
    	driver.findElement(signInButton).click();
    }
    
    public void clickUpdateIcon() {
    	driver.findElement(updateIcon).click();
    }
   
    public void setAssetName(String assetName) {
    	driver.findElement(assetNameField).clear();
    	driver.findElement(assetNameField).sendKeys(assetName);
    }
    
    public void setAssetType(String assetType) {
    	driver.findElement(assetTypeDropdown).clear();
    	driver.findElement(assetTypeDropdown).sendKeys(assetType);
    }
    
    public void setAssetCategory(String assetCategory) {
    	driver.findElement(assetCategoryDropdown).clear();
    	driver.findElement(assetCategoryDropdown).sendKeys(assetCategory);
    }
    
    public void setAssetSubCategory(String assetSubCategory) {
    	driver.findElement(assetSubCategoryDropdown).clear();
    	driver.findElement(assetSubCategoryDropdown).sendKeys(assetSubCategory);
    }
    
    public void setAssetValue(String assetValue) {
    	driver.findElement(assetValueField).clear();
    	driver.findElement(assetValueField).sendKeys(assetValue);
    }
    
    public void setAverageLifeTime(String averageLifeTime) {
    	driver.findElement(averageLifeTimeField).clear();
    	driver.findElement(averageLifeTimeField).sendKeys(averageLifeTime);
    }
    
    
    public void setImage() {
    	driver.findElement(closeImage).click();
    	driver.findElement(cancelImage).click();
    }
    
    public void setDetailsType(String detailType) {
    	driver.findElement(detailtypeField).clear();
    	driver.findElement(detailtypeField).sendKeys(detailType);
    }
    
    public void setDetails(String details) {
    	driver.findElement(detailsField).clear();
    	driver.findElement(detailsField).sendKeys(details);
    }
    
    public void addDetailsType(String detailType) {
    	driver.findElement(addIcon).click();
    	driver.findElement(detailtypeField).sendKeys(detailType);
    }
    
    public void addDetails(String details) {
    	driver.findElement(addIcon).click();
    	driver.findElement(detailsField).sendKeys(details);
    }
    
    public void setDescription(String description) {
    	driver.findElement(assetDescriptionTextarea).clear();
    	driver.findElement(assetDescriptionTextarea).sendKeys(description);
    }
    
    public void clickUpdate() {
    	driver.findElement(clickUpdateBtn).click();
    }
    
    public void selectAssetType(String assetType) {
        driver.findElement(assetTypeDropdown).click(); 
        String optionXpath = String.format("//div[text()='%s']", assetType); 
        driver.findElement(By.xpath(optionXpath)).click();
    }
    
    public String getSelectedAssetType() {
    	return driver.findElement(assetTypeDropdown).getAttribute("value");
    }
    
    public String getSelectedAssetCategory() {
    	return driver.findElement(assetCategoryDropdown).getAttribute("Value");
    }
    

}
