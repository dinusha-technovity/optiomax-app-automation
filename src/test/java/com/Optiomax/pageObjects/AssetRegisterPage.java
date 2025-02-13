package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssetRegisterPage {

    private WebDriver driver;
    
    String filePath = "";

    public AssetRegisterPage (WebDriver driver) {
        this.driver = driver;
    }
    
    private By emailField = By.xpath("");
    private By passwordField = By.xpath("");
    private By rememberMeCheckbox = By.xpath("");
    private By signInButton = By.xpath("");
    
    private By assetRecordRegister = By.xpath("");
    private By assetNameField = By.xpath("//input[@placeholder='Enter Asset Name']");
    private By assetTypeDropdown = By.xpath("//input[@placeholder='Search and Select Asset Type']");
    private By assetCategoryDropdown = By.xpath("//input[@placeholder='Search and Select Asset Category']");
    private By assetSubCategoryDropdown = By.xpath("//input[@placeholder='Search and Select Asset Sub Category']");
    private By assetValueField = By.xpath("//input[@placeholder='Enter Asset Value']");
    private By averageLifeTimeField = By.xpath("//input[@placeholder='Enter Expected Average Life Time']");
    private By uploadImageSection = By.xpath("//div[@class='flex flex-col items-center justify-center pt-5 pb-6']");
    private By addNewBtn = By.xpath("//button[normalize-space()='Add New']");
    private By detailtypeField = By.xpath("//input[@placeholder='Enter detail type']");
    private By detailsField = By.xpath("//input[@placeholder='Enter details']");
    private By saveBtn = By.xpath("//button[@type='button'][.='Save'] ");
    private By updateBtn = By.xpath("//button[@type='button'][.='Edit']");
    private By deleteBtn = By.xpath("//button[@type='button'][.='Delete']");
    private By assetDescriptionTextarea = By.xpath("//textarea[@id='role_description']");
    private By submitBtn = By.xpath("//button[normalize-space()='Submit']");
    
    //private By assetTypeOptionTemplate = By.xpath("//textarea[@id='role_description'][@id='role_description']");
    //private By assetCategoryOptionTemplate = By.xpath("");
    //private By assetSubCategoryOptionTemplete = By.xpath("");
    
//    private By assetTypeDropdown = By.xpath("//input[@placeholder='Search and Select Asset Type']");
//    private By dropdownOptionTemplate = By.xpath("//div[contains(@class, 'option') and text()='%s']");   
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    public void clickAssetRecordRegister() {
    	driver.findElement(assetRecordRegister).click();
    }
    
    public void enterAssetName(String assetName) {
    	driver.findElement(assetNameField).sendKeys(assetName);
    }
    
    public void selectAssetType(String assetType) {
        driver.findElement(assetTypeDropdown).click(); 
        String optionXpath = String.format("//div[text()='%s']", assetType); 
        driver.findElement(By.xpath(optionXpath)).click();
    }

    // Method to get the selected asset type
    public String getSelectedAssetType() {
        return driver.findElement(assetTypeDropdown).getAttribute("value");
    }
    
    public void selectAssetCategory(String assetCategory) {
    	driver.findElement(assetCategoryDropdown).click();
    	String categoryOptionXpath = String.format("//div[text()='%s']", assetCategory);
    	driver.findElement(By.xpath(categoryOptionXpath)).click();
    }
    
    public String getSelectedCategoryType() {
    	return driver.findElement(assetCategoryDropdown).getAttribute("value");
    }

    public void selectAssetSubCategory(String assetSubCategory) {
    	driver.findElement(assetSubCategoryDropdown).click();
    	String categoryOptionXpath = String.format("//div[text()='%s']", assetSubCategory);
    	driver.findElement(By.xpath(categoryOptionXpath)).click();
    }
    
    public String getSelectedSubCategoryType() {
    	return driver.findElement(assetSubCategoryDropdown).getAttribute("value");
    }
    
    public void enterAssetValue(String assetValue) {
    	driver.findElement(assetValueField).sendKeys(assetValue);
    }
    
    public void eneterAverageLifeTime(String averageLifeTime) {
    	driver.findElement(averageLifeTimeField).sendKeys(averageLifeTime);
    }
    
    public void uploadImage(String filePath) {
        WebElement uploadElement = driver.findElement(uploadImageSection);
        uploadElement.sendKeys(filePath);
    }
    
    public void enterDetailType(String detailtype) {
    	driver.findElement(detailtypeField).sendKeys(detailtype);
    }
    
    public void enterDetails(String details) {
    	driver.findElement(detailsField).sendKeys(details);
    }
    
    public void clickAddNew() {
    	driver.findElement(addNewBtn).click();
    }
    
    public void clickSave() {
    	driver.findElement(saveBtn).click();
    }
    
    public void clickUpdate() {
    	driver.findElement(updateBtn).click();
    }
    
    public void clickDelete() {
    	driver.findElement(deleteBtn).click();
    }
    
    public void enterAssetDescription(String description) {
    	driver.findElement(assetDescriptionTextarea).sendKeys(description);
    }
    
    public void clickSubmit() {
    	driver.findElement(submitBtn).click();
    }
    
}   

