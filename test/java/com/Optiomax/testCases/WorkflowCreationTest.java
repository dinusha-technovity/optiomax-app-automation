package com.Optiomax.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.WorkflowCreationPage;

public class WorkflowCreationTest extends BasePage {
 
	WorkflowCreationPage workflowCreationPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		workflowCreationPage = new WorkflowCreationPage(driver);
		workflowCreationPage = PageFactory.initElements(driver, WorkflowCreationPage.class);
		workflowCreationPage.login("chamoddushyantha2017@gmail.com", "chamod1234");
		Thread.sleep(5000);
		driver.get("http://app.optiomax.com/dashboard/workflow");
		Thread.sleep(5000); 
	}

	@Test(priority = 1)
	public void verifyAddNewWorkflow() throws InterruptedException {
		workflowCreationPage.clickNewWorkflow();

		// Add assertions to verify the new workflow creation
		WebElement newWorkflowForm = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]"));
		Assert.assertTrue(newWorkflowForm.isDisplayed(), "New workflow form is not displayed.");

		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void verifyAddNewWorkflowAdd() {
		workflowCreationPage.clickAddWorkflowButton();
		workflowCreationPage.clickNewWorkflow();
		
		// Add assertions to verify the new workflow form 
		WebElement newWorkflowForm = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]"));
		Assert.assertTrue(newWorkflowForm.isDisplayed(), "New Workflow form is not displayed.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test(priority = 3)
	public void verifyWorkflowForm() {
		workflowCreationPage.clickAddWorkflowButton();
		workflowCreationPage.clickApproveForm();
		
		// Add assertions to verify the new workflow
		WebElement newWorkflowForm = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[3]"));
		Assert.assertTrue(newWorkflowForm.isDisplayed(), "New Workflow form is not displayed.");
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4)
	public void verifyWorkflowfunctionality() {
		workflowCreationPage.clickAddCondition();
		workflowCreationPage.clickApproveForm();
		
		// Add assertions to verify workflow condition
		WebElement newWorkflowForm = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]"));
		Assert.assertTrue(newWorkflowForm.isDisplayed(), "Workflow condition is not displayed");
		
	}
	
}
