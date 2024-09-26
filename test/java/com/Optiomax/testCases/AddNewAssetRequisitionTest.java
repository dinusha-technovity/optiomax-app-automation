package com.Optiomax.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.AddNewAssetRequisitionPage;
import com.Optiomax.pageObjects.BasePage;

public class AddNewAssetRequisitionTest extends BasePage {
    private AddNewAssetRequisitionPage assetRequisitionPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
		super.setup();
        assetRequisitionPage = new AddNewAssetRequisitionPage(driver);
		assetRequisitionPage.login("sithum@gmail.com", "chamod1234");
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
        Thread.sleep(3000);
        assetRequisitionPage.selectOrganization();
        Thread.sleep(3000);
        assetRequisitionPage.clickSpace();
        assetRequisitionPage.enterReasonForRequisition("Test Reason");
        assetRequisitionPage.enterBusinessImpact("Test Business Impact");
        assetRequisitionPage.clickSuppliers();
        assetRequisitionPage.selectSupplier();
        assetRequisitionPage.clickSpace();
        assetRequisitionPage.enterDetailType("Color");
        assetRequisitionPage.enterItemDetails("Black");
        assetRequisitionPage.enterMaintenanceKPI("1234abcd");
        assetRequisitionPage.enterServiceSupportKPI("234xyz");
        assetRequisitionPage.enterconsumablesKPI("3456pqrs");
        assetRequisitionPage.clickAddItem();
        assetRequisitionPage.clickSave();
        assetRequisitionPage.submitForm();
        Thread.sleep(3000);
//        assetRequisitionPage.selectWorkflow();
//        assetRequisitionPage.selectAssignWorkflow();
        

        // Assert form submission by checking the confirmation message
//        String expectedMessage = "Asset requisition submitted successfully";
//        String actualMessage = assetRequisitionPage.getConfirmationMessage();
//        Assert.assertEquals(actualMessage, expectedMessage, "The asset requisition form was not submitted successfully.");
        
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

//	@Test(priority = 2)
//	public void testFormWithOptionalFieldsLeftBlank() throws InterruptedException {
//		assetRequisitionPage.addAssetRequisition();
//		Thread.sleep(3000);
//		assetRequisitionPage.enterItemName("Laptop");
//		assetRequisitionPage.selectAssetType("Tangible assets");
//		assetRequisitionPage.enterQuantity("10");
//		assetRequisitionPage.enterBudget("150000");
//		assetRequisitionPage.enterBusinessPurpose("For new employees");
//        assetRequisitionPage.clickAddItem();
//        assetRequisitionPage.clickSave();
//		assetRequisitionPage.submitForm();
//
//		// Assert form submission by checking the confirmation message
////        String expectedMessage = "Asset requisition submitted successfully";
////        String actualMessage = assetRequisitionPage.getConfirmationMessage();
////        Assert.assertEquals(actualMessage, expectedMessage, "The asset requisition form was not submitted successfully.");
//		
//		driver.navigate().refresh();
//		Thread.sleep(3000);
//		
//	}

    @Test(priority = 3)
    public void testAddItemButton() throws InterruptedException {
    	assetRequisitionPage.addAssetRequisition();
    	Thread.sleep(5000);
        assetRequisitionPage.enterItemName("Desktop");
        assetRequisitionPage.selectAssetType("Fixed assets");
        assetRequisitionPage.enterQuantity("7");
        assetRequisitionPage.enterBudget("1000000");
        assetRequisitionPage.enterBusinessPurpose("Test Business Purpose");
        assetRequisitionPage.choosePurchaseNew();
        assetRequisitionPage.selectPeriodTerm("Permanent");
        assetRequisitionPage.selectAvailabilityType("Purchase");
        assetRequisitionPage.selectPriority("Normal");
        assetRequisitionPage.enterRequiredDate("12/01/2024");
        assetRequisitionPage.clickOrganization();
        Thread.sleep(3000);
        assetRequisitionPage.selectOrganization();
        Thread.sleep(3000);
        assetRequisitionPage.clickSpace();
        assetRequisitionPage.enterReasonForRequisition("Test Reason");
        assetRequisitionPage.enterBusinessImpact("Test Business Impact");
        assetRequisitionPage.clickSuppliers();
        assetRequisitionPage.selectSupplier();
        assetRequisitionPage.clickSpace();
        assetRequisitionPage.clickAddItem();
        assetRequisitionPage.clickSave();
        assetRequisitionPage.submitForm();

        // Assert the item is added with update and delete icons
        WebElement topItem = assetRequisitionPage.getTopItem();
        Assert.assertNotNull(topItem.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[1]/table/tbody/tr/td[8]/div/a[1]")), "Update icon not found.");
        Assert.assertNotNull(topItem.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[1]/table/tbody/tr/td[8]/div/a[2]")), "Delete icon not found.");
        
        driver.navigate().refresh();
        Thread.sleep(3000);
        
    }

    @Test(priority = 4)
    public void testUpdateIconFunctionality() throws InterruptedException {
        // Add and update an item
    	assetRequisitionPage.addAssetRequisition();
    	Thread.sleep(5000);
        assetRequisitionPage.enterItemName("Laptop");
        assetRequisitionPage.selectAssetType("Fixed assets");
        assetRequisitionPage.clickAddItem();
        Thread.sleep(3000);
        assetRequisitionPage.updateTopItem("Updated Laptop");
        assetRequisitionPage.saveChanges();

        // Assert the item name is updated
        WebElement topItem = assetRequisitionPage.getTopItem();
        String updatedItemName = topItem.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[1]/table/tbody/tr[1]/td[1]")).getText();
        Assert.assertEquals(updatedItemName, "Updated Laptop", "Item name was not updated.");
        
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void testDeleteIconFunctionality() throws InterruptedException {
        // Add and delete an item
    	assetRequisitionPage.addAssetRequisition();
    	Thread.sleep(5000);
        assetRequisitionPage.enterItemName("Printer");
        assetRequisitionPage.selectAssetType("Tangible assets");
        assetRequisitionPage.clickAddItem();
        assetRequisitionPage.deleteTopItem();

        // Assert the item is removed
        WebElement topItem = assetRequisitionPage.getTopItem();
        Assert.assertNull(topItem, "Item was not deleted.");
    }

    @Test(priority = 6)
    public void testAddMultipleItems() {
        // Add multiple items
    	assetRequisitionPage.addAssetRequisition();
        assetRequisitionPage.enterItemName("Laptop");
        assetRequisitionPage.selectAssetType("Tangible assets");
        assetRequisitionPage.clickAddItem();
        assetRequisitionPage.enterItemName("Monitor");
        assetRequisitionPage.selectAssetType("Tangible assets");
        assetRequisitionPage.clickAddItem();

        // Assert multiple items are added
        int itemCount = driver.findElements(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[2]/form/div[2]/div/div[1]/table/tbody/tr[1]")).size();
        Assert.assertTrue(itemCount > 1, "Multiple items were not added.");        
    }

    @Test(priority = 7)
    public void testUploadAttachments() {
        // Attach a file
    	assetRequisitionPage.addAssetRequisition();
        assetRequisitionPage.enterItemName("Laptop");
        assetRequisitionPage.selectAssetType("Tangible assets");
        assetRequisitionPage.attachFile("C:\\Users\\Janodya\\Desktop\\Test Document.pdf");
        assetRequisitionPage.clickAddItem();
        assetRequisitionPage.clickSave();
        assetRequisitionPage.submitForm();

        // Assert the file is attached successfully
        String attachedFileName = driver.findElement(By.xpath("//input[@id='multiple_files']")).getText();
        Assert.assertEquals(attachedFileName, "attachment.pdf", "File was not attached successfully.");
        
    }
 
}

