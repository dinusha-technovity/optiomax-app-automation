package com.Optiomax.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.SidebarNavigationPage;

public class SidebarNavigationTest extends BasePage {

    SidebarNavigationPage sidebarNavigationPage;
    
    @BeforeClass
    public void setUp() throws InterruptedException {
        super.setup();
        sidebarNavigationPage = new SidebarNavigationPage(driver);
        sidebarNavigationPage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);	

    }

    @Test(priority = 1)
    public void testClickUserManagement() throws InterruptedException {
    	sidebarNavigationPage.clickExpand();
        Thread.sleep(3000);
        sidebarNavigationPage.clickUserManagement();
        driver.navigate().refresh();
        Thread.sleep(3000);
    }
    
    @Test(priority = 2)
    public void testClickRole() throws InterruptedException {
    	sidebarNavigationPage.clickExpand();
    	sidebarNavigationPage.clickUserManagement();
        sidebarNavigationPage.clickRole();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("Roles"), "Role URL validation failed");
        driver.navigate().refresh();
        Thread.sleep(3000);
        
    }
    
    @Test(priority = 3)
    public void testClickUsers() throws InterruptedException {
    	sidebarNavigationPage.clickExpand();
    	sidebarNavigationPage.clickUserManagement();
        sidebarNavigationPage.clickUsers();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("users"), "Users URL validation failed");
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void testClickConfig() throws InterruptedException {
    	sidebarNavigationPage.clickExpand();
        sidebarNavigationPage.clickConfig();
        driver.navigate().refresh();
        Thread.sleep(3000);
    }
    
    @Test(priority = 5)
    public void testClickOrganization() throws InterruptedException {
    	sidebarNavigationPage.clickExpand();
    	sidebarNavigationPage.clickConfig();
        sidebarNavigationPage.clickOrganization();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("organization"), "Organization URL validation failed");
        driver.navigate().refresh();
        Thread.sleep(3000);
    }
    
    @Test(priority = 6)
    public void testClickWorkflow() throws InterruptedException {
    	sidebarNavigationPage.clickExpand();
    	sidebarNavigationPage.clickConfig();
        sidebarNavigationPage.clickWorkflow();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("workflow"), "Workflow URL validation failed");
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @Test(priority = 7)
    public void testClickProcurementManagement() throws InterruptedException {
    	sidebarNavigationPage.clickExpand();
        sidebarNavigationPage.clickProcurementManagement();
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @Test(priority = 8)
    public void testClickAssetRequisitions() throws InterruptedException {
    	sidebarNavigationPage.clickExpand();
    	sidebarNavigationPage.clickProcurementManagement();
        sidebarNavigationPage.clickAssetRequisitions();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("asset_requisitions"), "Asset Requisitions URL validation failed.");
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @Test(priority = 9)
    public void testClickProcurementInitiate() throws InterruptedException {
    	sidebarNavigationPage.clickExpand();
    	sidebarNavigationPage.clickProcurementManagement();
        sidebarNavigationPage.clickProcurementInitiate();
    	Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("procurement_initiate"), "Procurement Initiate URL validation failed.");
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @Test(priority = 10)
    public void testClickProcurementStaff() throws InterruptedException {
    	sidebarNavigationPage.clickExpand();
    	sidebarNavigationPage.clickProcurementManagement();
        sidebarNavigationPage.clickProcurementStaff();
    	Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("staff"), "Procurement Staff URL validation failed.");
        driver.navigate().refresh();
    	Thread.sleep(3000);
    }

    @Test(priority = 11)
    public void testClickSupplier() throws InterruptedException {
    	sidebarNavigationPage.clickExpand();
    	sidebarNavigationPage.clickProcurementManagement();
        sidebarNavigationPage.clickSupplier();
    	Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("supplier"), "Supplier URL validation failed.");
        driver.navigate().refresh();
    	Thread.sleep(3000);
    }

//    @Test(priority = 12)
//    public void testClickSupplierQuotation() throws InterruptedException {
//    	sidebarNavigationPage.clickExpand();
//    	Thread.sleep(3000);
//    	sidebarNavigationPage.clickProcurementManagement();
//        sidebarNavigationPage.clickSupplierQuotation();
//    	Thread.sleep(3000);
//        //Assert.assertTrue(driver.getCurrentUrl().contains("supplier_quotation"), "Supplier Quotation URL validation failed.");
//        driver.navigate().refresh();
//    	Thread.sleep(3000);
//    }

//    @Test(priority = 13)
//    public void testClickAssetsManagement() throws InterruptedException {
//    	sidebarNavigationPage.clickExpand();
//    	Thread.sleep(3000);
//    	sidebarNavigationPage.clickProcurementManagement();
//        sidebarNavigationPage.clickAssetsManagement();
//    	Thread.sleep(3000);
//        //Assert.assertTrue(driver.getCurrentUrl().contains("assets_management"), "Assets Management URL validation failed.");
//        driver.navigate().refresh();
//    	Thread.sleep(3000);
//    }
    
}

