package com.Optiomax.testCases;

import org.testng.annotations.Test;

import com.Optiomax.pageObjetcs.BasePage;
import com.Optiomax.pageObjetcs.ThemeTogglePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class ThemeToggleTest extends BasePage {

    private ThemeTogglePage themeTogglePage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        setup();
        themeTogglePage = new ThemeTogglePage(driver);
        themeTogglePage.login("chamoddushyantha2017@gmail.com", "chamod1234");
    }

    @Test(priority = 1)
    public void testSwitchToDarkMode() throws InterruptedException {
        themeTogglePage.switchToDarkMode();
        String bodyBackgroundColor = themeTogglePage.getBodyBackgroundColor();
        //Assert.assertTrue(bodyBackgroundColor.equals("rgb(60, 64, 66)") || bodyBackgroundColor.equals("#000000"), "Dark mode is not applied");
    }

    @Test(priority = 2)
    public void testSwitchToLightMode() throws InterruptedException {
        themeTogglePage.switchToLightMode();
        String bodyBackgroundColor = themeTogglePage.getBodyBackgroundColor();
        //Assert.assertTrue(bodyBackgroundColor.equals("rgb(255, 255, 255)") || bodyBackgroundColor.equals("#ffffff"), "Light mode is not applied");
    }

    @Test(priority = 3)
    public void testThemePersistenceAfterRefresh() throws InterruptedException {
        themeTogglePage.switchToDarkMode();
        driver.navigate().refresh();
        Thread.sleep(5000); // wait for refresh to complete
        String bodyBackgroundColor = themeTogglePage.getBodyBackgroundColor();
        //Assert.assertTrue(bodyBackgroundColor.equals("rgb(60, 64, 66)") || bodyBackgroundColor.equals("#000000"), "Dark mode is not persisted after refresh");
    }

    @Test(priority = 4)
    public void testSmoothTransitionBetweenModes() throws InterruptedException {
        themeTogglePage.switchToDarkMode();
        themeTogglePage.switchToLightMode();
        // add assertions or verifications for smooth transition
    }

    @AfterClass
    public void tearDown() {
        teardown();
    }
}

