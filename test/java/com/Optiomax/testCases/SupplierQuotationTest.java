package com.Optiomax.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.SupplierQuotationPage;

import org.openqa.selenium.By;

public class SupplierQuotationTest extends BasePage {
    private SupplierQuotationPage supplierQuotationPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        super.setup();
        supplierQuotationPage = new SupplierQuotationPage(driver);
        supplierQuotationPage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/supplier_quotation");
		Thread.sleep(5000); 
    }

	@Test(priority = 1)
	public void testPageLoad() throws InterruptedException {
		Assert.assertTrue(supplierQuotationPage.isPageLoaded(), "The procurement staff page did not load successfully.");
	}

    @Test(priority = 2)
    public void testSupplierQuotationCardsDisplay() {
        Assert.assertTrue(supplierQuotationPage.getSupplierQuotationCardCount() > 0, "The Supplier Quotation cards are not displayed.");
    }

    @Test(priority = 3)
    public void testSearchFunctionalityWithValidProcurementID() throws InterruptedException {
    	supplierQuotationPage.searchSupplierQuotation("h99kmlin");
        Thread.sleep(3000);
        Assert.assertTrue(supplierQuotationPage.isSupplierQuotationPresent("h99kmlin"), "The search functionality did not return the expected result.");
        driver.navigate().refresh();
    }

    @Test(priority = 4)
    public void testErrorHandlingForNonExistentProcurementID() throws InterruptedException {
    	supplierQuotationPage.searchSupplierQuotation("hf3t64");
        Thread.sleep(3000);
        //Assert.assertTrue(supplierQuotationPage.isNoResultsMessageDisplayed()(), "The error handling for non-existent procurement id is not working as expected.");
        driver.navigate().refresh();
    }

    @Test(priority = 5)
    public void testSearchFunctionalityWithPartialProcurementID() throws InterruptedException {
    	supplierQuotationPage.searchSupplierQuotation("mlin");
        Thread.sleep(3000);
        Assert.assertTrue(supplierQuotationPage.isSupplierQuotationPresent("h99kmlin"), "The search functionality did not return the expected result with partial procurement ID.");
        driver.navigate().refresh();
    }

    @Test(priority = 6)
    public void testToggleGridView() throws InterruptedException {
    	supplierQuotationPage.toggleGridView();
        Thread.sleep(3000);
        Assert.assertTrue(supplierQuotationPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div")), "Grid view toggle did not work correctly.");
        driver.navigate().refresh();
    }
    
    @Test(priority = 7)
    public void testToggleListView() throws InterruptedException {
    	supplierQuotationPage.toggleListView();
        Thread.sleep(3000);
        Assert.assertTrue(supplierQuotationPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div")), "List view toggle did not work correctly.");
        driver.navigate().refresh();
    }
    
    @Test(priority = 8)
    public void testExportCSV() throws InterruptedException {
    	supplierQuotationPage.clickExportCSV();
        Thread.sleep(3000);
        // Add logic to verify CSV file download if possible
        //Assert.assertTrue(isFileDownloaded("staff.csv"), "Export CSV did not work correctly.");      
        driver.navigate().refresh();
    }
    
    @Test(priority = 9)
    public void testFilterValidCriteria() throws InterruptedException {
    	supplierQuotationPage.clickFilterButton();
        Thread.sleep(3000);
        // Add logic to select valid filter criteria
        //Assert.assertTrue(supplierQuotationPage.isElementPresent(By.xpath("//div[contains(text(), 'Filtered Result')]")), "Filter functionality with valid criteria did not work correctly.");
        driver.navigate().refresh();
    }

    @AfterClass
    public void tearDown() {
        super.teardown();
    }
    
}
