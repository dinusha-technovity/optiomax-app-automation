package com.Optiomax.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.UpdateAssetManagementPage;

public class UpdateAssetManagementTest extends BasePage {
	
	UpdateAssetManagementPage updateAssetManagementPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
		super.setup();
		updateAssetManagementPage = new UpdateAssetManagementPage(driver);
		updateAssetManagementPage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);
        driver.get("http://app.optiomax.com/dashboard/assets_management"); 
		Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void updateAssetDetails() {
        updateAssetManagementPage.clickUpdateIcon();
        
        updateAssetManagementPage.enterAssetModelNumber("Model123");
        updateAssetManagementPage.enterSerialNumber("SN123456");
        updateAssetManagementPage.selectResponsiblePersonSelection1();
        updateAssetManagementPage.enterStoredLocation("Main Warehouse");
        updateAssetManagementPage.selectAssetTypeSelection1();
        updateAssetManagementPage.enterAssetValue("5000");
        updateAssetManagementPage.selectAssetCategorySelection1();
        updateAssetManagementPage.enterPurchaseOrderNumber("PO123456");
        updateAssetManagementPage.enterPurchaseCost("4500");
        updateAssetManagementPage.clickReceivedConditionBrandNew();
        updateAssetManagementPage.enterWarranty("12 months");
        updateAssetManagementPage.enterPurchaseDetails("Purchased for internal office use.");
        updateAssetManagementPage.attachPurchaseDocument("/path/to/purchase/document.pdf");
        updateAssetManagementPage.enterInsuranceNumber("INS12345");
        updateAssetManagementPage.enterExpectedLifeTime("5 years");
        updateAssetManagementPage.enterEstimatedDepreciationValue("50%");
        updateAssetManagementPage.attachInsuranceRelatedDocuments("/path/to/insurance/document.pdf");
        
        updateAssetManagementPage.clickUpdateBtn();
        
        // Add assertions to verify the update operation
        //Assert.assertTrue(driver.getPageSource().contains("Asset updated successfully"));
    }

    @Test(priority = 2)
    public void verifyRequiredFieldsValidation() {
        updateAssetManagementPage.clickUpdateIcon();
        
        updateAssetManagementPage.enterAssetModelNumber("");
        updateAssetManagementPage.enterSerialNumber("");
        updateAssetManagementPage.clickUpdateBtn();
        
        // Verify error messages for required fields
        Assert.assertTrue(driver.getPageSource().contains("Model number is required"));
        Assert.assertTrue(driver.getPageSource().contains("Serial number is required"));
    }

    @Test(priority = 3)
    public void verifyFileUploadFunctionality() {
        updateAssetManagementPage.clickUpdateIcon();
        
        updateAssetManagementPage.attachAssetImage("");
        updateAssetManagementPage.attachPurchaseDocument("");
        updateAssetManagementPage.attachInsuranceRelatedDocuments("");
        
        // Add assertions to verify if the files are successfully uploaded
//        Assert.assertTrue(driver.getPageSource().contains("File uploaded successfully"));
        
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}
