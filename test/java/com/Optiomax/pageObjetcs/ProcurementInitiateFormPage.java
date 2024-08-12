package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProcurementInitiateFormPage {

    private WebDriver driver;

    private By formHeader = By.xpath("//h3[normalize-space()='Add New Procurement Initiate']");
    private By procurementInitiateNumber = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[3]/form/div[1]/div[1]/span");
    private By requisitionSearch = By.id("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[3]/form/div[2]/div/div/div[1]/div/input");
    private By assessRequests = By.xpath("");
    //private By selectedItems = By.xpath("");
    private By quantity = By.xpath("");
    private By budget = By.xpath("");
    private By removeItem = By.xpath("");
    private By uploadFiles = By.xpath("");
    private By attachmentRFP = By.xpath("");
    private By requiredDate = By.xpath("");
    private By comment = By.xpath("");
    private By submit = By.xpath("");

    public ProcurementInitiateFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isFormDisplayed() {
        return driver.findElement(formHeader).isDisplayed();
    }

    public String getProcurementInitiateNumber() {
        return driver.findElement(procurementInitiateNumber).getText();
    }

    public void searchRequisition(String requisitionId) {
        driver.findElement(requisitionSearch).sendKeys(requisitionId);
    }

    public void selectRequisition(String requisitionId) {
        WebElement requisition = driver.findElement(By.xpath("//div[@class='assess-requests']//div[@class='request'][text()='" + requisitionId + "']"));
        requisition.click();
    }

    public void addItemToSelected() {
        driver.findElement(assessRequests).click();
    }

    public void editQuantity(String qty) {
        WebElement qtyElement = driver.findElement(quantity);
        qtyElement.clear();
        qtyElement.sendKeys(qty);
    }

    public void editBudget(String budgetAmount) {
        WebElement budgetElement = driver.findElement(budget);
        budgetElement.clear();
        budgetElement.sendKeys(budgetAmount);
    }

    public void removeSelectedItem() {
        driver.findElement(removeItem).click();
    }

    public void uploadFile(String filePath) {
        driver.findElement(uploadFiles).sendKeys(filePath);
    }

    public void uploadRFP(String filePath) {
        driver.findElement(attachmentRFP).sendKeys(filePath);
    }

    public void selectRequiredDate(String date) {
        driver.findElement(requiredDate).sendKeys(date);
    }

    public void enterComment(String commentText) {
        driver.findElement(comment).sendKeys(commentText);
    }

    public void submitForm() {
        driver.findElement(submit).click();
    }

    public boolean isRequisitionFound(String requisitionId) {
        WebElement requisition = driver.findElement(By.xpath("//div[@class='assess-requests']//div[@class='request'][text()='" + requisitionId + "']"));
        return requisition.isDisplayed();
    }

    public boolean isItemSelected(String itemId) {
        WebElement item = driver.findElement(By.xpath("//div[@class='selected-items']//div[@class='item'][text()='" + itemId + "']"));
        return item.isDisplayed();
    }

    public String getQuantity() {
        return driver.findElement(quantity).getAttribute("value");
    }

    public String getBudget() {
        return driver.findElement(budget).getAttribute("value");
    }

    public boolean isFileUploaded(String fileName) {
        WebElement uploadedFile = driver.findElement(By.xpath("//div[@class='uploaded-files']//span[text()='" + fileName + "']"));
        return uploadedFile.isDisplayed();
    }

    public boolean isRFPUploaded(String fileName) {
        WebElement uploadedFile = driver.findElement(By.xpath("//div[@class='uploaded-rfp']//span[text()='" + fileName + "']"));
        return uploadedFile.isDisplayed();
    }

    public String getSelectedDate() {
        return driver.findElement(requiredDate).getAttribute("value");
    }

    public boolean isFormSubmittedSuccessfully() {
        WebElement successMessage = driver.findElement(By.xpath(""));
        return successMessage.isDisplayed();
    }

    public void clearMandatoryFields() {
        driver.findElement(quantity).clear();
        driver.findElement(budget).clear();
    }
}


