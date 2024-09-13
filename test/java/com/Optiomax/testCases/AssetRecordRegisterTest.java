package com.Optiomax.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.AssetRecordRegisterPage;
import com.Optiomax.pageObjects.BasePage;

public class AssetRecordRegisterTest extends BasePage {
	private AssetRecordRegisterPage assetRecordRegisterPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		assetRecordRegisterPage = new AssetRecordRegisterPage(driver);
		assetRecordRegisterPage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/assets_management");
		Thread.sleep(5000);
	}
    
    @Test(priority = 1)
    public void testAssetRecordRegister() throws InterruptedException {
        
    	assetRecordRegisterPage.clickAssetRecordRegister();
    	Thread.sleep(3000);
    	assetRecordRegisterPage.selectAssetTypeSelection1();
    	assetRecordRegisterPage.enterAssetValue("50000");
    	assetRecordRegisterPage.selectAssetCategorySelection1();
    	assetRecordRegisterPage.selectAssetSubCategorySelection1();
    	assetRecordRegisterPage.selectSupplierSelection1();
    	assetRecordRegisterPage.enterPurchaseOrderNumber("000100200301");
    	assetRecordRegisterPage.attachAssetImage("C:\\Users\\Janodya\\Downloads\\Images\\lap2.jfif");
    	Thread.sleep(3000);
    	assetRecordRegisterPage.attachAssetsRelatedDocument("C:\\Users\\Janodya\\Downloads\\Document.png");
    	Thread.sleep(3000);
    	assetRecordRegisterPage.enterPurchaseCost("50000");
    	assetRecordRegisterPage.selectPurchaseTypeSelection1();
    	assetRecordRegisterPage.clickReceivedConditionBrandNew();
    	assetRecordRegisterPage.enterWarranty("2 years");
    	assetRecordRegisterPage.enterPurchaseDetails("Test Purchase Details");
    	assetRecordRegisterPage.attachPurchaseDocument("");
    	assetRecordRegisterPage.enterInsuranceNumber("12345");
    	assetRecordRegisterPage.enterExpectedLifeTime("4 years");
    	assetRecordRegisterPage.enterEstimatedDepreciationValue("75");
    	assetRecordRegisterPage.attachInsuranceRelatedDocuments("");
    	assetRecordRegisterPage.enterAssetModelNumber("123ABC");
    	assetRecordRegisterPage.enterSerialNumber("123456789");
    	assetRecordRegisterPage.selectResponsiblePersonSelection1();
    	assetRecordRegisterPage.enterStoredLocation("No:123, Colombo");
    	assetRecordRegisterPage.clickOrganizationStructure();
    	assetRecordRegisterPage.selectDepartment();
    	assetRecordRegisterPage.clickSpace();
    	assetRecordRegisterPage.clickAddAssetButton();
    	Thread.sleep(3000);
    	
    	WebElement element = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/form/div[6]/a"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	element.click();
    	
    	Thread.sleep(3000);
    	driver.navigate().refresh();
    }
    
    
//    @Test(priority = 2)
//    public void testAssetRecordRegisterTest2() throws InterruptedException {
//        
//    	assetRecordRegisterPage.clickAssetRecordRegister();
//    	Thread.sleep(3000);
//    	assetRecordRegisterPage.selectAssetTypeSelection2();
//    	assetRecordRegisterPage.enterAssetValue("50000");
//    	assetRecordRegisterPage.selectAssetCategorySelection2();
//    	assetRecordRegisterPage.selectAssetSubCategorySelection2();
//    	assetRecordRegisterPage.selectSupplierSelection2();
//    	assetRecordRegisterPage.enterPurchaseOrderNumber("000100200301");
//    	assetRecordRegisterPage.attachAssetImage("C:\\Users\\Janodya\\Downloads\\Images\\lap2.jfif");
//    	Thread.sleep(3000);
//    	assetRecordRegisterPage.attachAssetsRelatedDocument("C:\\Users\\Janodya\\Downloads\\Document.png");
//    	Thread.sleep(3000);
//    	assetRecordRegisterPage.enterPurchaseCost("50000");
//    	assetRecordRegisterPage.selectPurchaseTypeSelection2();
//    	assetRecordRegisterPage.clickReceivedConditionBrandNew();
//    	assetRecordRegisterPage.enterWarranty("2 years");
//    	assetRecordRegisterPage.enterPurchaseDetails("Test Purchase Details");
//    	assetRecordRegisterPage.attachPurchaseDocument("");
//    	assetRecordRegisterPage.enterInsuranceNumber("12345");
//    	assetRecordRegisterPage.enterExpectedLifeTime("4 years");
//    	assetRecordRegisterPage.enterEstimatedDepreciationValue("75");
//    	assetRecordRegisterPage.attachInsuranceRelatedDocuments("");
//    	assetRecordRegisterPage.enterAssetModelNumber("123ABC");
//    	assetRecordRegisterPage.enterSerialNumber("123456789");
//    	assetRecordRegisterPage.selectResponsiblePersonSelection2();
//    	assetRecordRegisterPage.enterStoredLocation("No:123, Colombo");
//    	assetRecordRegisterPage.clickOrganizationStructure();
//    	assetRecordRegisterPage.selectDepartment();
//    	assetRecordRegisterPage.clickSpace();
//    	assetRecordRegisterPage.clickAddAssetButton();
//    	Thread.sleep(3000);
//    	
//    	WebElement element = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/form/div[6]/a"));
//    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//    	element.click();
//    	
//    	Thread.sleep(3000);
//    	driver.navigate().refresh();
//    }
    
}    
