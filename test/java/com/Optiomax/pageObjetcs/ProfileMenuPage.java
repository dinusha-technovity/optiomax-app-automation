package com.Optiomax.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileMenuPage {

    private WebDriver driver;

    public ProfileMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By rememberMeCheckbox = By.id("remember");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");
    private By sidebarIcon = By.xpath("/html/body/main/div/header/nav/div/div[1]/button[1]");
    private By profileImage = By.xpath("/html/body/main/div/header/nav/div/div[3]/button[4]/img");
    private By myProfileOption = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/ul[1]/li[1]/a");
    private By accountSettingsOption = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/ul[1]/li[2]/a");
    private By myLikesOption = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/ul[2]/li[1]/a");
    private By collectionsOption = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/ul[2]/li[2]/a");
    private By signOutOption = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/ul[3]/li/form/button");
    private By userName = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/div/span[1]");
    private By email = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/div/span[2]");
    private By dropdownMenu = By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]");

    public void signIn(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    public void openSidebar() {
        driver.findElement(sidebarIcon).click();
    }

    public boolean isProfileImageDisplayed() {
        return driver.findElement(profileImage).isDisplayed();
    }

    public void clickProfileImage() {
        driver.findElement(profileImage).click();
    }

    public void clickMyProfile() {
        driver.findElement(myProfileOption).click();
    }

    public void clickAccountSettings() {
        driver.findElement(accountSettingsOption).click();
    }

    public void clickMyLikes() {
        driver.findElement(myLikesOption).click();
    }

    public void clickCollections() {
        driver.findElement(collectionsOption).click();
    }

    public void clickSignOut() {
        driver.findElement(signOutOption).click();
    }

    public boolean isUserNameDisplayed() {
        return driver.findElement(userName).isDisplayed();
    }

    public boolean isEmailDisplayed() {
        return driver.findElement(email).isDisplayed();
    }

    public boolean isDropdownMenuDisplayed() {
        return driver.findElement(dropdownMenu).isDisplayed();
    }
}

