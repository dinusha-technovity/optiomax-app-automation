package com.Optiomax.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.UsersPage;

public class UsersTest extends BasePage {
    
	UsersPage usersPage;
 
    @BeforeClass
    public void setUp() throws InterruptedException {
        usersPage = new UsersPage(driver);
		usersPage = PageFactory.initElements(driver, UsersPage.class);
		usersPage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/users");
		Thread.sleep(5000); 
    }

    @Test(priority = 1)
    public void testAddNewUsersButton() throws InterruptedException {
        usersPage.clickAddNewUsers();
        Thread.sleep(3000);
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//h3[normalize-space()='Add New User']")), "Add New Users button did not work correctly.");
        usersPage.clickAddNewUsersClose();
        driver.navigate().refresh();
    }

    @Test(priority = 2)
    public void testSearchFunctionality() throws InterruptedException {
        usersPage.enterSearchQuery("sithum madawa");
        Thread.sleep(3000);
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//h5[normalize-space()='sithum madawa']")), "Search functionality did not retrieve the correct users.");
        driver.navigate().refresh();
    }
    
    @Test(priority = 3)
    public void testPartialSearchFunctionality() throws InterruptedException {
    	usersPage.enterSearchQuery("madawa");
        Thread.sleep(3000);
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//h5[normalize-space()='sithum madawa']")), "Partial search functionality did not retrieve the correct users.");
        driver.navigate().refresh();
    }

    @Test(priority = 4)
    public void testSearchNoResults() throws InterruptedException {
        usersPage.enterSearchQuery("Nonexistent User");
        Thread.sleep(3000);
        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Search functionality did not handle no results correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 5)
    public void testExportCSV() throws InterruptedException {
        usersPage.clickExportCSV();
        Thread.sleep(3000);
        // Add logic to verify CSV file download if possible
        //Assert.assertTrue(isFileDownloaded("user_roles.csv"), "Export CSV did not work correctly.");      
        driver.navigate().refresh();
    }

//    @Test(priority = 6)
//    public void testExportCSVWithoutPermissions() throws InterruptedException {
//        // Simulate lack of permissions and test export
//        usersPage.clickExportCSV();
//        Thread.sleep(3000);
//        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'Permission denied')]")), "Export CSV without permissions did not handle correctly.");
//        driver.navigate().refresh();
//    }

//    @Test(priority = 7)
//    public void testExportCSVWithError() throws InterruptedException {
//        // Simulate error during export and test handling
//        usersPage.clickExportCSV();
//        Thread.sleep(3000);
//        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'Unexpected error')]")), "Export CSV with an error was not handled correctly."); 
//        driver.navigate().refresh();
//    }

//    @Test(priority = 8)
//    public void testExportCSVWithoutData() throws InterruptedException {
//        // Simulate empty data and test export
//        usersPage.clickExportCSV();
//        Thread.sleep(3000);
//        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'No data to export')]")), "Export CSV without data was not handled correctly.");
//        driver.navigate().refresh();
//    }

    @Test(priority = 9)
    public void testFilterValidCriteria() throws InterruptedException {
        usersPage.clickFilterButton();
        Thread.sleep(3000);
        // Add logic to select valid filter criteria
        //Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'Filtered Result')]")), "Filter functionality with valid criteria did not work correctly.");
        driver.navigate().refresh();
    }

//    @Test(priority = 10)
//    public void testFilterInvalidCriteria() throws InterruptedException {
//        usersPage.clickFilterButton();
//        Thread.sleep(3000);
//        // Add logic to select invalid filter criteria
//        //Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Filter functionality with invalid criteria did not handle correctly.");
//        driver.navigate().refresh();
//    }

    @Test(priority = 11)
    public void testFilterNonExistingData() throws InterruptedException {
        usersPage.clickFilterButton();
        Thread.sleep(3000);
        // Add logic to filter non-existing data
        //Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Filter functionality with non-existing data did not handle correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 12)
    public void testToggleListView() throws InterruptedException {
        usersPage.toggleListView();
        Thread.sleep(3000);
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]")), "List view toggle did not work correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 13)
    public void testToggleGridView() throws InterruptedException {
        usersPage.toggleGridView();
        Thread.sleep(3000);
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]")), "Grid view toggle did not work correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 14)
    public void testNextPageButton() throws InterruptedException {
    	Thread.sleep(3000);
        usersPage.clickNextPage();
        Thread.sleep(3000);
        //Assert.assertTrue(usersPage.isElementPresent(By.xpath("")), "Next page button did not work correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 15)
    public void testPreviousPageButton() throws InterruptedException {
        usersPage.clickPreviousPage();
        Thread.sleep(3000);
        //Assert.assertTrue(usersPage.isElementPresent(By.xpath("")), "Previous page button did not work correctly.");
        driver.navigate().refresh();
    }

//    private boolean isFileDownloaded(String fileName) {
//        // Implement file download verification logic
//        return true;
//    }
    
}



