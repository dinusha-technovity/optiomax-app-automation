package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddNewAssetRequisitionPage {
    private WebDriver driver;

    public AddNewAssetRequisitionPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    private By addAssetRequisition = By.xpath("//button[normalize-space()='Add new Asset Requisition']");
    private By itemName = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[1]/div[1]/input");
    private By assetType = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[1]/div[2]/select");
    private By quantity = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[1]/div[3]/input");
    private By budget = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[1]/div[4]/input");
    private By businessPurpose = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[1]/div[5]/input");
    private By upgradeExisting = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[1]/div[6]/ul/li[1]/div/input");
    private By purchaseNew = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[1]/div[6]/ul/li[2]/div/input");
    private By periodTerm = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[2]/div/select");
    private By availabilityType = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[3]/div[1]/select");
    private By priority = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[3]/div[2]/select");
    private By requiredDate = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[3]/div[3]/input");
    private By organizationStructure = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[3]/div[4]/a");
    private By reasonForRequisition = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[3]/div[5]/textarea");
    private By businessImpact = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[3]/div[6]/textarea");
    private By attachment = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[3]/div[7]/input");
    private By suppliers = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[3]/div[8]/button");
    private By detailType = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[4]/div/div/input[1]");
    private By itemDetails = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[4]/div/div/input[2]");
    private By moreItemDetails = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[4]/div/a");
    private By closeItemDetails = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[4]/div/div/div/a");
    private By maintenanceKPI = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[5]/div/div/input");
    private By moreMaintenanceKPI = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[5]/div/a");
    private By closeMaintenanceKPI = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[5]/div/div/div/a");
    private By serviceSupportKPI = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[6]/div/div/input");
    private By moreServiceSupportKPI = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[6]/div/a");
    private By closeServiceSupportKPI = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[6]/div/div/div/a");
    private By consumablesKPI = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[7]/div/div/input");
    private By moreConsumablesKPI = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[7]/div/a");
    private By closeConsumablesKPI = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[7]/div/div/div/a");
    private By addItemButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[8]/a");
    private By saveButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[3]/button[1]");
    private By submitButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[3]/button[2]");
    //private By saveChanges = By.xpath("");
    //private By confirmationMessage = By.xpath("");
    private By selectOrganization = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[3]/div[4]/div/div/div/div/div/div/div/ul/li/ul/li[1]/div/div[1]/input");
    private By selectSupplier = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[3]/div[8]/div[2]/div/ul/li[1]/div/input");
    private By closeAssetRequistionForm = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[1]/a");   
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }
    
    public void addAssetRequisition() {
    	driver.findElement(addAssetRequisition).click();
    }

    public void enterItemName(String item) {
        driver.findElement(itemName).sendKeys(item);
    }

    public void selectAssetType(String type) {
        Select assetDropdown = new Select(driver.findElement(assetType));
        assetDropdown.selectByVisibleText(type);
    }

    public void enterQuantity(String qty) {
        driver.findElement(quantity).sendKeys(qty);
    }

    public void enterBudget(String amount) {
        driver.findElement(budget).sendKeys(amount);
    }

    public void enterBusinessPurpose(String purpose) {
        driver.findElement(businessPurpose).sendKeys(purpose);
    }

    public void chooseUpgradeExisting() {
        driver.findElement(upgradeExisting).click();
    }

    public void choosePurchaseNew() {
        driver.findElement(purchaseNew).click();
    }
    
    public void selectPeriodTerm(String period) {
        Select periodDropdown = new Select(driver.findElement(periodTerm));
        periodDropdown.selectByVisibleText(period);
    }

    public void selectAvailabilityType(String availability) {
        Select availabilityDropdown = new Select(driver.findElement(availabilityType));
        availabilityDropdown.selectByVisibleText(availability);
    }
    
    public void selectPriority(String priorityLevel) {
        Select priorityDropdown = new Select(driver.findElement(priority));
        priorityDropdown.selectByVisibleText(priorityLevel);
    }

    public void enterRequiredDate(String date) {
        driver.findElement(requiredDate).sendKeys(date);
    }
    
    public void clickOrganization() {
    	driver.findElement(organizationStructure).click();
    }
    
    public void selectOrganization() {
    	driver.findElement(selectOrganization).click();
    }
    
//  public void selectOrganizationStructure(String structure) {
//  Select organizationDropdown = new Select(driver.findElement(organizationStructure));
//  organizationDropdown.selectByVisibleText(structure);
//  }

    public void enterReasonForRequisition(String reason) {
        driver.findElement(reasonForRequisition).sendKeys(reason);
    }
    
    public void enterBusinessImpact(String impact) {
        driver.findElement(businessImpact).sendKeys(impact);
    }
    
    public void attachFile(String filePath) {
        driver.findElement(attachment).sendKeys(filePath);
    }

    public void clickSuppliers() {
    	driver.findElement(suppliers).click();
    }
    
    public void selectSupplier() {
    	driver.findElement(selectSupplier).click();
    }
    
    public void enterDetailType(String type) {
    	driver.findElement(detailType).sendKeys(type);
    }
    
    public void enterItemDetails(String items) {
    	driver.findElement(itemDetails).sendKeys(items);
    }
    
    public void clickMoreItemDetails() {
    	driver.findElement(moreItemDetails).click();
    }

    public void closeItemDetails() {
    	driver.findElement(closeItemDetails).click();
    }
    
    public void enterMaintenanceKPI(String maintennance) {
    	driver.findElement(maintenanceKPI).sendKeys(maintennance);
    }
    
    public void moreMaintenanceKPI() {
    	driver.findElement(moreMaintenanceKPI).click();
    }
    
    public void closeMaintenanceKPI() {
    	driver.findElement(closeMaintenanceKPI).click();
    }
    
    public void enterServiceSupportKPI(String serviceSupport) {
    	driver.findElement(serviceSupportKPI).sendKeys(serviceSupport);
    }
    
    public void moreServiceSupportKPI() {
    	driver.findElement(moreServiceSupportKPI).click();
    }
    
    public void closeServiceSupportKPI() {
    	driver.findElement(closeServiceSupportKPI).click();
    }
    
    public void enterconsumablesKPI(String consumables) {
    	driver.findElement(consumablesKPI).sendKeys(consumables);
    }
    
    public void moreConsumablesKPI() {
    	driver.findElement(moreConsumablesKPI).click();
    }
    
    public void closeConsumablesKPI() {
    	driver.findElement(closeConsumablesKPI).click();
    }
    
    public void clickAddItem() {
        driver.findElement(addItemButton).click();
    }
    
    public void clickSave() {
    	driver.findElement(saveButton).click();
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }
    
    public void closeAssetRequistionForm() {
    	driver.findElement(closeAssetRequistionForm).click();
    }
    
//    public void saveChanges() {
//    	driver.findElement(saveChanges).click();
//    }
//
//    public String getConfirmationMessage() {
//        return driver.findElement(confirmationMessage).getText();
//    }

    public WebElement getTopItem() {
        return driver.findElement(By.cssSelector(""));
    }

    public void updateTopItem(String newName) {
        WebElement updateIcon = driver.findElement(By.cssSelector(""));
        updateIcon.click();
        WebElement itemNameField = driver.findElement(By.cssSelector(""));
        itemNameField.clear();
        itemNameField.sendKeys(newName);
        driver.findElement(By.cssSelector("")).click();
    }

    public void deleteTopItem() {
        WebElement deleteIcon = driver.findElement(By.cssSelector(""));
        deleteIcon.click();
    }
     
}

