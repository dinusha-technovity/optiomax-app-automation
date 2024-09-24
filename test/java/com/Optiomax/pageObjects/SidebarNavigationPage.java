package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidebarNavigationPage {

    WebDriver driver;
    
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By rememberMeCheckbox = By.id("remember");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    // Sidebar Elements
    private By dashboard = By.xpath("/html/body/main/div/div/aside/div/ul/li[1]/a");
    private By expand = By.xpath("/html/body/main/div/div/aside/div/button");
    
    private By userManagement = By.xpath("/html/body/main/div/div/aside/div/ul/li[2]/a");
    private By role = By.xpath("/html/body/main/div/div/aside/div/ul/li[2]/ul[2]/li[1]/a");
    private By users = By.xpath("/html/body/main/div/div/aside/div/ul/li[2]/ul[2]/li[2]/a");
    
    private By config = By.xpath("/html/body/main/div/div/aside/div/ul/li[3]/a");
    private By organization = By.xpath("/html/body/main/div/div/aside/div/ul/li[3]/ul[2]/li[1]/a");
    private By workflow = By.xpath("/html/body/main/div/div/aside/div/ul/li[3]/ul[2]/li[2]/a");
    
    private By procurementManagement = By.xpath("/html/body/main/div/div/aside/div/ul/li[4]/a");
    private By assetRequisitions = By.xpath("/html/body/main/div/div/aside/div/ul/li[4]/ul[2]/li[1]/a");
    private By procurementInitiate = By.xpath("/html/body/main/div/div/aside/div/ul/li[4]/ul[2]/li[2]/a");
    private By procurementStaff = By.xpath("/html/body/main/div/div/aside/div/ul/li[4]/ul[2]/li[3]/a");
    private By supplier = By.xpath("/html/body/main/div/div/aside/div/ul/li[4]/ul[2]/li[4]/a");
    private By supplierQuotation = By.xpath("/html/body/main/div/div/aside/div/ul/li[4]/ul[2]/li[5]/a");
    private By assetsManagement = By.xpath("/html/body/main/div/div/aside/div/ul/li[4]/ul[2]/li[6]/a");

    public SidebarNavigationPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }
    
    public void clickDashboard() {
    	driver.findElement(dashboard).click();
    }
    
    public void clickExpand() {
    	driver.findElement(expand).click();
    }
    
    public void clickUserManagement() {
        driver.findElement(userManagement).click();
    }
    
    public void clickRole() {
    	driver.findElement(role).click();
    }
    
    public void clickUsers() {
    	driver.findElement(users).click();
    }

    public void clickConfig() {
        driver.findElement(config).click();
    }
    
    public void clickOrganization() {
        driver.findElement(organization).click();
    }
    
    public void clickWorkflow() {
        driver.findElement(workflow).click();
    }
    
    public void clickProcurementManagement() {
        driver.findElement(procurementManagement).click();
    }

    public void clickAssetRequisitions() {
        driver.findElement(assetRequisitions).click();
    }

    public void clickProcurementInitiate() {
        driver.findElement(procurementInitiate).click();
    }

    public void clickProcurementStaff() {
        driver.findElement(procurementStaff).click();
    }

    public void clickSupplier() {
        driver.findElement(supplier).click();
    }

    public void clickSupplierQuotation() {
        driver.findElement(supplierQuotation).click();
    }

    public void clickAssetsManagement() {
        driver.findElement(assetsManagement).click();
    }
    
}
