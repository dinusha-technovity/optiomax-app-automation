package com.Optiomax.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.BasePage;
import com.Optiomax.pageObjetcs.ProcurementInitiateFormPage;

public class ProcurementInitiateFormTest extends BasePage {

    private ProcurementInitiateFormPage formPage;

    @BeforeMethod
    public void setUp() {
        formPage = new ProcurementInitiateFormPage(driver);
    }

    @Test(priority = 1)
    public void verifyFormDisplay() {
        Assert.assertTrue(formPage.isFormDisplayed(), "Procurement Initiate Form is not displayed");
    }

    @Test(priority = 2)
    public void verifyFormSubmissionWithAllFields() {
        formPage.searchRequisition("he5d26y5");
        formPage.selectRequisition("he5d26y5");
        formPage.addItemToSelected();
        formPage.editQuantity("10");
        formPage.editBudget("5000");
        formPage.uploadFile("C:\\path\\to\\file.png");
        formPage.uploadRFP("C:\\path\\to\\document.pdf");
        formPage.selectRequiredDate("08/04/2024");
        formPage.enterComment("Test comment");
        formPage.submitForm();
        Assert.assertTrue(formPage.isFormSubmittedSuccessfully(), "Form is not submitted successfully with all fields");
    }

    @Test(priority = 3)
    public void verifyFormSubmissionWithoutMandatoryFields() {
        formPage.clearMandatoryFields();
        formPage.submitForm();
        Assert.assertFalse(formPage.isFormSubmittedSuccessfully(), "Form should not be submitted without mandatory fields");
    }

    @Test(priority = 4)
    public void verifyProcurementInitiateNumberGeneration() {
        String initiateNumber = formPage.getProcurementInitiateNumber();
        Assert.assertNotNull(initiateNumber, "Procurement Initiate Number is not generated");
    }

    @Test(priority = 5)
    public void verifyRequisitionSearch() {
        formPage.searchRequisition("he5d26y5");
        Assert.assertTrue(formPage.isRequisitionFound("he5d26y5"), "Requisition ID is not found");
    }

    @Test(priority = 6)
    public void verifyItemSelection() {
        formPage.selectRequisition("he5d26y5");
        formPage.addItemToSelected();
        Assert.assertTrue(formPage.isItemSelected("he5d26y5"), "Item is not added to Selected items");
    }

    @Test(priority = 7)
    public void verifyQuantityEdit() {
        formPage.editQuantity("10");
        Assert.assertEquals(formPage.getQuantity(), "10", "Quantity is not updated correctly");
    }

    @Test(priority = 8)
    public void verifyBudgetEdit() {
        formPage.editBudget("5000");
        Assert.assertEquals(formPage.getBudget(), "5000", "Budget is not updated correctly");
    }

    @Test(priority = 9)
    public void verifyItemRemoval() {
        formPage.removeSelectedItem();
        Assert.assertFalse(formPage.isItemSelected("he5d26y5"), "Item is not removed from Selected items");
    }

    @Test(priority = 10)
    public void verifyFileUpload() {
        formPage.uploadFile("C:\\path\\to\\file.png");
        Assert.assertTrue(formPage.isFileUploaded("file.png"), "File is not uploaded successfully");
    }

    @Test(priority = 11)
    public void verifyRFPUpload() {
        formPage.uploadRFP("C:\\path\\to\\document.pdf");
        Assert.assertTrue(formPage.isRFPUploaded("document.pdf"), "RFP document is not uploaded successfully");
    }

    @Test(priority = 12)
    public void verifyDateSelection() {
        formPage.selectRequiredDate("08/04/2024");
        Assert.assertEquals(formPage.getSelectedDate(), "08/04/2024", "Required date is not selected correctly");
    }
    
//    @Test(priority = 13)
//    public void verifySelectedItems() {
//    	formPage.selectedItems();
//    	formPage.clickSubmit();
//    	Assert.assertEquals(formPage.isItemSelected(""), "Item is not selected correctly.");
//    }
//    
//    @Test(priority = 14)
//    public void verifyItems() {
//    	formPage.selectedItems();
//    	formPage.clickSubmit();
//    	Assert.assertEquals(formPage.isItemSelected(""), "Items are not selected correctly.");
//    }
//    
//    @Test(priority = 15)
//    public void verifyAddMultipleItems() {
//    	formPage.selectedItems();
//    	formPage.selectedItems();
//    	formPage.clickSubmit();
//    	Assert.assertEquals(formPage.isItemSelected(""), "Multiple items are not selected.");
//    }
   
}

