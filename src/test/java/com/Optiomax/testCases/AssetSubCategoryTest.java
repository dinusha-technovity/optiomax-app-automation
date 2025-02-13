package com.Optiomax.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.AssetSubCategoryPage;
import com.Optiomax.pageObjects.BasePage;


public class AssetSubCategoryTest extends BasePage {

	private AssetSubCategoryPage assetSubCategoryPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		assetSubCategoryPage = new AssetSubCategoryPage(driver);
		assetSubCategoryPage.login("", "");
		Thread.sleep(5000);
		driver.get("");
		Thread.sleep(5000);
		driver.navigate().refresh();
	}
 
	@Test(priority = 1)
	public void testPageLoad() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(assetSubCategoryPage.isPageLoaded(), "The asset sub category page did not load successfully.");
	}
	
	@Test(priority = 2)
	public void testAssetCategoryCardsDisplay() throws InterruptedException {
		Assert.assertTrue(assetSubCategoryPage.getAssetSubCategoriesCardCount() > 0,
				"The asset category cards are not displayed.");
	}
	
	@Test(priority = 3)
	public void testAddAssetSubCategory() throws InterruptedException {
		assetSubCategoryPage.clickAssetSubCategory();
		Thread.sleep(3000);
		// Verify that the new pop-up window appears
		Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Add New Asset Sub Categories']")).isDisplayed(),
				"The 'Add New Asset Sub Category' popup did not appear.");
		assetSubCategoryPage.clickAssetSubCategoryClose();
	}
	
	@Test(priority = 4)
	public void testSearchFunctionalityWithAssetSubCategoryNames() throws InterruptedException {
		assetSubCategoryPage.clickAssetSubCategory();
		Thread.sleep(3000);
		Assert.assertTrue();
		
	}
	
	@Test(priority = 5)
	public void testSearchFunctionalityWithPartialAssetCategoryNames() throws InterruptedException {
		assetCategoryPage.searchAssetManagement("cle");
		Thread.sleep(3000);
		Assert.assertTrue(assetCategoryPage.isAssetCategoryPresent("cle"), "The search functionality did not return the expected results.");
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
	@Test(priority = 6)
	public void testsearchFunctionalityWithNonExistingAssetCategoryName() throws InterruptedException {
		assetCategoryPage.searchAssetManagement("Non Existing Asset Category");
		Thread.sleep(3000);
		//Assert.assertTrue(assetCategoryPage.isNoResultsMessagePresent(), "The error handling for non existing asset is not working as expected.");
		driver.navigate().refresh();
	}

	@Test(priority = 7)
	public void testViewAssetCategory() throws InterruptedException {
		Thread.sleep(3000);
		assetCategoryPage.clickViewAssetCategory();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Assets Details']")).isDisplayed(), "The 'Assets Record & Register' view popup did not appear");
	}
	
	@Test(priority = 8)
	public void testEditAssetCategory() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		assetCategoryPage.clickEditAssetCategory();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed(), "The asset category update popup did not appear");
		// need to add xpath
	}
	
	@Test(priority = 9)
	public void testDeleteAssetCategory() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		assetCategoryPage.clickDeleteAssetCategory();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed(), "The asset category delete popup did not appear");
	}
	
    @Test(priority = 10)
    public void testToggleListView() {
    	driver.navigate().refresh();
        assetCategoryPage.clickListView();
        Assert.assertTrue(assetCategoryPage.isElementPresent(By.xpath("")), "List view toggle did not work properly.");
    }

    @Test(priority=12)
    public void testTogglegridViewList() {
    	driver.navigate().refresh();
    	assetCategoryPage.clickGridView();
    	Assert.assertTrue(assetCategoryPage.isElementPresent(By.xpath("")), "Grid view toggle did not work properly.");
    }

    @Test(priority=13)
    public void testNextPageButton() throws InterruptedException {
    	driver.navigate().refresh();
    	Thread.sleep(3000);
    	assetCategoryPage.clickNext();
    	Assert.assertTrue(assetCategoryPage.isElementPresent(By.xpath("")), "Next page button did not work correctly.");
    	driver.navigate().refresh();
    }

    @Test(priority=14)
    public void testPreviousButton() throws InterruptedException {
    	driver.navigate().refresh();
    	Thread.sleep(3000);
    	assetCategoryPage.clickPrevious();
    	Assert.assertTrue(assetCategoryPage.isElementPresent(By.xpath("")), "Previous page button did not work correctly.");
    	driver.navigate().refresh();
    }
	
	@AfterClass
	public void tearDown() {
		super.teardown();
	}
	
}



