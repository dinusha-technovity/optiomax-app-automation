package com.Optiomax.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.MyAssetsPage;

import org.openqa.selenium.By;

public class MyAssetsTest extends BasePage {

	private MyAssetsPage myAssetsPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		myAssetsPage = new MyAssetsPage(driver);
		myAssetsPage.login("ruvinya@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/users_asset_items");
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void testPageLoad() {
		Assert.assertTrue(myAssetsPage.isPageLoaded(), "The My Assets page did not load successfully.");
	}

	@Test(priority = 2)
	public void testMyAssetsCardsDisplay() {
		Assert.assertTrue(myAssetsPage.getMyAssetsCardCount()> 0, "The My assets cards are nt displayed.");
	}

	@Test(priority = 3)
	public void testSearchFunctionalityWithValidInputs() throws InterruptedException {
		myAssetsPage.searchMyAssets("");
		Thread.sleep(3000);
		Assert.assertTrue(myAssetsPage.isMyAssetsPresent(""), "The search functionality did not return the expected results.");
		driver.navigate().refresh();
	}
	
	@Test(priority = 4)
	public void testSearchFunctionalityWithPartialAssetsNames() throws InterruptedException {
		myAssetsPage.searchMyAssets("");
		Thread.sleep(3000);
		Assert.assertTrue(myAssetsPage.isMyAssetsPresent(""), "The search functionality did not return the expected results with partial assets names.");
		driver.navigate().refresh();
	}
	
	@Test(priority = 5)
	public void testErrorHandlingforNonExistentMyAssets() throws InterruptedException {
		myAssetsPage.searchMyAssets("nonExistentMyAssets");
		Thread.sleep(3000);
		Assert.assertTrue(myAssetsPage.isMyAssetsPresent(""), "The error handling for non-existenet my assets as expected.");
	}
	
	@Test(priority = 6)
	public void testToggleListView() throws InterruptedException {
		myAssetsPage.clickListView();
		Thread.sleep(3000);
		Assert.assertTrue(myAssetsPage.isMyAssetsPresent(""), "List view toggle did not work correctly.");
		driver.navigate().refresh();
	}
	
	@Test(priority = 7)
	public void testToggleGridView() throws InterruptedException {
		myAssetsPage.clickGridView();
		Thread.sleep(3000);
		Assert.assertTrue(myAssetsPage.isMyAssetsPresent(""), "Grid view toggle did not work correctly.");
		driver.navigate().refresh();
	}
	
	@Test(priority = 8)
	public void testExport() throws InterruptedException {
		myAssetsPage.clickExportCSV();
		Thread.sleep(3000);
		//Assert.assertTrue(isFileDownloaded("asset_details.csv"), "Export CSV functionality did not work correctly");
		driver.navigate().refresh();
	}
	
	@Test(priority = 9)
	public void testFilter() throws InterruptedException {
		myAssetsPage.clickFilter();
		Thread.sleep(3000);
		Assert.assertTrue(myAssetsPage.isElementPresent(By.xpath("//div[]contains(text(), 'Filtered Result')")), "Filter functionality did not work correctly.");
		driver.navigate().refresh();
	}

	@AfterClass
	public void tearDown() {
		super.teardown();
	}
	
}

