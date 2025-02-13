package com.Optiomax.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By rememberMeCheckbox = By.id("remember");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");
    
    private By sidebarIcon = By.xpath("/html/body/main/div/header/nav/div/div[1]/button[1]");
    private By sidebar = By.xpath("/html/body/main/div/div/aside/div");
    private By themeToggle = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[1]/div");
    private By searchBar = By.name("search");
    private By notificationsBell = By.xpath("/html/body/main/div/header/nav/div/div[3]/button[3]");
    private By userProfile = By.xpath("/html/body/main/div/header/nav/div/div[3]/button[4]/img");
    private By apps = By.xpath("/html/body/main/div/header/nav/div/div[3]/button[3]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    public void clickSidebarIcon() {
        driver.findElement(sidebarIcon).click();
    }

    public boolean isSidebarVisible() {
        return driver.findElement(sidebar).isDisplayed();
    }

    public void toggleTheme() {
        driver.findElement(themeToggle).click();
    }

    public boolean isDarkModeEnabled() {
        driver.navigate().refresh();
        return driver.findElement(sidebar).isDisplayed();
    }

    public void search(String query) {
        WebElement searchElement = driver.findElement(searchBar);
        searchElement.sendKeys(query);
        searchElement.submit();
    }

    public void clickNotificationsBell() {
        driver.findElement(notificationsBell).click();
    }
 
    public void accessUserProfile() {
        driver.findElement(userProfile).click();
    }

    public void clickApps() {
        driver.findElement(apps).click();
    }
}
