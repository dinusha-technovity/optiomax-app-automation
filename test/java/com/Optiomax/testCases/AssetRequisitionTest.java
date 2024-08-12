package com.Optiomax.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.AssetRequisitionPage;
import com.Optiomax.pageObjetcs.BasePage;

public class AssetRequisitionTest extends BasePage {

	private AssetRequisitionPage assetRequisitionPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		assetRequisitionPage = new AssetRequisitionPage(driver);
		assetRequisitionPage.login("chamoddushyantha2017@gmail.com", "UMwI4u3w");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/asset_requisitions");
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void testPageLoad() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(assetRequisitionPage.isPageLoaded(), "The asset requisition page did not load successfully.");
	}

	@Test(priority = 2)
	public void testAssetRequisitionCardsDisplay() {
		Assert.assertTrue(assetRequisitionPage.getAssetRequisitionCardCount() > 0,
				"The asset requisition cards are not displayed.");
	}

	@Test(priority = 3)
	public void testAddNewAssetRequisitionButton() throws InterruptedException {
		assetRequisitionPage.clickAddNewAssetRequisition();
		Thread.sleep(3000);
		// Verify that the new pop-up window appears
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]")).isDisplayed(),
				"The 'Add New Asset Requisition' popup did not appear.");
		assetRequisitionPage.clickCloseAssetRequisition();
	}

	@Test(priority = 4)
	public void testSearchFunctionalityWithValidInput() throws InterruptedException {
		assetRequisitionPage.searchAssetRequisition("ju23adjl");
		Thread.sleep(3000);
		Assert.assertTrue(assetRequisitionPage.isAssetRequisitionPresent("ju23adjl"),
				"The search functionality did not return the expected result.");
		driver.navigate().refresh();
	}

//	@Test(priority = 5)
//	public void testErrorHandlingForNonExistentAssetRequisitionID() {
//		assetRequisitionPage.searchAssetRequisition("nonExistingRequisitionID");
//		Assert.assertTrue(assetRequisitionPage.isNoResultsMessageDisplayed(),
//				"The error handling for non-existing asset requisition is not working as expected.");
//	}

	@Test(priority = 6)
	public void testSearchWithPartialNames() throws InterruptedException {
		assetRequisitionPage.searchAssetRequisition("zozbb");
		Thread.sleep(3000);
		Assert.assertTrue(assetRequisitionPage.isAssetRequisitionPresent("zozbbtw6"),
				"The search functionality did not return the expected reults with partial name.");
	}
	
	@AfterClass
	public void tearDown() {
		super.teardown();
	}
}
