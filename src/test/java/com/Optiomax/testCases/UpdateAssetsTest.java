package com.Optiomax.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.UpdateAssetsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class UpdateAssetsTest extends BasePage {

	private UpdateAssetsPage updateAssetsPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		updateAssetsPage = new UpdateAssetsPage(driver);
		updateAssetsPage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/assets_management");
		Thread.sleep(5000);
		driver.navigate().refresh();
	}

	@Test(priority = 1)
	public void testSuccessfulSubmission() throws InterruptedException {

		updateAssetsPage.setAssetName("Laptop");
		updateAssetsPage.setAssetType("Fixed assets");
		Assert.assertEquals(updateAssetsPage.getSelectedAssetType(), "");

		updateAssetsPage.setAssetCategory("Computer & Hardware");
		Assert.assertEquals(updateAssetsPage.getSelectedAssetType(), "",
				"Asset Category should be 'Computer & Hardware'");

		updateAssetsPage.setAssetSubCategory("Monitor");
		Assert.assertEquals(updateAssetsPage.getSelectedAssetType(), "Monitor",
				"Asset Sub-Category should be 'Monitor'");

		updateAssetsPage.setAssetValue("578");
		updateAssetsPage.setAverageLifeTime("8 years");
		updateAssetsPage.setDescription(null);

		Thread.sleep(3000);
		driver.navigate().refresh();

	}

	@Test(priority = 2)
	public void testItemDetailsFunctionality() throws InterruptedException {
		updateAssetsPage.clickUpdateIcon();
		updateAssetsPage.setAssetName("Monitor");
		updateAssetsPage.setAssetCategory("Operating asstes");
		updateAssetsPage.setAssetSubCategory("Machinery");
		Assert.assertEquals(updateAssetsPage.getSelectedAssetType(), "The asset should be selected");
		Assert.assertEquals(updateAssetsPage.getSelectedAssetType(), "The asset category should be seleted");

		updateAssetsPage.setAssetValue("345");
		updateAssetsPage.setAverageLifeTime("Test life lime");
		updateAssetsPage.setDescription("");

		Thread.sleep(3000);
		driver.navigate().refresh();
	}

	@Test(priority = 3)
	public void testErrorHandlingFunctionality() throws InterruptedException {
		updateAssetsPage.clickUpdate();
		Thread.sleep(3000);

		WebElement assetNameError = driver.findElement(By.xpath("//div[normalize-space()='Required']"));
		WebElement assetTypeError = driver.findElement(By.xpath("//div[normalize-space()='Asset type is required']"));
		WebElement assetCategoryError = driver.findElement(By.xpath("//div[normalize-space()='Asset Category is required']"));
		WebElement assetSubCategoryError = driver.findElement(By.xpath("//div[normalize-space()='Asset Sub Category is required']"));
		WebElement attachImageError = driver.findElement(By.xpath("//div[normalize-space()='At least one file is required for each asset']"));

		Assert.assertTrue(assetNameError.isDisplayed(), "Asset Name error message should be displayed");
		Assert.assertTrue(assetTypeError.isDisplayed(), "Asset Type error message should be displayed");
		Assert.assertTrue(assetCategoryError.isDisplayed(), "Asset Category error message should be displayed");
		Assert.assertTrue(assetSubCategoryError.isDisplayed(), "Asset Sub Category error message should be displayed");
		Assert.assertTrue(attachImageError.isDisplayed(), "Asset attach image error message should be displayed");

	}

	@Test(priority = 4)
	public void testValidationErrorsOnEmptyFields() throws InterruptedException {
		updateAssetsPage.clickUpdateIcon();
		updateAssetsPage.setAssetName("");
		updateAssetsPage.setAssetCategory("");
		updateAssetsPage.setAssetSubCategory("");
		updateAssetsPage.setAssetSubCategory("");
		updateAssetsPage.setAssetValue("");
		updateAssetsPage.setDescription("");
		updateAssetsPage.setDetails("");
		updateAssetsPage.setDetailsType("");
		updateAssetsPage.clickUpdate();
		Thread.sleep(3000);

		WebElement assetNameError = driver.findElement(By.xpath("//div[normalize-space()='Required']"));
		WebElement assetTypeError = driver.findElement(By.xpath("//div[normalize-space()='Asset type is required']"));
		WebElement assetCategoryError = driver
				.findElement(By.xpath("//div[normalize-space()='Asset Category is required']"));
		WebElement assetSubCategoryError = driver
				.findElement(By.xpath("//div[normalize-space()='Asset sub-category is required']"));
		WebElement attachImageError = driver
				.findElement(By.xpath("//div[normalize-space()='At least one file is required for each asset']"));

		Assert.assertTrue(assetNameError.isDisplayed(), "Asset Name error message should be displayed");
		Assert.assertTrue(assetTypeError.isDisplayed(), "Asset Type error message should be displayed");
		Assert.assertTrue(assetCategoryError.isDisplayed(), "Asset Category error message should be displayed");
		Assert.assertTrue(assetSubCategoryError.isDisplayed(), "Asset Sub Category error message should be displayed");
		Assert.assertTrue(attachImageError.isDisplayed(), "Asset attach image error message should be displayed");
		
	}
	
	@Test(priority = 5)
	public void testAddMultipleDetials() throws InterruptedException {
		updateAssetsPage.clickUpdateIcon();
		updateAssetsPage.setAssetName("Test Laptop");
		updateAssetsPage.setAssetCategory("Tangible assets");
		updateAssetsPage.setAssetSubCategory("Computer & Hardware");
		updateAssetsPage.setAssetSubCategory("Laptop");
		updateAssetsPage.setAssetValue("780");
		updateAssetsPage.setDescription("Test asset description for asset register");
		Thread.sleep(3000);
		
		updateAssetsPage.addDetailsType("Test2");
		updateAssetsPage.addDetailsType("Test3");
		updateAssetsPage.addDetailsType("Test4");
		updateAssetsPage.addDetailsType("Test5");
		
		Thread.sleep(3000);
		Assert.assertEquals(updateAssetsPage.getSelectedAssetType(), "Multiple details should be added");
		
		updateAssetsPage.clickUpdate();	
	}
	
}

