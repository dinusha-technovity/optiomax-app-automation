package com.Optiomax.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.BasePage;
import com.Optiomax.pageObjetcs.UsersPage;

public class UsersTest extends BasePage {
    
	UsersPage usersPage;
 
    @BeforeClass
    public void setUp() throws InterruptedException {
        usersPage = new UsersPage(driver);
		usersPage = PageFactory.initElements(driver, UsersPage.class);
		usersPage.login("chamoddushyantha2017@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/users");
		Thread.sleep(5000); 
    }

    @Test(priority = 1)
    public void testAddNewUsersButton() {
        usersPage.clickAddNewUsers();
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]")), "Add New Users button did not work correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 2)
    public void testSearchFunctionality() throws InterruptedException {
        usersPage.enterSearchQuery("Ruvinya");
        Thread.sleep(3000);
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div")), "Search functionality did not retrieve the correct user role.");
        driver.navigate().refresh();
    }

    @Test(priority = 3)
    public void testSearchNoResults() {
        usersPage.enterSearchQuery("Nonexistent User");
        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Search functionality did not handle no results correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 4)
    public void testExportCSV() {
        usersPage.clickExportCSV();
        // Add logic to verify CSV file download if possible
        //Assert.assertTrue(isFileDownloaded("user_roles.csv"), "Export CSV did not work correctly.");      
        driver.navigate().refresh();
    }

//    @Test(priority = 5)
//    public void testExportCSVWithoutPermissions() {
//        // Simulate lack of permissions and test export
//        usersPage.clickExportCSV();
//        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'Permission denied')]")), "Export CSV without permissions did not handle correctly.");
//        driver.navigate().refresh();
//    }

//    @Test(priority = 6)
//    public void testExportCSVWithError() {
//        // Simulate error during export and test handling
//        usersPage.clickExportCSV();
//        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'Unexpected error')]")), "Export CSV with an error was not handled correctly.");
//        
//        driver.navigate().refresh();
//    }

//    @Test(priority = 7)
//    public void testExportCSVWithoutData() {
//        // Simulate empty data and test export
//        usersPage.clickExportCSV();
//        Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'No data to export')]")), "Export CSV without data was not handled correctly.");
//    
//        driver.navigate().refresh();
//    }

    @Test(priority = 8)
    public void testFilterValidCriteria() {
        usersPage.clickFilterButton();
        // Add logic to select valid filter criteria
        //Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'Filtered Result')]")), "Filter functionality with valid criteria did not work correctly.");
    
        driver.navigate().refresh();
    }

    @Test(priority = 9)
    public void testFilterInvalidCriteria() {
        usersPage.clickFilterButton();
        // Add logic to select invalid filter criteria
        //Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Filter functionality with invalid criteria did not handle correctly.");
       
        driver.navigate().refresh();
    }

    @Test(priority = 10)
    public void testFilterNonExistingData() {
        usersPage.clickFilterButton();
        // Add logic to filter non-existing data
        //Assert.assertTrue(usersPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Filter functionality with non-existing data did not handle correctly.");
    
        driver.navigate().refresh();
    }

    @Test(priority = 11)
    public void testToggleListView() {
        usersPage.toggleListView();
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]")), "List view toggle did not work correctly.");
    
        driver.navigate().refresh();
    }

    @Test(priority = 12)
    public void testToggleGridView() {
        usersPage.toggleGridView();
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]")), "Grid view toggle did not work correctly.");
    
        driver.navigate().refresh();
    }

    @Test(priority = 13)
    public void testNextPageButton() throws InterruptedException {
    	Thread.sleep(3000);
        usersPage.clickNextPage();
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[2]/nav/ul/li[3]/button")), "Next page button did not work correctly.");
    
        driver.navigate().refresh();
    }

    @Test(priority = 14)
    public void testPreviousPageButton() {
        usersPage.clickPreviousPage();
        Assert.assertTrue(usersPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[2]/nav/ul/li[2]/button")), "Previous page button did not work correctly.");
    
        driver.navigate().refresh();
    }
    
    @Test(priority=15)
    public void testPaginationButton() {
    	usersPage.clickNextPage();
    	usersPage.clickPreviousPage();
    	
    	Assert.assertTrue(usersPage.isElementPresent(By.xpath("")), "Pagination did not work properly");
    	driver.navigate().refresh();
    }

    // Helper methods
    private boolean isFileDownloaded(String fileName) {
        // Implement file download verification logic
        return true;
    }

    private boolean isResponsive() {
        // Implement responsiveness verification logic
        return true;
    }
    
}



