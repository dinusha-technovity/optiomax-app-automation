package com.Optiomax.testCases;

import com.Optiomax.pageObjects.AssetRegisterPage;
import com.Optiomax.pageObjects.BasePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssetRegisterTest extends BasePage {

    private AssetRegisterPage assetRegisterPage;
    
    @BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		assetRegisterPage = new AssetRegisterPage(driver);
		assetRegisterPage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/assets_management");
		Thread.sleep(5000);
		driver.navigate().refresh();
	}

    @Test(priority = 1)
    public void testSuccessfulSubmission() throws InterruptedException {

        assetRegisterPage.enterAssetName("Office Building");
        assetRegisterPage.selectAssetType("Tangible assets");
        Assert.assertEquals(assetRegisterPage.getSelectedAssetType(), "Tangible assets",
                "Asset Type should be 'Tangible assets'");
        
        assetRegisterPage.selectAssetCategory("Computer & Hardware");
        Assert.assertEquals(assetRegisterPage.getSelectedCategoryType(), "Property",
                "Asset Category should be 'Property'");
       
        assetRegisterPage.selectAssetSubCategory("Laptop");
        Assert.assertEquals(assetRegisterPage.getSelectedSubCategoryType(), "Buildings",
                "Asset Sub-Category should be 'Buildings'");

        assetRegisterPage.enterAssetValue("450");
        assetRegisterPage.eneterAverageLifeTime("3 years");
        assetRegisterPage.uploadImage("C:\\path\\to\\test-image.png");
        assetRegisterPage.enterDetailType("Commercial");
        assetRegisterPage.enterDetails("Main corporate office in downtown");
        assetRegisterPage.enterAssetDescription("This building is used as the main corporate office for the company.");
        assetRegisterPage.clickSubmit();
        Thread.sleep(3000);
        driver.navigate().refresh();
        
    }
    
    @Test(priority = 2)
    public void testItemDetailsFunctionality() throws InterruptedException {
    	assetRegisterPage.clickAssetRecordRegister();
    	assetRegisterPage.enterAssetName("Lenovo T460");
    	assetRegisterPage.selectAssetType("Operating assets");
    	Assert.assertEquals(assetRegisterPage.getSelectedAssetType(), "Operating assets", "Asset Type should be 'Operating asset'");
    	
    	assetRegisterPage.selectAssetCategory("Computer & Hardware");
    	Assert.assertEquals(assetRegisterPage.getSelectedAssetType(), "Computer & Hardware", "Asset Type should be 'Operating asset'");
    	
    	assetRegisterPage.selectAssetCategory("Laptop");
    	Assert.assertEquals(assetRegisterPage.getSelectedAssetType(), "Laptop", "Asset category should be 'Laptop'");
    	
        assetRegisterPage.enterAssetValue("520");
        assetRegisterPage.eneterAverageLifeTime("3 years");
        assetRegisterPage.uploadImage("/home/breadscrums/Documents/Images/Profile.png"); 
        assetRegisterPage.enterDetails("test2");
        assetRegisterPage.clickAddNew();
        assetRegisterPage.enterDetails("test3");
        assetRegisterPage.enterDetailType("test 4");
        assetRegisterPage.enterAssetDescription("test");
        Thread.sleep(3000);
        assetRegisterPage.clickSubmit();
        Thread.sleep(3000);
        driver.navigate().refresh();
    }
    
    @Test(priority = 3)
    public void testErrorHandlingFunctionality() throws InterruptedException {
    	assetRegisterPage.clickAssetRecordRegister();
    	assetRegisterPage.clickSubmit();
    	Thread.sleep(3000);
    						
    	WebElement assetNameError = driver.findElement(By.xpath("//div[normalize-space()='Required']"));
		WebElement assetTypeError = driver.findElement(By.xpath("//div[normalize-space()='Asset type is required']"));
    	WebElement assetCategoryError = driver.findElement(By.xpath("//div[normalize-space()='Asset category is required']"));
		WebElement assetSubCategoryError = driver.findElement(By.xpath("//div[normalize-space()='Asset sub-category is required']"));
    	WebElement imageUploadError = driver.findElement(By.xpath("//div[normalize-space()='At least one file is required for each asset']"));
    	
		Assert.assertTrue(assetNameError.isDisplayed(), "Asset Name error message should be displayed");
		Assert.assertTrue(assetTypeError.isDisplayed(), "Asset Type error message should be displayed");
		Assert.assertTrue(assetCategoryError.isDisplayed(), "Asset Category error message should be displayed");
		Assert.assertTrue(assetSubCategoryError.isDisplayed(), "Asset Sub Category error should be displayed");
		Assert.assertTrue(imageUploadError.isDisplayed(), "Image error should be displayed");
		
    }
    
    @Test(priority = 4)
    public void testFillingMandatoryField() throws InterruptedException {
    	assetRegisterPage.clickAssetRecordRegister();
    	assetRegisterPage.enterAssetName("Lenovo 123");
    	assetRegisterPage.selectAssetType("Fixed assets");
    	assetRegisterPage.selectAssetCategory("Electronic");
    	assetRegisterPage.selectAssetSubCategory("Ac Machine");
    	assetRegisterPage.uploadImage("/home/breadscrums/Documents/Images/Profile.png");
    	Thread.sleep(3000);
    	assetRegisterPage.clickSubmit();
    	
    	Assert.assertEquals(assetRegisterPage.getSelectedSubCategoryType(), "Asset type should be displayed.");
    	Assert.assertEquals(assetRegisterPage.getSelectedCategoryType(), "Asset Category should be displayed.");
    	Assert.assertEquals(assetRegisterPage.getSelectedSubCategoryType(), "Asset Sub Category should be displayed.");
    }
    
    @Test(priority = 5)
    public void testAddNewAndSaveFunctionality() {
    	assetRegisterPage.clickAssetRecordRegister();
    	assetRegisterPage.enterAssetName("");
    	assetRegisterPage.selectAssetType("Current assets");
    	assetRegisterPage.selectAssetCategory("Electronic");
    	assetRegisterPage.selectAssetSubCategory("Tv");
    	assetRegisterPage.enterAssetValue("");
    	assetRegisterPage.enterDetails("");
    	assetRegisterPage.enterDetailType("");
    	
    }
    
    @Test(priority = 6)
    public void testAddNewAndSave() {
        assetRegisterPage.clickAddNew();
        assetRegisterPage.clickSave();
        assetRegisterPage.enterAssetValue("640");
        assetRegisterPage.eneterAverageLifeTime("4 years");
        assetRegisterPage.uploadImage("/home/breadscrums/Documents/Images/Profile2.png"); 
        assetRegisterPage.enterDetails("test3");
        assetRegisterPage.clickAddNew();
        assetRegisterPage.enterDetails("test4");
        assetRegisterPage.enterDetailType("test5");
        assetRegisterPage.enterAssetDescription("test");
        
    }

    @Test(priority = 7)
    public void testUpdateAndDelete() {
        assetRegisterPage.clickUpdate();
        System.out.println("Update operation triggered");

        // Delete Operation
        assetRegisterPage.clickDelete();
        System.out.println("Delete operation triggered");
    }
      
}


