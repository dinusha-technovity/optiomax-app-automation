package com.Optiomax.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.BasePage;
import com.Optiomax.pageObjetcs.WidgetsDrawerPage;


public class WidgetsDrawerTest extends BasePage {

    private WidgetsDrawerPage widgetsDrawerPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        super.setup();
        widgetsDrawerPage = PageFactory.initElements(driver, WidgetsDrawerPage.class);
        widgetsDrawerPage.login("chamoddushyantha2017@gmail.com", "UMwI4u3w");
        Thread.sleep(5000);

    }
 
    @Test(priority = 1)
    public void verifyWidgetsDrawerIcon() {
        Assert.assertTrue(widgetsDrawerPage.isDrawerIconDisplayed(), "Widgets drawer icon is not displayed");
    }

    @Test(priority = 2)
    public void verifyWidgetsButtonFunctionality() {
        widgetsDrawerPage.clickDrawerIcon();
    }

//    @Test(priority = 3)
//    public void verifyNavigationToAnalyticsSection() throws InterruptedException {
//        driver.navigate().refresh();
//        widgetsDrawerPage.clickDrawerIcon();
//        Thread.sleep(5000);
//        widgetsDrawerPage.clickAnalyticsCategory();
//    }
//
//    @Test(priority = 4)
//    public void verifyNavigationToBillingsSection() throws InterruptedException {
//        driver.navigate().refresh();
//        widgetsDrawerPage.clickDrawerIcon();
//        Thread.sleep(5000);
//        widgetsDrawerPage.clickBillingsCategory();
//    }
//
//    @Test(priority = 5)
//    public void verifyNavigationToTenantSection() throws InterruptedException {
//        driver.navigate().refresh();
//        widgetsDrawerPage.clickDrawerIcon();
//        Thread.sleep(5000);
//        widgetsDrawerPage.clickTenantCategory();
//    }

    @Test(priority = 6)
    public void verifySearchBarFunctionality() {
        driver.navigate().refresh();
        widgetsDrawerPage.clickDrawerIcon();
        widgetsDrawerPage.search("Analytics");
    }

    @Test(priority = 7)
    public void verifySearchWithInvalidQuery() {
        driver.navigate().refresh();
        widgetsDrawerPage.clickDrawerIcon();
        widgetsDrawerPage.search("Invalid Query");
    }

    @Test(priority = 8)
    public void verifySearchingWithinSpecificCategory() {
        driver.navigate().refresh();
        widgetsDrawerPage.clickDrawerIcon();
        widgetsDrawerPage.clickAnalyticsCategory();
        widgetsDrawerPage.search("Specific Query");
    }

    @Test(priority = 9)
    public void verifySelectionOfNonExistentWidget() {
        driver.navigate().refresh();
        widgetsDrawerPage.clickDrawerIcon();
        widgetsDrawerPage.search("Non-Existent Widget");
    }

    @Test(priority = 10)
    public void verifyExcessiveSearchInput() throws InterruptedException {
        driver.navigate().refresh();
        widgetsDrawerPage.clickDrawerIcon();
        widgetsDrawerPage.search("This is a very long search query that exceeds the limit");
    }

    @Test(priority = 11)
    public void verifyWidgetFunctionalityAfterSelection() throws InterruptedException {
        driver.navigate().refresh();
        widgetsDrawerPage.clickDrawerIcon();
        widgetsDrawerPage.clickAnalyticsCategory();
        widgetsDrawerPage.selectLineGraphWidget();
        //Assert.assertTrue(widgetsDrawerPage.isDataGridDisplayed(), "Error message not displayed for excessive search input");
    }
    
}

