package com.Optiomax.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.AppsMenuPage;
import com.Optiomax.pageObjetcs.BasePage;

import java.util.Arrays;
import java.util.List;

public class AppsMenuTest extends BasePage {

    private WebDriver driver;
    private AppsMenuPage appsMenuPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        setup();
        this.driver = super.driver;
        appsMenuPage = new AppsMenuPage(driver);
        appsMenuPage.login("chamoddushyantha2017@gmail.com", "chamod1234");
        Thread.sleep(5000);
    }
 
    @Test(priority = 1)
    public void testMenuItemClickableAndHighlighted() {
        // Implement the test for menu item clickability and highlight
    }

    @Test(priority = 2)
    public void testMenuItemsOrder() throws InterruptedException {
        List<String> actualOrder = appsMenuPage.getMenuItems();
        Thread.sleep(5000);
        List<String> expectedOrder = Arrays.asList("Sales", "Users", "Inbox", "Profile", "Settings", "Products",
                "Pricing", "Billing", "Logout");
        Thread.sleep(5000);
        Assert.assertEquals(actualOrder, expectedOrder, "Menu items are not ordered correctly");
    }

    @Test(priority = 3)
    public void testMenuItemsIcons() {
        // Implement the test for menu item icons
    }

    @Test(priority = 4)
    public void testSalesPageNavigation() {
        appsMenuPage.clickSalesMenuItem();
        // Add assertion to verify the navigation
    }

    @Test(priority = 5)
    public void testUsersPageNavigation() {
        appsMenuPage.clickUsersMenuItem();
        // Add assertion to verify the navigation
    }

    @Test(priority = 6)
    public void testInboxPageNavigation() {
        appsMenuPage.clickInboxMenuItem();
        // Add assertion to verify the navigation
    }

    // Implement other page navigation tests similarly

    @Test(priority = 7)
    public void testMenuResponsiveness() {
        // Implement the test for menu responsiveness
    }

    @Test(priority = 8)
    public void testQuickMenuItemClicks() {
        // Implement the test for quick menu item clicks
    }
}
