package com.Optiomax.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Optiomax.pageObjects.BasePage;
import com.Optiomax.pageObjects.DashboardPage;

public class DashboardTest extends BasePage {
    private DashboardPage dashboardPage;

    @BeforeClass
    public void setup() {
        super.setup();
        dashboardPage = new DashboardPage(driver);
        dashboardPage.login("sithum@gmail.com", "chamod1234");
    }

    @Test
    public void verifySidebarOptionsAccessible() throws InterruptedException {
        Thread.sleep(3000);
        dashboardPage.clickSidebarIcon();
        Assert.assertTrue(dashboardPage.isSidebarVisible(), "Sidebar should be visible");
    }

    @Test
    public void verifySidebarVisibilityOnAllPages() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(dashboardPage.isSidebarVisible(), "Sidebar should be visible on all pages");
    }

    @Test
    public void verifySearchBarFunctionality() throws InterruptedException {
        Thread.sleep(3000);
        dashboardPage.search("Search Query");
        // Add assertions to verify search results
    }

    @Test
    public void verifyThemeToggleFunctionality() throws InterruptedException {
        Thread.sleep(3000);
        dashboardPage.toggleTheme();
        Assert.assertTrue(dashboardPage.isDarkModeEnabled(), "Dark mode should persist after page refresh");
    }

    @Test
    public void verifyNotificationsBellFunctionality() throws InterruptedException {
        Thread.sleep(3000);
        dashboardPage.clickNotificationsBell();
        // Add assertions to verify notifications work correctly
    }

    @Test
    public void verifyUserProfileAccess() throws InterruptedException {
        Thread.sleep(3000);
        dashboardPage.accessUserProfile();
        // Add assertions to verify profile access
    }

    @Test
    public void verifyAccessToApps() throws InterruptedException {
        Thread.sleep(3000);
        dashboardPage.clickApps();
        // Add assertions to verify access to apps
    }

    @Test
    public void verifyRoleSubOptionUnderUserManagement() throws InterruptedException {
        Thread.sleep(3000);
        dashboardPage.accessUserManagement();
        dashboardPage.clickRoleSubOption();
        // Add assertions to verify the 'Role' sub-option works correctly
    }

    @Test
    public void verifyUsersSubOptionUnderUserManagement() throws InterruptedException {
        Thread.sleep(3000);
        dashboardPage.accessUserManagement();
        dashboardPage.clickUsersSubOption();
        // Add assertions to verify the 'Users' sub-option works correctly
    }

    @Test
    public void verifyOrganizationSubOptionUnderConfig() throws InterruptedException {
        Thread.sleep(3000);
        dashboardPage.clickOrganizationSubOption();
        // dashboradPage.clickOrganizations
        // Add assertions to verify the 'Organization' sub-option works correctly
    } 
}
