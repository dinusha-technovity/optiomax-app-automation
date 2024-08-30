package com.Optiomax.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.BasePage;
import com.Optiomax.pageObjetcs.ProcurementInitiateFormPage;

public class ProcurementInitiateFormTest extends BasePage {

    private ProcurementInitiateFormPage procurementInitiateFormPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
		super.setup();
		procurementInitiateFormPage = new ProcurementInitiateFormPage(driver);
		procurementInitiateFormPage.login("chamoddushyantha2017@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/supplier");
		Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void verifyFormDisplay() {
        Assert.assertTrue(procurementInitiateFormPage.isFormDisplayed(), "Procurement Initiate Form is not displayed");
    }

    @Test(priority = 2)
    public void verifyFormSubmissionWithAllFields() {
        procurementInitiateFormPage.searchRequisition("he5d26y5");
        procurementInitiateFormPage.selectRequisition("he5d26y5");
        procurementInitiateFormPage.addItemToSelected();
        procurementInitiateFormPage.editQuantity("10");
        procurementInitiateFormPage.editBudget("5000");
        procurementInitiateFormPage.uploadFile("C:\\path\\to\\file.png");
        procurementInitiateFormPage.uploadRFP("C:\\path\\to\\document.pdf");
        procurementInitiateFormPage.selectRequiredDate("08/04/2024");
        procurementInitiateFormPage.enterComment("Test comment");
        procurementInitiateFormPage.submitForm();
        Assert.assertTrue(procurementInitiateFormPage.isFormSubmittedSuccessfully(), "Form is not submitted successfully with all fields");
    }

    @Test(priority = 3)
    public void verifyFormSubmissionWithoutMandatoryFields() {
        procurementInitiateFormPage.clearMandatoryFields();
        procurementInitiateFormPage.submitForm();
        Assert.assertFalse(procurementInitiateFormPage.isFormSubmittedSuccessfully(), "Form should not be submitted without mandatory fields");
    }

    @Test(priority = 4)
    public void verifyProcurementInitiateNumberGeneration() {
        String initiateNumber = procurementInitiateFormPage.getProcurementInitiateNumber();
        Assert.assertNotNull(initiateNumber, "Procurement Initiate Number is not generated");
    }

    @Test(priority = 5)
    public void verifyRequisitionSearch() {
        procurementInitiateFormPage.searchRequisition("he5d26y5");
        Assert.assertTrue(procurementInitiateFormPage.isRequisitionFound("he5d26y5"), "Requisition ID is not found");
    }

    @Test(priority = 6)
    public void verifyItemSelection() {
        procurementInitiateFormPage.selectRequisition("he5d26y5");
        procurementInitiateFormPage.addItemToSelected();
        Assert.assertTrue(procurementInitiateFormPage.isItemSelected("he5d26y5"), "Item is not added to Selected items");
    }

    @Test(priority = 7)
    public void verifyQuantityEdit() {
    	procurementInitiateFormPage.editQuantity("10");
        Assert.assertEquals(procurementInitiateFormPage.getQuantity(), "10", "Quantity is not updated correctly");
    }

    @Test(priority = 8)
    public void verifyBudgetEdit() {
        procurementInitiateFormPage.editBudget("5000");
        Assert.assertEquals(procurementInitiateFormPage.getBudget(), "5000", "Budget is not updated correctly");
    }

    @Test(priority = 9)
    public void verifyItemRemoval() {
        procurementInitiateFormPage.removeSelectedItem();
        Assert.assertFalse(procurementInitiateFormPage.isItemSelected("he5d26y5"), "Item is not removed from Selected items");
    }

    @Test(priority = 10)
    public void verifyFileUpload() {
        procurementInitiateFormPage.uploadFile("C:\\path\\to\\file.png");
        Assert.assertTrue(procurementInitiateFormPage.isFileUploaded("file.png"), "File is not uploaded successfully");
    }

    @Test(priority = 11)
    public void verifyRFPUpload() {
        procurementInitiateFormPage.uploadRFP("C:\\path\\to\\document.pdf");
        Assert.assertTrue(procurementInitiateFormPage.isRFPUploaded("document.pdf"), "RFP document is not uploaded successfully");
    }

    @Test(priority = 12)
    public void verifyDateSelection() {
        procurementInitiateFormPage.selectRequiredDate("08/04/2024");
        Assert.assertEquals(procurementInitiateFormPage.getSelectedDate(), "08/04/2024", "Required date is not selected correctly");
    }
    
    @Test(priority = 13)
    public void verifyRFUpload() {
    	procurementInitiateFormPage.uploadRFP("C:\\Users\\Janodya\\Downloads\\Asset Document.png");
    	Assert.assertEquals(procurementInitiateFormPage.isFileUploaded("Asset Document"), "Docurement uploaded successfully.");
    }
    
    @Test(priority = 14)
    public void verfiyAssetDocumentUpload() {
    	procurementInitiateFormPage.uploadFile("");
    	Assert.assertEquals(procurementInitiateFormPage.isFileUploaded("Asset Documents"), "Asset Documents uploaded successfully.");
    }
    
//    @Test(priority = 13)
//    public void verifySelectedItems() {
//    	procurementInitiateFormPage.selectedItems();
//    	procurementInitiateFormPage.clickSubmit();
//    	Assert.assertEquals(procurementInitiateFormPage.isItemSelected(""), "Item is not selected correctly.");
//    }
//    
//    @Test(priority = 14)
//    public void verifyItems() {
//    	procurementInitiateFormPage.selectedItems();
//    	procurementInitiateFormPage.clickSubmit();
//    	Assert.assertEquals(procurementInitiateFormPage.isItemSelected(""), "Items are not selected correctly.");
//    }
//    
//    @Test(priority = 15)
//    public void verifyAddMultipleItems() {
//    	procurementInitiateFormPage.selectedItems();
//    	procurementInitiateFormPage.selectedItems();
//    	procurementInitiateFormPage.clickSubmit();
//    	Assert.assertEquals(procurementInitiateFormPage.isItemSelected(""), "Multiple items are not selected.");
//    }
   
}

