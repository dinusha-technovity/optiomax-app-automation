package com.Optiomax.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.AddNewAssetRequisitionPage;
import com.Optiomax.pageObjetcs.BasePage;

public class AddNewAssetRequisitionTest extends BasePage {
    private AddNewAssetRequisitionPage assetRequisitionPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
		super.setup();
        assetRequisitionPage = new AddNewAssetRequisitionPage(driver);
		assetRequisitionPage.login("chamoddushyantha2017@gmail.com", "UMwI4u3w");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/asset_requisitions");
		Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void testAddNewAssetRequisition() throws InterruptedException {
    	assetRequisitionPage.addAssetRequisition();
    	Thread.sleep(5000);
        assetRequisitionPage.enterItemName("Laptop");
        assetRequisitionPage.selectAssetType("Tangible assets");
        assetRequisitionPage.enterQuantity("10");
        assetRequisitionPage.enterBudget("1000000");
        assetRequisitionPage.enterBusinessPurpose("Test Business Purpose");
        assetRequisitionPage.choosePurchaseNew();
        assetRequisitionPage.selectPeriodTerm("Permanent");
        assetRequisitionPage.selectAvailabilityType("Purchase");
        assetRequisitionPage.selectPriority("High");
        assetRequisitionPage.enterRequiredDate("08/20/2024");
        assetRequisitionPage.clickOrganization();
        assetRequisitionPage.selectOrganization();
        assetRequisitionPage.enterReasonForRequisition("Test Reason");
        assetRequisitionPage.enterBusinessImpact("Test Business Impact");
        assetRequisitionPage.attachFile("");
        assetRequisitionPage.clickSuppliers();
        assetRequisitionPage.selectSupplier();
        
        assetRequisitionPage.clickAddItem();
        assetRequisitionPage.clickSave();
        assetRequisitionPage.submitForm();
        

        // Assert form submission by checking the confirmation message
//        String expectedMessage = "Asset requisition submitted successfully";
//        String actualMessage = assetRequisitionPage.getConfirmationMessage();
//        Assert.assertEquals(actualMessage, expectedMessage, "The asset requisition form was not submitted successfully.");
    }

//    @Test(priority = 2)
//    public void testFormWithOptionalFieldsLeftBlank() {
//        assetRequisitionPage.enterItemName("Laptop");
//        assetRequisitionPage.selectAssetType("Tangible");
//        assetRequisitionPage.enterQuantity("10");
//        assetRequisitionPage.enterBudget("15000");
//        assetRequisitionPage.enterBusinessPurpose("For new employees");
//        assetRequisitionPage.submitForm();
//
//        // Assert form submission by checking the confirmation message
////        String expectedMessage = "Asset requisition submitted successfully";
////        String actualMessage = assetRequisitionPage.getConfirmationMessage();
////        Assert.assertEquals(actualMessage, expectedMessage, "The asset requisition form was not submitted successfully.");
//    }
//
//    @Test(priority = 3)
//    public void testAddItemButton() {
//        // Add an item
//        assetRequisitionPage.enterItemName("Laptop");
//        assetRequisitionPage.clickAddItem();
//
//        // Assert the item is added with update and delete icons
//        WebElement topItem = assetRequisitionPage.getTopItem();
//        Assert.assertNotNull(topItem.findElement(By.cssSelector("")), "Update icon not found.");
//        Assert.assertNotNull(topItem.findElement(By.cssSelector("")), "Delete icon not found.");
//    }
//
//    @Test(priority = 4)
//    public void testUpdateIconFunctionality() {
//        // Add and update an item
//        assetRequisitionPage.enterItemName("Laptop");
//        assetRequisitionPage.clickAddItem();
//        assetRequisitionPage.updateTopItem("Updated Laptop");
// //       assetRequisitionPage.saveChanges();
//
//        // Assert the item name is updated
//        WebElement topItem = assetRequisitionPage.getTopItem();
//        String updatedItemName = topItem.findElement(By.cssSelector("")).getText();
//        Assert.assertEquals(updatedItemName, "Updated Laptop", "Item name was not updated.");
//    }
//
//    @Test(priority = 5)
//    public void testDeleteIconFunctionality() {
//        // Add and delete an item
//        assetRequisitionPage.enterItemName("Laptop");
//        assetRequisitionPage.clickAddItem();
//        assetRequisitionPage.deleteTopItem();
//  //      assetRequisitionPage.saveChanges();
//
//        // Assert the item is removed
//        WebElement topItem = assetRequisitionPage.getTopItem();
//        Assert.assertNull(topItem, "Item was not deleted.");
//    }
//
//    @Test(priority = 6)
//    public void testAddMultipleItems() {
//        // Add multiple items
//        assetRequisitionPage.enterItemName("Laptop");
//        assetRequisitionPage.clickAddItem();
//        assetRequisitionPage.enterItemName("Monitor");
//        assetRequisitionPage.clickAddItem();
//
//        // Assert multiple items are added
//        int itemCount = driver.findElements(By.cssSelector("")).size();
//        Assert.assertTrue(itemCount > 1, "Multiple items were not added.");
//    }
//
//    @Test(priority = 7)
//    public void testUploadAttachments() {
//        // Attach a file
//        assetRequisitionPage.attachFile("C:\\path\\to\\attachment.pdf");
//
//        // Assert the file is attached successfully
//        String attachedFileName = driver.findElement(By.cssSelector("")).getText();
//        Assert.assertEquals(attachedFileName, "attachment.pdf", "File was not attached successfully.");
//    }
 
}

