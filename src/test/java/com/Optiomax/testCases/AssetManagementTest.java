package com.Optiomax.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.AssetManagementPage;
import com.Optiomax.pageObjects.BasePage;

public class AssetManagementTest extends BasePage {

	private AssetManagementPage assetManagementPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		assetManagementPage = new AssetManagementPage(driver);
		assetManagementPage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/assets_management");
		Thread.sleep(5000);
		driver.navigate().refresh();
	}
 
	@Test(priority = 1)
	public void testPageLoad() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(assetManagementPage.isPageLoaded(), "The asset management page did not load successfully.");
	}
	
	@Test(priority = 2)
	public void testAssetManagementCardsDisplay() throws InterruptedException {
		Assert.assertTrue(assetManagementPage.getAssetManagementCardCount() > 0,
				"The asset management cards are not displayed.");
	}
	
	@Test(priority = 3)
	public void testAssetRecordRegister() throws InterruptedException {
		assetManagementPage.clickAssetRecordRegister();
		Thread.sleep(3000);
		// Verify that the new pop-up window appears
		Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Assets Register']")).isDisplayed(),
				"The 'Assets Record & Register' popup did not appear.");
		assetManagementPage.clickCloseAssetRecordRegister();
	}
	
	@Test(priority = 4)
	public void testSearchFunctionaityWithValidAssetName() throws InterruptedException {
		assetManagementPage.searchAssetManagement("T460");
		Thread.sleep(3000);
		Assert.assertTrue(assetManagementPage.isAssetManagementPresent("T460"), "The search functionality did not return the expected results.");
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
	@Test(priority = 5)
	public void testSearchFunctionalityWithPartialAssetNames() throws InterruptedException {
		assetManagementPage.searchAssetManagement("60");
		Thread.sleep(3000);
		Assert.assertTrue(assetManagementPage.isAssetManagementPresent("T460"), "The search functionality did not return the expected results.");
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
	@Test(priority = 6)
	public void testsearchFunctionalityWithNonExistingAssetName() throws InterruptedException {
		assetManagementPage.searchAssetManagement("Non Existing Asset Name");
		Thread.sleep(3000);
		//Assert.assertTrue(assetManagementPage.isNoResultsMessagePresent(), "The error handling for non existing asset is not working as expected.");
		driver.navigate().refresh();
	}

	@Test(priority = 7)
	public void testViewAssetManagement() throws InterruptedException {
		Thread.sleep(3000);
		assetManagementPage.clickViewAssetManagement();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Assets Details']")).isDisplayed(), "The 'Assets Record & Register' view popup did not appear");
	}
	
	@Test(priority = 8)
	public void testTagAssetManagement() throws InterruptedException {
		Thread.sleep(3000);
		assetManagementPage.clickTagAssetManagement();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Update Asset Classification']")).isDisplayed(), null);
	}
	
	@Test(priority = 8)
	public void testUpdateAssetManagement() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		assetManagementPage.clickUpdateAssetManagement();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed(), "The 'Assets Record & Register' update popup did not appear");
		// Need to add update xpath
	}
	
	@Test(priority = 9)
	public void testDeleteAssetManagement() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		assetManagementPage.clickDeleteAssetManagement();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='text-lg font-semibold text-gray-900 dark:text-white']")).isDisplayed(), "The 'Assets Record & Register' delete popup did not appear");
	}
	
    @Test(priority = 10)
    public void testToggleListView() {
    	driver.navigate().refresh();
        assetManagementPage.clickListView();
        //Assert.assertTrue(assetManagementPage.isElementPresent(By.xpath("")), "List view toggle did not work correctly.");
    }

    @Test(priority = 12)
    public void testToggleGridView() {
    	driver.navigate().refresh();
        assetManagementPage.clickGridView();
        Assert.assertTrue(assetManagementPage.isElementPresent(By.xpath("")), "Grid view toggle did not work correctly.");
    
    }

    @Test(priority = 13)
    public void testNextPageButton() throws InterruptedException {
    	driver.navigate().refresh();
    	Thread.sleep(3000);
        assetManagementPage.clickNext();
        Assert.assertTrue(assetManagementPage.isElementPresent(By.xpath("")), "Next page button did not work correctly.");
    }

    @Test(priority = 14)
    public void testPreviousPageButton() throws InterruptedException {
    	driver.navigate().refresh();
    	Thread.sleep(3000);
        assetManagementPage.clickPrevious();
        Assert.assertTrue(assetManagementPage.isElementPresent(By.xpath("")), "Previous page button did not work correctly.");
        driver.navigate().refresh();
    }
	
	@AfterClass
	public void tearDown() {
		super.teardown();
	}
	
}

