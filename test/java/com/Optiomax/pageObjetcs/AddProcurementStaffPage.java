package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddProcurementStaffPage extends BasePage {
    private WebDriver driver;

    public AddProcurementStaffPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");
    
    private By usersDropdown = By.id("");
    private By assetClassesDropdown = By.id("");
    private By submitButton = By.id("");
    private By closeButton = By.cssSelector("");
    private By errorMessage = By.cssSelector("");
    private By successMessage = By.cssSelector("");
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    public void selectUser(String user) {
        WebElement userDropdown = driver.findElement(usersDropdown);
        Select selectUser = new Select(userDropdown);
        selectUser.selectByVisibleText(user);
    }

    public void selectAssetClass(String assetClass) {
        WebElement assetClassDropdown = driver.findElement(assetClassesDropdown);
        Select selectAssetClass = new Select(assetClassDropdown);
        selectAssetClass.selectByVisibleText(assetClass);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
    
    public boolean isSuccessMessageDisplayed() {
    	return driver.findElement(successMessage).isDisplayed();
    }

    public boolean isPopupClosed() {
        return driver.findElements(usersDropdown).isEmpty();
    }
}

