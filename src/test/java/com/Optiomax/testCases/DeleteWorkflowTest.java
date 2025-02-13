package com.Optiomax.testCases;

import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.DeleteWorkflowPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DeleteWorkflowTest extends BasePage {
	DeleteWorkflowPage deleteWorkflowPage;

	@BeforeClass
	public void setUpTest() throws InterruptedException {
		deleteWorkflowPage = new DeleteWorkflowPage(driver);
		deleteWorkflowPage.login("sithum@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/workflow");
		Thread.sleep(5000);
	}

//    @Test(priority = 6)
//    public void deleteWorkflowWithCorrectName() throws InterruptedException {
//        deleteWorkflowPage.clickDeleteIcon();
//        Thread.sleep(3000);
//        deleteWorkflowPage.enterWorkflowName("Test Workflow 02");
//        deleteWorkflowPage.clickDeleteButton();
//        
////        String successMessage = driver.findElement(By.xpath("")).getText();
////        Assert.assertTrue(successMessage.contains(""));
//        
//        driver.navigate().refresh();
//    }    

	@Test(priority = 2)
	public void deleteWorkflowWithUnmatchedName() throws InterruptedException {
		deleteWorkflowPage.clickDeleteIcon();
		Thread.sleep(3000);
		deleteWorkflowPage.enterWorkflowName("Incorrect Workflow");
		deleteWorkflowPage.clickDeleteButton();

		// Add assertions to verify workflow is not deleted
		String errorMessage = driver.findElement(By.xpath("//div[@class='text-sm text-red-500']")).getText();
		Assert.assertTrue(errorMessage.contains("Value does not match"));

		deleteWorkflowPage.clickCloseButton();
	}

	@Test(priority = 3)
	public void deleteWorkflowWithoutName() throws InterruptedException {
		deleteWorkflowPage.clickDeleteIcon();
		Thread.sleep(3000);
		deleteWorkflowPage.clickDeleteButton();
		deleteWorkflowPage.clickDeleteButton();

		// Add assertions to verify error or workflow is not deleted
		String errorMessage = driver.findElement(By.xpath("//div[@class='text-sm text-red-500']")).getText();
		Assert.assertTrue(errorMessage.contains("Please enter the workflow name"));

		deleteWorkflowPage.clickCloseButton();
	}

	@Test(priority = 4)
	public void deleteWorkflowAndCancel() throws InterruptedException {
		deleteWorkflowPage.clickDeleteIcon();
		Thread.sleep(3000);
		// Add assertions to verify workflow is not deleted
//        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed();
//        Assert.assertFalse(isPopupDisplayed);

		deleteWorkflowPage.clickCloseButton();

	}

	@Test(priority = 5)
	public void closeDialogAfterCorrectName() throws InterruptedException {
		deleteWorkflowPage.clickDeleteIcon();
		Thread.sleep(3000);
		deleteWorkflowPage.enterWorkflowName("Test Workflow 02");
		deleteWorkflowPage.clickCloseButton();

		// Add assertions to verify dialog behavior
//        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed(); 
//        Assert.assertFalse(isPopupDisplayed);  
	}

	@Test(priority = 6)
	public void closeDialogAfterIncorrectName() throws InterruptedException {
		deleteWorkflowPage.clickDeleteIcon();
		Thread.sleep(3000);
		deleteWorkflowPage.enterWorkflowName("Incorrect Workflow");
		deleteWorkflowPage.clickCloseButton();

		Thread.sleep(3000);

		// Add assertions to verify dialog behavior
//        boolean isPopupDisplayed = driver.findElement(By.xpath("")).isDisplayed(); 
//        Assert.assertFalse(isPopupDisplayed);

		Thread.sleep(3000);
	}

	@AfterClass
	public void tearDownTest() {
		driver.navigate().refresh();
		driver.quit();
	}
}
