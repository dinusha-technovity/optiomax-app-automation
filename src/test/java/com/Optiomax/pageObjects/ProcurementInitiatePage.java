package com.Optiomax.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProcurementInitiatePage {

    private WebDriver driver;

    public ProcurementInitiatePage (WebDriver driver) {
        this.driver = driver;
    }
    
    private By emailField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[1]/div/input");
    private By passwordField = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[2]/div/input");
    private By rememberMeCheckbox = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/div[3]/div/input");
    private By signInButton = By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button");

    private By procurementInitiateCards = By.cssSelector("div[class='grid gap-4 2xl:grid-cols-3 min-[1200px]:grid-cols-2 min-[768px]:grid-cols-2 min-[640px]:grid-cols-1 mb-1 rounded bg-white dark:bg-[#121212]']");
    private By addNewProcurementInitiateButton = By.xpath("//button[normalize-space()='Add new Procurement Initiate']");
    private By searchInput = By.xpath("//input[@id='simple-search']");
    private By noResultsMessage = By.xpath(""); //Enter the error message xpath 
    private By proceedProcurementButtons = By.xpath("/html/body/main/div/div/main/div/div/div[2]/div/div[1]/div[2]/div[3]/a");
    private By closeProcurementInitiate = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[3]/div[2]/div[1]/a");
    private By exportCSVButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/button[1]");
    private By filterButton = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/button[2]");
    private By listViewToggle = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/div[2]/button[2]");
    private By gridViewToggle = By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[3]/div[2]/div/div[2]/button[1]");
    private By paginationNextButton = By.xpath("//button[normalize-space()='Next']");
    private By paginationPreviousButton = By.xpath("//button[normalize-space()='Previous']");
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(rememberMeCheckbox).click();
        driver.findElement(signInButton).click();
    }

    public boolean isPageLoaded() {
    	return driver.getPageSource().contains("procurement_initiate");
    }

    public int getProcurementInitiateCardCount() {
        List<WebElement> cards = driver.findElements(procurementInitiateCards);
        return cards.size();
    }

    public void clickAddNewProcurementInitiate() {
        driver.findElement(addNewProcurementInitiateButton).click();
    }
    
    public void clickCloseProcurementInitiate() {
    	driver.findElement(closeProcurementInitiate).click();
    }

    public void searchProcurementInitiate(String query) {
        driver.findElement(searchInput).sendKeys(query);
    }

    public boolean isNoResultsMessageDisplayed() {
        return driver.findElement(noResultsMessage).isDisplayed();
    }

    public boolean isProcurementInitiatePresent(String name) {
        List<WebElement> cards = driver.findElements(procurementInitiateCards);
        for (WebElement card : cards) {
            if (card.getText().contains(name)) {
                return true;
            }
        }
        return false;
    }

    public void clickProceedProcurement(int index) {
        driver.findElements(proceedProcurementButtons).get(index).click();
    }

    public void searchByProcurementId(String procurementID) {
        WebElement searchBoxElement = driver.findElement(searchInput);
        searchBoxElement.clear();
        searchBoxElement.sendKeys(procurementID);
        searchBoxElement.submit();
    }

    public WebElement getCardDetail(int index, By locator) {
        return driver.findElements(procurementInitiateCards).get(index).findElement(locator);
    }
    
    public void clickExportCSV() {
        driver.findElement(exportCSVButton).click();
    }

    public void clickFilterButton() {
        driver.findElement(filterButton).click();
    }

    public void toggleListView() {
        driver.findElement(listViewToggle).click();
    }

    public void toggleGridView() {
        driver.findElement(gridViewToggle).click();
    }

    public void clickNextPage() {
        driver.findElement(paginationNextButton).click();
    }

    public void clickPreviousPage() {
        driver.findElement(paginationPreviousButton).click();
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
    
}
