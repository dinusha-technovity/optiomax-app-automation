package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UpdateAssetManagementPage {
  
	private WebDriver driver;

    public UpdateAssetManagementPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");
    
    private By assetRecordUpdateIcon = By.xpath("");
    private By assetModelNumber = By.xpath("//input[@placeholder='Enter Model Number']");
    private By assetSerialNumber = By.xpath("//input[@placeholder='Enter Serial Number']");
    private By responsiblePerson = By.xpath("//input[@placeholder='Search and Select Responsible Person']");
    private By storedLocation = By.xpath("//input[@placeholder='Enter Stored Location']");
    private By organizationStructure = By.xpath("//a[@id='dropdownSearchButton']");
    private By department = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/form/div[5]/div/div[2]/div[2]/div/div/div/div/div/div/div/ul/li/div/div/input");
    private By assetType = By.xpath("//input[@placeholder='Search and Select Assets Type']");
    private By assetValue = By.xpath("//input[@placeholder='Enter Assest Value']");
    private By assetCategory = By.xpath("//input[@placeholder='Search and Select Asset Category']");
    private By assetSubCategory = By.xpath("//input[@placeholder='Search and Select Asset Sub Category']");
    private By supplier = By.xpath("//div[@class='col-span-3 grid gap-6 md:grid-cols-2']//div//input[@placeholder='Search and Select Supplier']");
    private By purchaseOrderNumber = By.xpath("//input[@name='purchaseOrderNumbe']");
    private By purchaseCost = By.xpath("//input[@placeholder='Enter Purchase Cost']");
    private By purchaseType = By.xpath("//div[@class='col-span-2']//input[@placeholder='Search and Select Supplier']");
    private By receivedConditionBrandNew = By.xpath("//input[@id='horizontal-list-radio-license']");
    private By receivedConditionUsed = By.xpath("//input[@id='horizontal-list-radio-passport']");
    private By assetWarranty = By.xpath("//input[@placeholder='Enter warranty (if have)']");
    private By purchaseDetails = By.xpath("//textarea[@id='user_description']");
    private By insuranceNumber = By.xpath("//input[@placeholder='Enter Insurance Number']");
    private By expectedLifeTime = By.xpath("//input[@name='expectedLifeTime']");
    private By estimatedDepreciationValue = By.xpath("//input[@placeholder='Enter Estimated Depreciation Value ex:50%']");
    private By space = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/form/div[5]/div/div[2]/div[2]/label");
    private By assetsImages = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/form/div[1]/div[2]/label[2]");
    private By assetsRelatedDocument = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/form/div[2]/div[1]/label[2]");
    private By assetPurchaseDocument = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/form/div[3]/div[3]/label[2]");
    private By isuranceRelatedDocument = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/form/div[4]/div[4]/label[2]");
    private By updateBtn = By.xpath("");
    
    private By assetTypeOption1 = By.xpath("//label[normalize-space()='Tangible assets']");
    private By assetTypeOption2 = By.xpath("//label[normalize-space()='Fixed assets']");
    
    private By assetCategoryOption1 = By.xpath("//label[normalize-space()='Computer & Hardware']");
    private By assetCategoryOption2 = By.xpath("//label[normalize-space()='Electronic']");
    
    private By assetSubCategoryOption1 = By.xpath("//label[normalize-space()='Laptop']");
    private By assetSubCategoryOption2 = By.xpath("//label[normalize-space()='Ac Machine']");
    
    private By supplierOption1 = By.xpath("//label[normalize-space()='Acme Corporation']");
    private By supplierOption2 = By.xpath("//label[normalize-space()='Globex Corporation']");
    
    private By purchaseTypeOption1 = By.xpath("//label[normalize-space()='Hire']");
    private By purchaseTypeOption2 = By.xpath("//label[normalize-space()='Rent']");
    
    private By responsiblePersonOption1 = By.xpath("//label[normalize-space()='James Nelson']");
    private By responsiblePersonOption2 = By.xpath("//label[normalize-space()='Charles Brown']");
   
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }
    
    public void clickUpdateIcon() {
    	driver.findElement(assetRecordUpdateIcon).click();
    }
    
    public void selectAssetTypeSelection1() {
    	driver.findElement(assetType).click();
    	driver.findElement(assetTypeOption1).click();
    }
    
    public void selectAssetTypeSelection2() {
    	driver.findElement(assetType).click();
    	driver.findElement(assetTypeOption2).click();
    }
    
    public void enterAssetValue(String value) {
    	driver.findElement(assetValue).sendKeys(value);
    }
    
    public void selectAssetCategorySelection1() {
    	driver.findElement(assetCategory).click();
    	driver.findElement(assetCategoryOption1).click();
    }
    
    public void selectAssetCategorySelection2() {
    	driver.findElement(assetCategory).click();
    	driver.findElement(assetCategoryOption2).click();
    }
    
    public void selectAssetSubCategorySelection1() {
    	driver.findElement(assetSubCategory).click();
    	driver.findElement(assetSubCategoryOption1).click();
    }
    
    public void selectAssetSubCategorySelection2() {
    	driver.findElement(assetSubCategory).click();
    	driver.findElement(assetSubCategoryOption2).click();
    }
    
    public void selectSupplierSelection1() {
    	driver.findElement(supplier).click();
    	driver.findElement(supplierOption1).click();
    }
    
    public void selectSupplierSelection2() {
    	driver.findElement(supplier).click();
    	driver.findElement(supplierOption2).click();
    }
    
    public void enterPurchaseOrderNumber(String orderNumber) {
    	driver.findElement(purchaseOrderNumber).sendKeys(orderNumber);
    }
    
    public void attachAssetImage(String uploadAssetImage) {
    	driver.findElement(assetsImages).sendKeys(uploadAssetImage);
    }
    
    public void attachAssetsRelatedDocument(String uploadAssetsRelatedDocument) {
    	driver.findElement(assetsRelatedDocument).sendKeys(uploadAssetsRelatedDocument);
    }
    
    public void enterPurchaseCost(String cost) {
    	driver.findElement(purchaseCost).sendKeys(cost);
    }
    
    public void selectPurchaseTypeSelection1() {
    	driver.findElement(purchaseType).click();
    	driver.findElement(purchaseTypeOption1).click();
    }
    
    public void selectPurchaseTypeSelection2() {
    	driver.findElement(purchaseType).click();
    	driver.findElement(purchaseTypeOption2).click();
    }
    
    public void clickReceivedConditionBrandNew() {
    	driver.findElement(receivedConditionBrandNew).click();
    }
    
    public void clickReceivedConditionUsed() {
    	driver.findElement(receivedConditionUsed).click();
    }
    
    public void enterWarranty(String warranty) {
    	driver.findElement(assetWarranty).sendKeys(warranty);
    }

    public void enterPurchaseDetails(String details) {
    	driver.findElement(purchaseDetails).sendKeys(details);
    }
    
    public void attachPurchaseDocument(String uploadPurchaseDocument) {
    	driver.findElement(assetPurchaseDocument).sendKeys(uploadPurchaseDocument);
    }
    
    public void enterInsuranceNumber(String assetIsuranceNumber) {
    	driver.findElement(insuranceNumber).sendKeys(assetIsuranceNumber);
    }
    
    public void enterExpectedLifeTime(String lifeTime) {
    	driver.findElement(expectedLifeTime).sendKeys(lifeTime);
    }
    
    public void enterEstimatedDepreciationValue(String depreciationValue) {
    	driver.findElement(estimatedDepreciationValue).sendKeys(depreciationValue);
    }
    
    public void attachInsuranceRelatedDocuments(String insuranceDocument) {
    	driver.findElement(isuranceRelatedDocument).sendKeys(insuranceDocument);
    }
    
    public void enterAssetModelNumber(String modelNumber) {
    	driver.findElement(assetModelNumber).sendKeys(modelNumber);
    }
    
    public void enterSerialNumber(String serialNumber) {
    	driver.findElement(assetSerialNumber).sendKeys(serialNumber);
    }
    
    public void selectResponsiblePersonSelection1() {
    	driver.findElement(responsiblePerson).click();
    	driver.findElement(responsiblePersonOption1).click();
    }
    
    public void selectResponsiblePersonSelection2() {
    	driver.findElement(responsiblePerson).click();
    	driver.findElement(responsiblePersonOption2).click();
    }
    
    public void enterStoredLocation(String location) {
    	driver.findElement(storedLocation).sendKeys(location);
    }
    
    public void clickOrganizationStructure() {
    	driver.findElement(organizationStructure).click();
    }
    
    public void selectDepartment() {
    	driver.findElement(department).click();
    }
    
    public void clickSpace() {
    	driver.findElement(space).click();
    }
       
}
