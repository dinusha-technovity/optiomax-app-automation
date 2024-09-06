package com.Optiomax.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasePage {

    protected WebDriver driver; 

    @BeforeClass
    public void setup() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Janodya\\eclipse-workspace\\OptiomaxAppAutomate\\Resource Files\\Drivers\\chromedriver.exe");

        // Initialize browser
        driver = new ChromeDriver();

        // Open the Optiomax app website
        driver.get("http://app.optiomax.com/");

        // Maximize browser
        driver.manage().window().maximize();               
    } 
 
    @AfterClass
    public void teardown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

