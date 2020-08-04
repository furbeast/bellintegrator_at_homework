package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectGoogleWithSearch {

    private String selectorSearchField = "//input[@name=\"q\" and @class=\"gLFyf gsfi\"]";
    private String selectorSearchButton = "//input[@class=\"gNO89b\"]";
    private String selectorListElement = "h3.LC20lb.DKV0Md";

    private WebDriver driver;

    private WebElement searchField;
    private WebElement searchButton;

    private List<WebElement> result;

    public List<WebElement> getResult() {
        return result;
    }

    public PageObjectGoogleWithSearch(WebDriver driver, String linkName) {
        this.driver = driver;
        driver.get(linkName);
        searchField = driver.findElement(By.xpath(selectorSearchField));
        searchButton = driver.findElement(By.xpath(selectorSearchButton));
    }

    public void find(String query) {
        searchField.click();
        searchField.sendKeys(query);
        searchButton.click();
    }

    public void getListElement() {
        result = driver.findElements(By.cssSelector(selectorListElement));
    }
}
