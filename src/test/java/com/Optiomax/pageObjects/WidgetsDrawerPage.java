package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WidgetsDrawerPage {

    private WebDriver driver;

    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    private By drawerIcon = By.xpath("/html/body/main/div/div/main/div/div/div[2]/button");
    private By analyticsCategory = By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/div/div[1]/div/p[1]");
    private By billingsCategory = By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/div/div[1]/div/p[2]");
    private By tenantCategory = By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/div/div[1]/div/p[3]");
    private By searchBar = By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/form/div/input");
    private By searchButton = By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/form/div/button");
    private By lineGraphWidget = By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/div/div[3]/div/div[1]");
    private By dataGrid = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div");

    public WidgetsDrawerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    public void clickDrawerIcon() {
        driver.findElement(drawerIcon).click();
    }

    public void clickAnalyticsCategory() {
        driver.findElement(analyticsCategory).click();
    }

    public void clickBillingsCategory() {
        driver.findElement(billingsCategory).click();
    }

    public void clickTenantCategory() {
        driver.findElement(tenantCategory).click();
    }

    public void search(String query) {
        driver.findElement(searchBar).sendKeys(query);
        driver.findElement(searchButton).click();
    }

    public void selectLineGraphWidget() {
        driver.findElement(lineGraphWidget).click();
    }

    public boolean isDataGridDisplayed() {
        return driver.findElement(dataGrid).isDisplayed();
    }
    
    public boolean isDrawerIconDisplayed() {
        return driver.findElement(drawerIcon).isDisplayed();
    }
}
