package com.Optiomax.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.UserRolesPage;

public class UserRolesTest extends BasePage {
    
	UserRolesPage userRolesPage;
 
    @BeforeClass
    public void setUp() throws InterruptedException {
        userRolesPage = new UserRolesPage(driver);
		userRolesPage = PageFactory.initElements(driver, UserRolesPage.class);
		userRolesPage.login("ruvinya@gmail.com", "ruvinya1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/Roles");
		Thread.sleep(5000); 
    }

    @Test(priority = 1)
    public void testAddNewUserRoleButton() throws InterruptedException {
        userRolesPage.clickAddNewUserRole();
        Thread.sleep(3000);
        Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//h3[normalize-space()='Add New Role']")), "Add New User Role button did not work correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 2)
    public void testSearchFunctionality() throws InterruptedException {
        userRolesPage.enterSearchQuery("Super Admin");
        Thread.sleep(3000);
        Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div")), "Search functionality did not retrieve the correct user role.");
        driver.navigate().refresh();
    }

    @Test(priority = 3)
    public void testSearchNoResults() {
        userRolesPage.enterSearchQuery("Nonexistent User Role");
        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Search functionality did not handle no results correctly.");
        driver.navigate().refresh();
    }

    @Test(priority = 4)
    public void testExportCSV() {
        userRolesPage.clickExportCSV();
        // Add logic to verify CSV file download if possible
        //Assert.assertTrue(isFileDownloaded("user_roles.csv"), "Export CSV did not work correctly.");      
        driver.navigate().refresh();
    }

//    @Test(priority = 5)
//    public void testExportCSVWithoutPermissions() {
//        // Simulate lack of permissions and test export
//        userRolesPage.clickExportCSV();
//        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'Permission denied')]")), "Export CSV without permissions did not handle correctly.");
//        driver.navigate().refresh();
//    }

//    @Test(priority = 6)
//    public void testExportCSVWithError() {
//        // Simulate error during export and test handling
//        userRolesPage.clickExportCSV();
//        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'Unexpected error')]")), "Export CSV with an error was not handled correctly.");
//        
//        driver.navigate().refresh();
//    }

//    @Test(priority = 7)
//    public void testExportCSVWithoutData() {
//        // Simulate empty data and test export
//        userRolesPage.clickExportCSV();
//        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'No data to export')]")), "Export CSV without data was not handled correctly.");
//    
//        driver.navigate().refresh();
//    }

    @Test(priority = 8)
    public void testFilterValidCriteria() {
        userRolesPage.clickFilterButton();
        // Add logic to select valid filter criteria
        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'Filtered Result')]")), "Filter functionality with valid criteria did not work correctly.");
    
        driver.navigate().refresh();
    }

    @Test(priority = 9)
    public void testFilterInvalidCriteria() {
        userRolesPage.clickFilterButton();
        // Add logic to select invalid filter criteria
        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Filter functionality with invalid criteria did not handle correctly.");
       
        driver.navigate().refresh();
    }

    @Test(priority = 10)
    public void testFilterNonExistingData() {
        userRolesPage.clickFilterButton();
        // Add logic to filter non-existing data
        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("//div[contains(text(), 'No results found')]")), "Filter functionality with non-existing data did not handle correctly.");
    
        driver.navigate().refresh();
    }

    @Test(priority = 11)
    public void testToggleListView() {
        userRolesPage.toggleListView();
        Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]")), "List view toggle did not work correctly.");
    
        driver.navigate().refresh();
    }

    @Test(priority = 12)
    public void testToggleGridView() {
        userRolesPage.toggleGridView();
        Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]")), "Grid view toggle did not work correctly.");
    
        driver.navigate().refresh();
    }

    @Test(priority = 13)
    public void testNextPageButton() throws InterruptedException {
    	Thread.sleep(3000);
        userRolesPage.clickNextPage();
        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("")), "Next page button did not work correctly.");
    
        driver.navigate().refresh();
    }

    @Test(priority = 14)
    public void testPreviousPageButton() {
        userRolesPage.clickPreviousPage();
        //Assert.assertTrue(userRolesPage.isElementPresent(By.xpath("")), "Previous page button did not work correctly.");
    
        driver.navigate().refresh();
    }
    
//    private boolean isFileDownloaded(String fileName) {
//        // Implement file download verification logic
//        return true;
//    }
    
}


