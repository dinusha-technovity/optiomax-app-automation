package com.Optiomax.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.ProcurementInitiatePage;

public class ProcurementInitiateTest extends BasePage {

	private ProcurementInitiatePage procurementInitiatePage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		procurementInitiatePage = new ProcurementInitiatePage(driver);
		procurementInitiatePage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/procurement_initiate");
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void testPageLoad() throws InterruptedException {
		Assert.assertTrue(procurementInitiatePage.isPageLoaded(), "The procurement initiate page did not load successfully.");
	}

	@Test(priority = 2)
	public void testProcurementInitiateCardsDisplay() throws InterruptedException {
		Assert.assertTrue(procurementInitiatePage.getProcurementInitiateCardCount() > 0,
				"The procurement initiate cards are not displayed.");
	}

	@Test(priority = 3)
	public void testAddNewProcurementInitiateButton() throws InterruptedException {
		procurementInitiatePage.clickAddNewProcurementInitiate();
		Thread.sleep(3000);
		// Verify that the new pop-up window appears
		Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Add New Procurement Initiate']")).isDisplayed(),
				"The 'Add New Procurement Initiate' popup did not appear.");
		procurementInitiatePage.clickCloseProcurementInitiate();
	}

	@Test(priority = 4)
	public void testSearchFunctionalityWithValidInput() throws InterruptedException {
		procurementInitiatePage.searchProcurementInitiate("h99kmlin"); // Enter an existing procurement ID
		Thread.sleep(3000);
		Assert.assertTrue(procurementInitiatePage.isProcurementInitiatePresent("h99kmlin"),// Enter an existing procurement partial ID
				"The search functionality did not return the expected result.");
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void testErrorHandlingForNonExistentProcurementID() throws InterruptedException {
		procurementInitiatePage.searchProcurementInitiate("nonExistingProcurementID");
		Thread.sleep(3000);
//		Assert.assertTrue(procurementInitiatePage.isNoResultsMessageDisplayed(),
//				"The error handling for non-existing procurement ID is not working as expected.");
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	public void testSearchWithPartialNames() throws InterruptedException {
		procurementInitiatePage.searchProcurementInitiate("mlin"); // Enter an existing procurement partial ID
		Thread.sleep(3000);
		Assert.assertTrue(procurementInitiatePage.isProcurementInitiatePresent("h99kmlin"),// Enter an existing procurement partial ID
				"The search functionality did not return the expected reults with partial procurement ID.");
		driver.navigate().refresh();
		Thread.sleep(3000);
	}
	
    @Test(priority = 7)
    public void testToggleGridView() throws InterruptedException {
    	procurementInitiatePage.toggleGridView();
        Thread.sleep(3000);
        Assert.assertTrue(procurementInitiatePage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div")), "Grid view toggle did not work correctly.");
        driver.navigate().refresh();
        Thread.sleep(3000);
    }
    
    @Test(priority = 7)
    public void testToggleListView() throws InterruptedException {
    	procurementInitiatePage.toggleListView();
        Thread.sleep(3000);
        Assert.assertTrue(procurementInitiatePage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]")), "List view toggle did not work correctly.");
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @Test(priority = 8)
    public void testNextPageButton() throws InterruptedException {
    	Thread.sleep(3000);
    	procurementInitiatePage.clickNextPage();
        Thread.sleep(3000);
        //Assert.assertTrue(assetRequisitionPage.isElementPresent(By.xpath("")), "Next page button did not work correctly.");
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @Test(priority = 9)
    public void testPreviousPageButton() throws InterruptedException {
    	procurementInitiatePage.clickPreviousPage();
        Thread.sleep(3000);
        //Assert.assertTrue(assetRequisitionPage.isElementPresent(By.xpath("")), "Previous page button did not work correctly.");
        driver.navigate().refresh();
    }
	
	@AfterClass
	public void tearDown() {
		super.teardown();
	}
}
