package com.Optiomax.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.WorkflowPage;

public class WorkflowTest extends BasePage {

	WorkflowPage workflowPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		super.setup();
		workflowPage = new WorkflowPage(driver);
		workflowPage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/workflow");
		Thread.sleep(5000); 
	}

	@Test(priority = 1)
	public void verifyAddNewWorkflow() throws InterruptedException {
		workflowPage.clickAddNewWorkflow();
        Thread.sleep(3000);
        
		// Add assertions to verify the new workflow creation
		WebElement newWorkflowForm = driver.findElement(By.xpath("//h3[normalize-space()='Add New Workflow']"));
		Assert.assertTrue(newWorkflowForm.isDisplayed(), "New workflow form is not displayed.");
		workflowPage.clickAddNewWorkflowCloseBtn();
        driver.navigate().refresh();
	}

	@Test(priority = 2)
	public void verifyUpdateWorkflow() throws InterruptedException {
        Thread.sleep(3000);
		workflowPage.clickUpdateWorkflow();
        Thread.sleep(3000);
        
		// Add assertions to verify the update workflow
		WebElement updateWorkflowForm = driver.findElement(By.xpath("//h3[normalize-space()='Update Existing Workflow']"));
		Assert.assertTrue(updateWorkflowForm.isDisplayed(), "Update workflow form is not displayed.");
		workflowPage.clickUpdateWorkflowCloseBtn();
		driver.navigate().refresh();
	}

	@Test(priority = 3)
	public void verifyDeleteWorkflow() throws InterruptedException {
		Thread.sleep(3000);
		workflowPage.clickDeleteWorkflow();
		Thread.sleep(3000);
		
		// Add assertions to verify the delete confirmation dialog
		WebElement deleteConfirmDialog = driver.findElement(By.xpath("//h3[normalize-space()='Remove Workflow']"));
		Assert.assertTrue(deleteConfirmDialog.isDisplayed(), "Delete confirmation dialog is not displayed.");
		workflowPage.clickDeleteWorkflowCloseBtn();
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void searchWorkflow() throws InterruptedException {
		workflowPage.searchWorkflow("User Management");
		Thread.sleep(3000);
		List<WebElement> items = workflowPage.getWorkflowItems();
		Assert.assertTrue(items.size() > 0, "No workflows found.");
		
		// Additional assertion to verify the search result matches the query
		for (WebElement item : items) {
			Assert.assertTrue(item.getText().contains("User Management"),
					"Workflow item does not match the search query.");
		}
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void searchNoResults() throws InterruptedException {
		workflowPage.searchWorkflow("NonExistentWorkflow");
		List<WebElement> items = workflowPage.getWorkflowItems();
		Thread.sleep(3000);

		WebElement message = driver.findElement(By.xpath("//p[normalize-space()='No data available']"));
		Assert.assertTrue(message.isDisplayed(), "No data available message is not displayed.");
	}

	@Test(priority = 6)
	public void exportCSV() {
		workflowPage.clickExportCSV();

		// Add code to handle file download and verification
//        String downloadPath = "C:\\Users\\Janodya\\Downloads";
//        File csvFile = new File(downloadPath + "\\workflows.csv");
//        Assert.assertTrue(csvFile.exists(), "CSV file was not downloaded.");
		
	}

	@Test(priority = 7)
	public void exportCSVError() {
		// Simulate unexpected error during CSV download
		workflowPage.clickExportCSV();

		// Add assertions to verify the error handling
//        WebElement errorMessage = driver.findElement(By.xpath(""));
//        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
	}

	@Test(priority = 8)
	public void exportCSVWithoutData() {
		// Ensure no workflows are available for export
		workflowPage.searchWorkflow("NonExistentWorkflow");
		workflowPage.clickExportCSV();

		// Add assertions to verify handling of export with no data
		WebElement noDataMessage = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/p"));
		Assert.assertTrue(noDataMessage.isDisplayed(), "No data message is not displayed.");

		driver.navigate().refresh();
	}

	@Test(priority = 9)
	public void toggleGridView() {
		workflowPage.clickGridView();

		// Add assertions to verify grid view behavior
		WebElement gridViewActive = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div"));
		Assert.assertTrue(gridViewActive.isDisplayed(), "Grid view is not active.");

		driver.navigate().refresh();
	}

	@Test(priority = 10)
	public void toggleListView() {
		workflowPage.clickListView();

		// Add assertions to verify list view behavior
		WebElement listViewActive = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]"));
		Assert.assertTrue(listViewActive.isDisplayed(), "List view is not active.");

		driver.navigate().refresh();
	}

	@Test(priority = 11)
	public void verifyListViewDetails() {
		workflowPage.clickListView();
		List<WebElement> items = workflowPage.getWorkflowItems();
		for (WebElement item : items) {
			WebElement title = item
					.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/table/thead/tr"));
			Assert.assertTrue(title.isDisplayed(), "Title is not displayed.");
		}
	}

//	@Test(priority = 12)
//	public void verifyResponsiveDesign() {
//
//		// Define different screen dimensions for responsive testing
//		Dimension[] dimensions = { new Dimension(1920, 1080), // Desktop
//				new Dimension(1366, 768), // Laptop
//				new Dimension(768, 1024), // Tablet
//				new Dimension(375, 667) // Mobile
//		};
//
//		for (Dimension dimension : dimensions) {
//			driver.manage().window().setSize(dimension);
//			// Add a wait to allow page to render
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//
//		}
//	}	
	
	@AfterClass
	public void tearDown() {
		super.teardown();
	}
}



