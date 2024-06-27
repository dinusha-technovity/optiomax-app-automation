package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.ArrayList;

public class AppsMenuPage extends BasePage {

    private WebDriver driver;

    public AppsMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By rememberMeCheckbox = By.id("remember");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    private By menuItemsLocator = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]");
    private By menuItemSales = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[1]");
    private By menuItemUsers = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[2]");
    private By menuItemInbox = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[3]");

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    } 

    public List<String> getMenuItems() {
        List<WebElement> menuItems = driver.findElements(menuItemsLocator);
        List<String> actualOrder = new ArrayList<>();
        for (WebElement menuItem : menuItems) {
            actualOrder.add(menuItem.getText());
        }
        return actualOrder;
    }

    public void clickSalesMenuItem() {
        driver.findElement(menuItemSales).click();
    }

    public void clickUsersMenuItem() {
        driver.findElement(menuItemUsers).click();
    }

    public void clickInboxMenuItem() {
        driver.findElement(menuItemInbox).click();
    }

}
