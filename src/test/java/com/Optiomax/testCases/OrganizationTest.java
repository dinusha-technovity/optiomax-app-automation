package com.Optiomax.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.OrganizationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Dimension;


public class OrganizationTest extends BasePage {

    private OrganizationPage organizationPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        super.setup();
        organizationPage = PageFactory.initElements(driver, OrganizationPage.class);
        organizationPage.login("sithum@gmail.com", "chamod1234");
        Thread.sleep(5000);
        driver.get("http://app.optiomax.com/dashboard/organization");
        Thread.sleep(5000);
    }

//    @Test(priority = 1)
//    public void testExpandCollapseNodes() {
//        // Locate all nodes and check initial state (collapsed)
//        List<WebElement> nodes = driver.findElements(By.cssSelector(".node-class")); 
//        for (WebElement node : nodes) {
//            Assert.assertFalse(node.isDisplayed(), "Node should be collapsed initially");
//        }
//
//        // Expand nodes
//        organizationPage.clickExpandCollapseButton();
//        for (WebElement node : nodes) {
//            Assert.assertTrue(node.isDisplayed(), "Node should be expanded");
//        }
//
//        // Collapse nodes again
//        organizationPage.clickExpandCollapseButton();
//        for (WebElement node : nodes) {
//            Assert.assertFalse(node.isDisplayed(), "Node should be collapsed");
//        }
//    }

    @Test(priority = 2)
    public void testAddOrganizationButtonVisibleAndFunctional() {
        Assert.assertTrue(organizationPage.isAddOrganizationButtonVisible(), "Add Organization button is not visible");
        organizationPage.clickAddOrganizationButton();

        WebElement form = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]")); 
        Assert.assertTrue(form.isDisplayed(), "Add Organization form is not displayed");
        
        driver.navigate().refresh();
    }

    @Test(priority = 3)
    public void testUpdateOrganizationButtonVisibleAndFunctional() throws InterruptedException {
    	
    	Thread.sleep(5000);
    	
        Assert.assertTrue(organizationPage.isUpdateOrganizationButtonVisible(), "Update Organization button is not visible");
        organizationPage.clickUpdateOrganizationButton();

        WebElement form = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]")); 
        Assert.assertTrue(form.isDisplayed(), "Update Organization form is not displayed");
        
        driver.navigate().refresh();
    }

    @Test(priority = 4)
    public void testDeleteOrganizationButtonVisibleAndFunctional() throws InterruptedException {
    	
    	Thread.sleep(5000);
    	
    	organizationPage.clickExpandCollapseButton1();
    	organizationPage.clickExpandCollapseButton2();
        Assert.assertTrue(organizationPage.isDeleteOrganizationButtonVisible(), "Delete Organization button is not visible");
        //organizationPage.clickDeleteOrganizationButton();

        // Verify that delete organization functionality is working (this might involve checking if the node is removed)
//        WebElement confirmation = driver.findElement(By.xpath("")); 
//        Assert.assertTrue(confirmation.isDisplayed(), "Delete Organization confirmation is not displayed");
        
        driver.navigate().refresh();
    }

    @Test(priority = 5)
    public void testResponsiveness() throws InterruptedException {
    	
    	Thread.sleep(5000);
    	
        // Test different screen sizes
        Dimension[] dimensions = {
            new Dimension(1200, 800), // Desktop
            new Dimension(768, 1024), // Tablet
            new Dimension(375, 667)   // Mobile
        };

        for (Dimension dimension : dimensions) {
            driver.manage().window().setSize(dimension);
            // Add assertions to verify that the organization chart is displayed correctly
            WebElement chart = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div/ul/li")); 
            Assert.assertTrue(chart.isDisplayed(), "Organization chart is not displayed correctly for " + dimension.toString());
        }

        // Reset to original size
        driver.manage().window().maximize();
    }
	
}
